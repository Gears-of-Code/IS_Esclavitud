/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import mx.gearsofcode.proyservsocial.logico.ConectaDb;

import mx.gearsofcode.proyservsocial.logico.LogicoPackage;

import mx.gearsofcode.proyservsocial.logico.proyectos.Proyecto;
import mx.gearsofcode.proyservsocial.logico.usuarios.Responsable;
import mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado;
import mx.gearsofcode.proyservsocial.logico.util.*;

import com.mysql.jdbc.exceptions.*;
import com.mysql.jdbc.util.*;
import com.mysql.jdbc.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Conecta Db</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ConectaDbImpl extends EObjectImpl implements ConectaDb {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    // variables para conexion

    private static Connection connect;
    private static Statement statement;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "gearsofc_ssocial";
    private static String user = "root";
    private static String password = "enrique";
    
    private static ResultSet resultset = null;

    protected ConectaDbImpl() {
//    protected ConectaDbImpl() throws DBCreationException {
        super();
//        try{
//        connect = cargarBase();
//        statement = connect.createStatement();
//        }catch(Exception e){
//            throw new DBCreationException();
//        }

    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LogicoPackage.Literals.CONECTA_DB;
    }

    /**
     * Metodo que abre la conexion a la Db  
     */
    private static Connection cargarBase() {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url + dbName, user,
                    password);
            System.out.println("Conexión a base de datos OK");

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver MySQL JDBC");
        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexion con " + url);
        }
        return connect;
    }

    /**
     * Metodo que cierra la conexion a la Db
     */
    private static void cerrarBase(Connection c, Statement s) {
        try {
            if (s != null)
                s.close();
            if (c != null)
                c.close();
            System.out.println("Conexión a base de datos cerrada");
        } catch (SQLException sqlex) {
        }
    }

    /**
     * Metodo que muestra proyectos autorizados dependiendo del usuario
     */

    public LinkedList<String[]> 
        verProyectosDb(final int tipoUsuario,  int idUsuario)
    {

        final int ADMI = 0;
        final int RESP = 1;
        final int ALUM = 2;
        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();

        String query = "";

        try {
            
            switch(tipoUsuario) {
    
                case ADMI:
                    query = "SELECT nombre, id_p " +
                            "FROM  proyectos " +
                            "WHERE estado = 1;";
                    resultset = statement.executeQuery(query);
                    break;
    
                case RESP:
                    query = "SELECT nombre, id_p " +
                            "FROM  proyectos " +
                            "WHERE estado = 1 AND" +
                            " id_r ='" + idUsuario + "';";
                    resultset = statement.executeQuery(query);
                    break;
    
                case ALUM:
                    query = "SELECT nombre, id_p " +
                            "FROM  proyectos " +
                            "WHERE estado = 1;";
                    resultset = statement.executeQuery(query);
                    break;
    
                default:      
                    System.out.println("Tipo de usuario no valido");            
                    break;
            }
            
            listaDeProyectos = getIdxNombre (resultset);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarBase(connect,statement);
        }
        return listaDeProyectos;
    }

    /**
     * Metodo que muestra proyectos no autorizados dependiendo del usuario
     * No se lanza ninguna excepcion porque el usuario no puede tener ningun proyecto.
     */
    public LinkedList<String[]> verMisProyectosDb(final int tipoUsuario,final int idUsuario) {

        final int ADMI = 0;
        final int RESP = 1;
        final int ALUM = 2;
        
        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();
        String query = "";

        Connection connect = null;
        Statement statement = null;
        ResultSet resultset = null;
        
        try{
            connect = cargarBase();
            statement = connect.createStatement();
            
            switch (tipoUsuario) {
                case ADMI:
                    query = "SELECT nombre, id_p FROM  proyectos WHERE estado = 0;";
                    resultset = statement.executeQuery(query);
                    break;
    
                case RESP:
                    query = "SELECT nombre, id_p FROM  proyectos "
                            + "WHERE estado = 0 AND" + " id_u =" + idUsuario
                            + ";";
                    resultset= statement.executeQuery(query);
                    break;
    
                case ALUM:
                    query = "SELECT nombre, proyectos.id_p "
                            + "FROM  proyectos, postulados "
                            + "WHERE postulados.estado = 0 " + "AND id_u = "
                            + idUsuario + ";";
                    resultset = statement.executeQuery(query);
                    break;
            }
            listaDeProyectos = getIdxNombre(resultset);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            cerrarBase(connect, statement);
        }
        
        return listaDeProyectos;
    }

    /**
     * <!--Da los detalles de un proyecto-->
     * <!-- regresa arreglo de 10 Strings-->
     * [0] -> id proyecto
     * [1] -> nombre  responsable
     * [2] -> nombre  proyectos
     * [3] -> areas de conocimientos
     * [4] -> carreras
     * [5] -> email del poyecto
     * [6] -> telefono del poyecto 
     * [7] -> direccion del poyecto
     * [8] -> maximo Participantes 
     * [9] -> Descripcion del problema
     */
    public ResultSet verDetallesProyectoDb(final int idProyecto) {
        
        String query = "SELECT DISTINCT *"
                + "FROM proyectos, areasconocimiento, proyac, carreras, proycarr, usuarios "
                + "WHERE id_p = " + idProyecto + ";";
        try{
            resultset = statement.executeQuery(query);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resultset;
    } 

    /**

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void proponerProyectoDb(final Proyecto proy) 
            throws DBCreationException{
        
        try {

            int id_u = proy.getId();
            int telefono = proy.getTelefono();
            int maxParticipantes = proy.getMaxParticipantes();
            int [] id_ac = proy.getAreaConocimiento();
            int[] carreras = proy.getCarreras();    
            String descripcion = proy.getDescripcion();
            String estado = "0"; // No autorizado.
            String direccion = proy.getDireccion();
            String nombre = proy.getNombre();
            String email = proy.getEmail();
            
            String update = "";

            update = "INSERT INTO proyectos (id_u,nombre,email,telefono,direccion,"
                    + "maxParticipantes,descripcion,estado) VALUES ("
                    + id_u+ ",'"
                    + nombre+ "','"
                    + email+ "',"
                    + telefono+ ",'"
                    + direccion+ "',"
                    + maxParticipantes + ",'"
                    + descripcion
                    + "'," + estado + ");";

            if (statement.executeUpdate(update) == 0)
                throw new DBCreationException();
             

            int id_p = statement.executeQuery("SELECT LAST_INSERT_ID();").getInt(1);

            // Areas
            update = "INSERT INTO proyac (id_p,id_ac) VALUES";
            update += getPairValues(id_p, id_ac); // Regresa el par de valores a
                                                  // agregar al la talba proyac

            if (statement.executeUpdate(update) == 0)
                throw new DBCreationException();

            // Careers
            update = "INSERT INTO proycarr (id_p,id_c) VALUES ";
            update += getPairValues(id_p, carreras);

            if (statement.executeUpdate(update) == 0)
                throw new DBCreationException();

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }

    /**
     * el administrador autoriza un proyecto
     */
    public void autorizarProyectoDb(final int idProyecto) 
            throws DBModificationException{
        
        final int AUTO = 1;

        String query = "UPDATE proyectos SET estado = " + AUTO
                + "WHERE id_p = '" + idProyecto + "';";

        try {
            if (statement.executeUpdate(query) == 0)
                throw new DBModificationException();
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } finally {
            cerrarBase(connect, statement);
        }
    }

    /**
     * el administrador rechaza un proyecto y es eliminado de la db
     */
    public void rechazarProyectoDb(final int idProyecto) 
            throws DBModificationException{

        String query = "DELETE FROM proyectos "+ 
                "WHERE id_p = '" + idProyecto + "';";
        
        try{
            if (statement.executeUpdate(query)==0) ;
                throw new DBModificationException();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void postularAProyectoDb(final int idProyecto, final int idAlumno) 
            throws DBModificationException{
        
        final int NOAUTO = 0;

        
        String query = "INSERT INTO postulados (id_p, id_u, estado) VALUES ("+
                    idProyecto +"," + idAlumno + "," + NOAUTO +");";
        
        try{
            if(statement.executeUpdate(query) == 0)
                throw new DBModificationException();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

            
    }


    /**
     * Re-escribir.
     * Lista de alumnos postulados a un proyecto
     */
    public LinkedList<String[]> verPostuladosDb(final int idProyecto) 
            throws DBConsultException {

        String query = "SELECT postulados.id_u,usuarios.nombre "
                + "FROM  postulados, usuarios, alumnos "
                + "WHERE alumnos.estado = '0' AND " + " id_p = '" + idProyecto
                + "';";
        
        LinkedList<String[]> listaPos = new LinkedList<String[]>();

        try {
            connect = cargarBase();
            statement = connect.createStatement();
            resultset = statement.executeQuery(query);
            
            
            
            //Posible optimizacion.
            String vector[];

            while(resultset.next()) {
                vector = new String[2];
                vector[0] = resultset.getString("postulados.id_u");
                vector[1] = resultset.getString("usuarios.nombre");
                listaPos.add(vector);    
            }
            
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage()); 
        } finally {
            cerrarBase(connect, statement);
        }
        return listaPos;

        // throw new UnsupportedOperationException();
    }

    /**
     * Acepta a un alumno a un proyecto dependiendo del tipo de usuario
     */
    public void aceptarAlumnoProyectoDb(final int idProyecto, final int idAlumno)
            throws DBModificationException{

        String query = "UPDATE postulados " + "SET estador = 1 "
                + "WHERE id_u = '" + idAlumno + "'"
                + "AND id_p = '"+ idProyecto +";";
        
        try{
            if ( statement.executeUpdate(query) ==  0)
                    throw new DBModificationException();
            if (estadoA(idAlumno) == 1)
                borraPostulaciones(idAlumno);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void autorizarAlumnoProyecto(final int idAlumno, final int idProyecto) 
            throws DBModificationException{
        
        String query = "UPDATE postulados " + "SET estadoa = 1 "
                + "WHERE id_u = " + idAlumno 
                + "AND id_p = '"+ idProyecto +";";
        
        try{
            if ( statement.executeUpdate(query) ==  0)
                    throw new DBModificationException();
            if (estadoR(idAlumno) == 1)
                borraPostulaciones(idAlumno);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    

    private void borraPostulaciones(int idAlumno) {
        
        
    }

    /**
     * <!-- rechaza Alumno de un Proyecto --> <!-- end-user-doc -->
     * 
     */
    public void rechazaAlumnoProyectoDb(final int idProyecto, final int idAlumno) 
        throws DBModificationException
        {
        
        String query = "DELETE FROM postulados " + "WHERE id_p = '"
                + idProyecto + "' AND id_u = '" + idAlumno + "';";
        
        try {
            if ( statement.executeUpdate(query) == 0)
                throw new DBModificationException();
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void registrarDb(final Responsable repo) 
    throws DBCreationException{
        
        int id_u = 0;
        
        try {
            String update = insertaUsuario(repo);

            if (statement.executeUpdate(update) == 0)
                throw new DBCreationException();
            
            id_u = statement.executeQuery("LAST_INSERT_ID()").getInt(1);
            
            update = insertaResponsable(repo, id_u);
            if (statement.executeUpdate(update) == 0)
                throw new DBCreationException();
            
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }
    
    

    /**
     * acepta a un responsable
     */
    public void aceptarResponsableDb(final int idResponsable) 
            throws DBModificationException{

        String query = "UPDATE responsables SET estado = 1"
                + " WHERE id_u = '" + idResponsable + "';";

        try {
            if (statement.executeUpdate(query) == 0)
                throw new DBModificationException();
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * <!-- Rechaza a un Responsable --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void rechazaResponsableDb(final int idResponsable)
        throws DBModificationException{
        
        String query = "DELETE FROM responsables " + "WHERE id_u  = '"
                + idResponsable + "';";

        try {
            if (statement.executeUpdate(query) == 0)
                throw new DBModificationException();
            
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * <!-- validar Usuario--> <!-- regresa arreglo de tres enteros |tipo
     * Usu|id_u|estado| de no existir tipo Usu = "-1"-->
     * 
     */
    public ResultSet validaUsuarioDb(final String nombreUsuario,
            final String password){
        String query = "SELECT * " + "FROM usuarios, alumnos,responsables "
                + "WHERE username = '" + nombreUsuario + "' "
                + "AND contrasena='" + password + "';";

        try {
            resultset = statement.executeQuery(query);

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
        return resultset;
    }
    
    public void modificarEstadoAlumno(final int idAlumno, final boolean estadoAlumno) 
            throws DBModificationException{
        
        int estado = 0;
        if (estadoAlumno)
            estado = 1;
        
        String query = "UPDATE alumno SET estado =  " + estado +" WHERE id_u = "+ idAlumno +";";
        
        try{
            if (statement.executeUpdate(query) == 0)
                throw new DBModificationException();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    
    }

    /**
     * 
     */
    private String getPairValues(int id, int[] dataArray){

        String coma = ",";
        String result = "";
        for (int i = 0; i< dataArray.length; i++){
            if ( (i+1) == dataArray.length)
                coma = ";";
            result += "(" +id + "," + dataArray[i] +")" + coma;
        }
        // Hay que separar cada (id,idcar) por una coma
        // por eso no se puede usar esta iteración.
        //        for (int idCar : dataArray) {
        //            result = result + "(" + id + "," + idCar + ")";
        //        }
        //        result = result + ";";

        return result;
    }


    private String insertaUsuario(final UsuarioRegistrado usuario) {
        String nombreUsuario = usuario.getUsername();
        String contrasena = usuario.getContraseña();
        int tipo = usuario.getTipo();
        String nombre = usuario.getNombre();
        String telefono = usuario.getTelefono();
        String email = usuario.getEmail();
        int activado = 0; // No autorizado.
        String update = "INSERT INTO usuarios (username,contrasena,tipo,nombre,"
                + "telefono,email,activado) VALUES ("
                + "'" +nombreUsuario + "','" + contrasena + "',"
                + tipo + ",'" + nombre + "',"
                + telefono + ",'" + email + "'," 
                + activado + ");";

        return update;
    }

    private String insertaResponsable(final Responsable resp,
            final int idUsuario) {
        String descripcion = resp.getDescripcion();
        String sitioweb = resp.getSitioweb();
        int estado = 0; // No autorizado

        String update = "INSERT INTO responsables (id_u,descripcion,sitioweb,"+
                "estado) VALUES (" 
                + idUsuario + ",'" + descripcion + "','" 
                + sitioweb + "'," + estado + ");";
        return update;
    }
    
    private LinkedList<String[]> getIdxNombre(ResultSet rs) throws SQLException {
        
        LinkedList<String[]> lista = new LinkedList<String[]>();
        String[] idxnombre = null;
        
        while (rs.next()) {
            idxnombre = new String[2];
            idxnombre[0] = Integer.toString(rs.getInt("id_p"));
            idxnombre[10] = rs.getString("nombre");
            lista.add(idxnombre);
        }
        
        return lista;
    }
    
    private int estadoA(int idAlumno) {
        return estadoAR (idAlumno, "estadoa");
    }

    private int estadoR(int idAlumno) {
        return estadoAR(idAlumno, "estador");
    }
    
    private int estadoAR(int idAlumno, String AR){
        
        String query = "SELECT postulados ("+ AR +") WHERE id_u=" +idAlumno +");";
        int estado = -1;
        
        try{
            resultset = statement.executeQuery(query);
            estado = resultset.getInt("estadoa");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return estado;
    
    }

    /**
     * Creates a new instance of the specified Ecore class. 
     * 
     * @param eClass The Ecore class of the instance to create.
     * @return The new instance.
     * @generated
     */
    protected EObject create(EClass eClass) {
        return EcoreUtil.create(eClass);
    }

} // ConectaDbImpl

