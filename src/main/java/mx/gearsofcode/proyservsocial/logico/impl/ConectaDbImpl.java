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
import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

import com.mysql.jdbc.exceptions.*;
import com.mysql.jdbc.util.*;
import com.mysql.jdbc.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conecta Db</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConectaDbImpl extends EObjectImpl implements ConectaDb {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    
  //variables para conexion
    private static Connection dbConnect;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "gearsofc_ssocial";
    private static String user = "root";
    private static String password = "enrique";
    
    protected ConectaDbImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LogicoPackage.Literals.CONECTA_DB;
    }
    
    /**
     * Metodo que Abre la conexion a la Db  
     */
    public static Connection cargarBase() {
        try {
            Class.forName(driver);
            dbConnect = DriverManager.getConnection(url + dbName, user , password);
            System.out.println("Conexión a base de datos OK");
            } 
            catch (ClassNotFoundException ex) {
                    System.out.println("Error cargando el Driver MySQL JDBC");
            }
            catch (SQLException ex) {
                   System.out.println("Imposible realizar conexion con "+url);
                    }
        return dbConnect;
         } 
    
    /**
     * Metodo que Sierra la conexion a la Db  
     */
    public static void cerrarBase(Connection c, Statement s ) {
        try{
            if (s != null) s.close();
            if (c != null) c.close();
            System.out.println("Conexión a base de datos cerrada");
        }
        catch (SQLException sqlex){}
    
    }
    
    /**
     * Metodo que muestra proyectos autorizados dependiendo del usuario    
     */
    public static LinkedList<String[]> verProyectosDb(final int tipoUsuario, final int idUsuario) {
        
        final int ADMI = 0;
        final int RESP = 1;
        final int ALUM = 2;
        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();

        switch(tipoUsuario){
        
            case ADMI:
                Connection dbConnect = null ;
                Statement dbStatement = null;
                ResultSet dbRS = null;
                String query = "SELECT nombre, id_p " +
                "FROM  proyectos " +
                "WHERE estado = '1';";

            try{
                dbConnect = cargarBase();
                dbStatement = dbConnect.createStatement();
                dbRS = dbStatement.executeQuery(query);
                
                String vector[];
                
                while(dbRS.next())
                {
                    vector = new String[2];
                    int a = dbRS.getInt("id_p");
                    String aS = Integer.toString(a);
                    vector[0] = aS;
                    vector[10] = dbRS.getString("nombre");
                    
                    listaDeProyectos.add(vector);    
                }
                
            }catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect, dbStatement);
            }
            break;

            case RESP:
                Connection dbConnect1 = null ;
                Statement dbStatement1 = null;
                ResultSet dbRS1 = null;
                String query1 = "SELECT nombre, id_p " +
                        "FROM  proyectos " +
                        "WHERE estado = '1' AND" +
                        " id_r ='" + idUsuario + "';";

                try{
                    dbConnect1 = cargarBase();
                    dbStatement1 = dbConnect1.createStatement();
                    dbRS1 = dbStatement1.executeQuery(query1);
                    
                    String vector[];
                    
                    while(dbRS1.next())
                    {
                        vector = new String[2];
                        int a = dbRS1.getInt("id_p");
                        String aS = Integer.toString(a);
                        vector[0] = aS;
                        vector[1] = dbRS1.getString("nombre");
                        
                        listaDeProyectos.add(cadena);    
                    }
                    
                }catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect1, dbStatement1);
                }
                break;

            case ALUM:
                Connection dbConnect2 = null ;
                Statement dbStatement2 = null;
                ResultSet dbRS2 = null;
                String query2 = "SELECT nombre, id_p " +
                        "FROM  proyectos " +
                        "WHERE estado = '1';";

                    try {
                        dbConnect2 = cargarBase();
                        dbStatement2 = dbConnect2.createStatement();
                        dbRS2 = dbStatement2.executeQuery(query2);
                        
                        String vector[];
                        
                        while(dbRS2.next())
                        {
                            vector = new String[2];
                            int a = dbRS2.getInt("id_p");
                            String aS = Integer.toString(a);
                            vector[0] = aS;
                            vector[10] = dbRS2.getString("nombre");
                            
                            listaDeProyectos.add(vector);    
                        }
                    
                    }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect2, dbStatement2);
                }
            break;
        
            default:      
                System.out.println("Tipo de usuario no valido");            
            break;
        }
        return listaDeProyectos;
         }


    /**
     * Metodo que muestra proyectos no autorizados dependiendo del usuario    
     */
    public static LinkedList<String[]> verMisProyectosDb(final int tipoUsuario, final int idUsuario) {
        
        final int ADMI = 0;
        final int RESP = 1;
        final int ALUM = 2;
        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();

        switch(tipoUsuario){
        
            case ADMI:
                Connection dbConnect = null ;
                Statement dbStatement = null;
                ResultSet dbRS = null;
                String query = "SELECT nombre, id_p " +
                "FROM  proyectos " +
                "WHERE estado = '0';";

            try{
                dbConnect = cargarBase();
                dbStatement = dbConnect.createStatement();
                dbRS = dbStatement.executeQuery(query);
                
                String vector[];
                
                while(dbRS.next())
                {
                    vector = new String[2];
                    int a = dbRS.getInt("id_p");
                    String aS = Integer.toString(a);
                    vector[0] = aS;
                    vector[10] = dbRS.getString("nombre");
                    
                    listaDeProyectos.add(vector);    
                }
                
            }catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect, dbStatement);
            }
            break;

            case RESP:
                Connection dbConnect1 = null ;
                Statement dbStatement1 = null;
                ResultSet dbRS1 = null;
                String query1 = "SELECT nombre, id_p " +
                        "FROM  proyectos " +
                        "WHERE estado = '0' AND" +
                        " id_r ='" + idUsuario + "';";

                try{
                    dbConnect1 = cargarBase();
                    dbStatement1 = dbConnect1.createStatement();
                    dbRS1 = dbStatement1.executeQuery(query1);
                    
                    String vector[];
                    
                    while(dbRS1.next())
                    {
                        vector = new String[2];
                        int a = dbRS1.getInt("id_p");
                        String aS = Integer.toString(a);
                        vector[0] = aS;
                        vector[10] = dbRS1.getString("nombre");
                        
                        listaDeProyectos.add(vector);    
                    }
                    
                }catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect1, dbStatement1);
                }
                break;

            case ALUM:
                Connection dbConnect2 = null ;
                Statement dbStatement2 = null;
                ResultSet dbRS2 = null;
                String query2 = "SELECT nombre, proyectos.id_p " +
                        "FROM  proyectos, postulados " +
                        "WHERE postulados.estado = '0' " +
                        "AND id_u = '" + idUsuario + "';";
                

                    try {
                        dbConnect2 = cargarBase();
                        dbStatement2 = dbConnect2.createStatement();
                        dbRS2 = dbStatement2.executeQuery(query2);
                        
                        String vector[];
                        
                        while(dbRS2.next())
                        {
                            vector = new String[2];
                            int a = dbRS2.getInt("proyectos.id_p");
                            String aS = Integer.toString(a);
                            vector[0] = aS;
                            vector[10] = dbRS2.getString("nombre");
                            
                            listaDeProyectos.add(vector);    
                        }
                    
                    }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect2, dbStatement2);
                }
            break;
        
            default:      
                System.out.println("Tipo de usuario no valido");            
            break;
        }
        return listaDeProyectos;
         }
 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void proponerProyectoDBb(final Proyecto proy) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        try
        {
        Connection con = cargarBase();
        Statement statement = con.createStatement();
        ResultSet resultset = null;
        
        int id_p = 0;
        int id_u = proy.getId();
        int telefono = proy.getTelefono();
        int maxParticipantes = proy.getMaxParticipantes();
        int[] id_ac = proy.getAreaConocimiento();
        int[] carreras = proy.getCarreras();    
        String descripcion = proy.getDescripcion();
        String estado = "0"; //noaurorizado.
        String direccion = proy.getDireccion();
        String nombre = proy.getNombre();
        String email = proy.getEmail();
        
        String update = "";
        
        
        update = "INSERT INTO proyectos (id_u,nombre,email,telefono,direccion,"+
                "maxParticipantes,descripcion,estado) VALUES ("+
                id_u + "," +
                nombre + "," +
                email + "," +
                telefono + "," +
                direccion + "," +
                maxParticipantes + "," +
                descripcion + "," +
                estado + ");";
        
        System.out.println("Agregando el proyecto \"" + nombre + "\"...");  
        statement.executeUpdate(update);
        System.out.println("El proyecto \"" + nombre + "\" se agrego con exito.");
        
        id_p = statement.executeQuery("LAST_INSERT_ID()").getInt(1);
        
        //Areas
        update = "INSERT INTO proyac (id_p,id_ac) VALUES";
        update += getPairValues(id_p,id_ac); // Regresa el par de valores a agregar al la talba proyac

        System.out.println("Agregando areas asociadas con el proyecto \"" +
                            nombre + "\"");
        statement.executeQuery(update);
        System.out.println("Areas asociadas al proyecto \"" + nombre + " '" +
                            "agragadas");
        
        //Carreras                  
        update = "INSERT INTO proycarr (id_p,id_c) VALUES ";
        update += getPairValues(id_p,carreras);
        
        System.out.println("Agregando carreras asociadas con el proyecto \"" +
                            nombre + "\"");
        statement.executeQuery(update);
        System.out.println("Areas carreras al proyecto \"" + nombre + " '" +
                            "agragadas");
                            
        }
        catch (SQLException sqlex)
        {
            System.out.println(sqlex.getMessage()); 
        }
        finally{
            cerrarBase(con,statement);
        }
    }

    /**
     *el administrador autoriza un proyecto
     */
    public void autorizarProyectoDb(final int idProyecto){
        
        Connection dbConnect = null ;
            Statement dbStatement = null;
            int dbRS; 
            
            String query = "UPDATE proyectos " +
                    "SET estado = 1 " +
                    "WHERE id_p = '" + idProyecto + "';";
            
            try {
                dbConnect = cargarBase();
                dbStatement = dbConnect.createStatement();
                dbRS = dbStatement.executeUpdate(query);
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect, dbStatement);
            }
    }

    /**
     * el administrador rechaza un proyecto y es eliminado de la db
     */
    public void rechazarProyectoDb(final int idProyecto) {
        
        Connection dbConnect = null ;
        Statement dbStatement = null;
        int dbRS; 
        
        String query = "DELETE FROM proyectos " +
                "WHERE id_p = '"+ idProyecto + "';";
        
        try {
            dbConnect = cargarBase();
            dbStatement = dbConnect.createStatement();
            dbRS = dbStatement.executeUpdate(query);
        }
        catch (SQLException sqlex){
            System.out.println(sqlex.getMessage()); 
        }
        finally{
            cerrarBase(dbConnect, dbStatement);
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Lista de alumnos postulados a un proyecto
     */
    public static LinkedList<String[]> verPostuladosDb(final int idProyecto) {
        
        Connection dbConnect = null ;
        Statement dbStatement = null;
        ResultSet dbRS = null;
        LinkedList<String[]> listaPos = new LinkedList<String[]>();
        String query = "SELECT postulados.id_u,usuarios.nombre " +
                "FROM  postulados, usuarios, alumnos " +
                "WHERE alumnos.estado = '0' AND " +
                " id_p = '" + idProyecto + "';";
        
        try{
            dbConnect = cargarBase();
            dbStatement = dbConnect.createStatement();
            dbRS = dbStatement.executeQuery(query);
            
            String vector[];
            
            while(dbRS.next())
            {
                vector = new String[2];
                int a = dbRS.getInt("postulados.id_u");
                String aS = Integer.toString(a);
                vector[0] = aS;
                vector[10] = dbRS.getString("usuarios.nombre");
                
                listaPos.add(vector);    
            }
            
            
        }catch (SQLException sqlex){
            System.out.println(sqlex.getMessage()); 
        }
        finally{
            cerrarBase(dbConnect, dbStatement);
        }
        return listaPos;

        //throw new UnsupportedOperationException();
    }

    /**
     *Acepta a un alumno a un proyecto dependiendo del tipo de usuario 
     */
    public static void aceptarAlumnoProyectoDb(final int tipoUsuario ,final int idProyecto, final int idAlumno) {
        
        final int ADMI = 0;
        final int RESP = 1;
         
        switch(tipoUsuario){
        
        case ADMI:
            
            Connection dbConnect = null ;
            Statement dbStatement = null;
            int dbRS;
            String query = "UPDATE alumnos " +
                    "SET estado = 1 " +
                    "WHERE id_u = '" + idAlumno + "';";
                
                try {
                    dbConnect = cargarBase();
                    dbStatement = dbConnect.createStatement();
                    dbRS = dbStatement.executeUpdate(query);
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect, dbStatement);
                }  
        break;
        
        case RESP:
            Connection dbConnect1 = null ;
            Statement dbStatement1 = null;
            int dbRS1;
            String query1 = "UPDATE postulados " +
                    "SET estado = 1 " +
                    "WHERE id_p = '" + idProyecto + "'" +
                    "AND id_u = '" + idAlumno+ "';";
            
            try {
                dbConnect1 = cargarBase();
                dbStatement1 = dbConnect1.createStatement();
                dbRS1 = dbStatement1.executeUpdate(query1);
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect1, dbStatement1);
            }   
        break;
        
         default:      
                System.out.println("Tipo de usuario no valido");            
        break;
        } 
        
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void registrarDb(final Responsable repo) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        
        int id_u = 0;
        try
        {
        Connection con = cargarBase();
        Statement statement = con.createStatement();
        ResultSet resultset = null;
        
        update = insertaUsuario(repo);
        
        statement.executeUpdate(update);
        id_u = statment.executeUpdat("LAST_INSERT_ID()").getInt(1);
        
        update = insertaResponsable(repo, id_u);
        statment.executeUpdate(update);
        }
        catch (SQLException sqlex)
        {
            System.out.println(sqlex.getMessage()); 
        }
        finally{
            cerrarBase(con,statement);
        }
    }

    /**
     * acepta a un responsable
     */
    public void aceptarResponsableDb(final int idResponsable) {
        Connection dbConnect = null ;
        Statement dbStatement = null;
        int dbRS; 
        
        String query = "UPDATE responsables " +
                "SET estado = 1" +
                " WHERE id_u = '" + idResponsable+ "';";
        
        try {
            dbConnect = cargarBase();
            dbStatement = dbConnect.createStatement();
            dbRS = dbStatement.executeUpdate(query);
        }
        catch (SQLException sqlex){
            System.out.println(sqlex.getMessage()); 
        }
        finally{
            cerrarBase(dbConnect, dbStatement);
        }
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- rechaza Alumno de un Proyecto -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void rechazaAlumnoProyectoDb(final int idProyecto, final int idAlumno) {
        Connection dbConnect = null ;
        Statement dbStatement = null;
        int dbRS; 
        String query = "DELETE FROM postulados " +
                    "WHERE id_p = '" + idProyecto + 
                    "' AND id_u = '"+ idAlumno + "';";
            
            try {
                dbConnect = cargarBase();
                dbStatement = dbConnect.createStatement();
                dbRS = dbStatement.executeUpdate(query);
                
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect, dbStatement);
            }
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- Rechaza a un Responsable -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void rechazaResponsableDb(final int idResponsable) {
        Connection dbConnect = null ;
        Statement dbStatement = null;
        int dbRS; 
        String query = "DELETE FROM responsables " +
                    "WHERE id_u  = '" + idResponsable + "';";
            
            try {
                dbConnect = cargarBase();
                dbStatement = dbConnect.createStatement();
                dbRS = dbStatement.executeUpdate(query);
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage()); 
            }
            finally{
                cerrarBase(dbConnect, dbStatement);
            }
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void postularAProyectoDb(final int idProyecto, final int idAlumno) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- validar Usuario-->
     * <!-- regresa arreglo de tres enteros  |tipo Usu|id_u|estado| de no existir tipo Usu = "-1"-->
     * @generated
     */
     public Integer[] validaUsuarioDb(final String nombreUsuario, final String password) {
            
        Connection dbConnect = null ;
        Statement dbStatement = null;
        ResultSet dbRS = null;
        Integer  result[];
        result = new Integer[3];
        String query = "SELECT * " +
                       "FROM usuarios, alumnos,responsables " +
                       "WHERE username = '" + nombreUsuario+ "' " +
                       "AND contrasena='" + password + "';";   
        String adm = "adminitrador";
        String res = "responsable";
        String alu = "alumno";
        Integer id_u = null;
        String tipo = null;
   
            try {
                    dbConnect = cargarBase();
                    dbStatement = dbConnect.createStatement();
                    dbRS = dbStatement.executeQuery(query);
                    
                    if(!dbRS.next()) {
                        result[0] = new Integer(-1);
                        result[1] = new Integer(0);
                        result[2] = new Integer(0);                 
                    }
                    else{
                        id_u = dbRS.getInt("id_u");
                        tipo = dbRS.getString("tipo");          
            
                        
                            if (adm.equals(tipo)){
                                result[0] = new Integer(0);
                                result[1] = new Integer(id_u);
                                result[2] = new Integer(1);
                                }
                            
                            if(res.equals(tipo)){
                                int estRes = dbRS.getInt("responsables.estado");
                                result[0] = new Integer(1);
                                result[1] = new Integer(id_u);
                                result[2] = new Integer(estRes);
                                }
                            
                            if(alu.equals(tipo)){
                                int esAlu = dbRS.getInt("alumnos.estado");
                                result[0] = new Integer(2);
                                result[1] = new Integer(id_u);
                                result[2] = new Integer(esAlu);
                            }   
                    }
            }   
                    
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage()); 
                }
                finally{
                    cerrarBase(dbConnect, dbStatement);
                }
            
            return result;
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
     public static LinkedList<Object> verDetalleProyectoDb(final int idProyecto) {
            
            Connection dbConnect = null ;
               Statement dbStatement = null;
               ResultSet dbRS = null;
               String   result[];
               result = new LinkedList();
               String query =  "SELECT * " +
                       "FROM proyectos, areasconocimiento, carreras, usuarios " +
                       "WHERE id_p = '" + idProyecto + "';";
               try {
                   dbConnect = cargarBase();
                   dbStatement = dbConnect.createStatement();
                   dbRS = dbStatement.executeQuery(query);
                   
                   if(!dbRS.next()) {
                       //int aInt = 1;
                       //String aString = Integer.toString(aInt);         
                       result[0] = new String("-1");                   
                   }
                   else{
                       int a = dbRS.getInt("id_p");
                       String aS = Integer.toString(a);
                       result[0] = new String(aS);                                             //id proyecto 
                       result[1] = new String(dbRS.getString("usuarios.nombre"));              //nombre  responsable
                       result[2] = new String(dbRS.getString("proyectos.nombre"));             //nombre  proyectos
                       result[3] = getIdsAreasConocimiento(idProyecto);//regresa una arreglo id de areas     //nombre  area de conocimiento
                       result[4] = getIdsCarreras(idProyecto);      //nombre  carreras
                       result[5] = new String(dbRS.getString("proyectos.email"));              //email del poyecto 
                       result[6] = new String(dbRS.getString("proyectos.telefono"));           //telefono del poyecto 
                       result[7] = new String(dbRS.getString("proyectos.direccion"));          //direccion del poyecto
                       int max = dbRS.getInt("proyectos.maxParticipantes");
                       String amax = Integer.toString(max);
                       result[8] = new String(amax);                                           //maximo Participantes                                      
                       result[9] = new String(dbRS.getString("proyectos.descripcion"));        //DEscripcion del problema  
                   }
                   
           }       
               catch (SQLException sqlex){
                   System.out.println(sqlex.getMessage()); 
               }
               finally{
                   cerrarBase(dbConnect, dbStatement);
               }
           
           return result;
    } 
    
    
    

    /**
     * Creates a new instance of the specified Ecore class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param eClass The Ecore class of the instance to create.
     * @return The new instance.
     * @generated
     */
    protected EObject create(EClass eClass) {
        return EcoreUtil.create(eClass);
    }

    private String getPairValues(int id, int[] a){
    
        String coma = ",";
        String result = "";
        for (int i = 0; i< a.length; i++){
            if ( (i+1) == a.length)
                coma = ";";
            result += "(" +id + "," + a[i] +")" + coma;
        }
        
        return result;
    }
    


    private String insertaUsuario(final UsuarioRegistrado usuario)
    {
        String nombreUsuario = usuario.getUsername();
        String contrasena = usuario.getContraseña();
        String tipo = Integer.toString(usuario.getTipo());
        String nombre = usuario.getNombre();
        String telefono = usuario.getTelefono();
        String email = usuario.getEmail(); 
        String activado = "0"; //noAutorizado.
        String update = "INSERT INTO usuarios (username,contrasena,tipo,nombre,"+
                            "telefono,email,activado) VALUES ("+
                            nombreUsuario + "," +
                            contrasena + "," +
                            tipo + "," +
                            nombre + "," +
                            telefono + "," +
                            email + "," +
                            activado + ");";
        return update;
    }

    private String insertaResponsable(final Responsable resp, final int idUsuario)
    {
        String descripcion = resp.getDescripcion();
        String sitioweb = resp.getSitioweb();
        String estado = "0"; //noAutorizado
        
        String update = "INSERT INTO responsables (id_u,descripcion,sitioweb,"+
                    "estado) VALUES (" + idUsuario + "," +
                                        descripcion + ","+
                                        sitioweb + ","+
                                        estado + ");";
        return update;
    }

} //ConectaDbImpl

