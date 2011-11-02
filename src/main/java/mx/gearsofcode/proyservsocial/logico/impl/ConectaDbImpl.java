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
import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.TipoUsuario;

import mx.gearsofcode.proyservsocial.logico.util.DBConsultException;
import mx.gearsofcode.proyservsocial.logico.util.DBCreationException;
import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Clase que se encarga de manejar las conexiones a la base de
 * datos del proyecto, aqui se hacen todas las sentencias SQL
 * y se pasan al servidor de la base de datos para procesarlas.
 *
 */
public class ConectaDbImpl extends EObjectImpl implements ConectaDb {
  
    // Variables para conexion.
    private static Connection connect;
    private static Statement statement;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "gearsofc_ssocial";
    private static String user = "gearsofc_ssocial";
    private static String password = "gearsofwar";

    // Variables para estados de los proyectos y usuarios.
    final private int NO_AUTO = 0;
    final private int AUTO = 1;

    /**
     * Variable usada para almacenar los resultados de un query.
     */
    private static ResultSet resultset = null;

    /**
     * Constructor que crea una conección a la base de datos y un statement
     * para ejecutar queries y updates.
     */
    public ConectaDbImpl() throws DBCreationException {
        try {
            connect = cargarBase();
            statement = connect.createStatement();
        } catch (Exception e) {
            throw new DBCreationException();
        }
    }

    /**
     * Constructor que crea una conección con la base de datos segun los
     * parametros proporcionados. Además de un statement
     * para ejecutar queries y updates.
     *
     * @param usuario Nombre del usuario en la base de datos.
     * @param password Passwor del usuario en la base de datos.
     * @param nombre_db Nombre de la base de datos.
     * @param url Direccion de la base de datos (como lo indica JDBC).
     * @throws DBCreationException Se lanza si existe un error al conectarse con la
     * base de datos.
     */
    // ¿¿¿¿¿¿¿ESTE CONSTRUCTOR COMO PARA QUE LO NECESITAMOS???????.
    // Yo lo pense porque, cuando subamos el proyecto al servidor, tendremos que
    // cambiar varios datos. Y si modificamos las variables del proyecto
    // tendremos que compilar y empaquetar de nuevo.
    public ConectaDbImpl(String usuario,
                         String password,
                         String nombre_db,
                         String url) throws DBCreationException{
        this.user = usuario;
        this.password = password;
        this.dbName = nombre_db;
        this.url = url;

        try{
            connect = cargarBase();
            statement = connect.createStatement();
        }catch(Exception e){
            throw new DBCreationException();
        }
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
     * Metodo que abre la conexion a la Base de Datos. Utiliza los atributos
     * de la clase como datos para conectarse.
     */
    private Connection cargarBase() {
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
     * Metodo que cierra la conexion a la base de datos-
     *
     * @param conecta Coneccion a la base de datos.
     * @param sentencia Statement para realizar consultas a la base de datos.
     */
    private static void cerrarBase(final Connection conecta, final Statement sentencia) {
        try {
            if (sentencia != null)
                sentencia.close();
            if (conecta != null)
                conecta.close();
            System.out.println ("Conexión a base de datos cerrada");
        } catch (SQLException sqlex) {
        }
    }

    /**
     * Metodo que muestra proyectos autorizados dependiendo del tipo de usuario.
     * @param tipoUsuario Una de las 3 constantes definidas en la interfaz UsuarioRegistrado.
     * Cualquier otro valor, provocara una lista vacia.
     * @param idUsuario Identificador de un usuario en la base de datos.
     * @return Regresa una lista ligada de arreglos de Cadenas con el siguiente formato:<br>
     * { [id_del_proyecto1,nombre_del_proyecto1], ...}
     */
    public LinkedList<String[]> verProyectosDb(final int tipoUsuario,  int idUsuario) {

        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();

        String query = "";

        try {

            switch (tipoUsuario) {

                case TipoUsuario.ADMINISTRADOR_VALUE:
                    query = "SELECT nombre, id_p "
                        + "FROM  proyectos "
                        + "WHERE estado = 1;";
                    resultset = statement.executeQuery(query);
                    break;

                case TipoUsuario.RESPONSABLE_VALUE:
                    query = "SELECT nombre, id_p "
                        + "FROM  proyectos "
                        + "WHERE estado = 1 AND"
                        + " id_r ='" + idUsuario + "';";
                    resultset = statement.executeQuery(query);
                    break;

                case TipoUsuario.ALUMNO_VALUE:
                    query = "SELECT nombre, id_p "
                        + "FROM  proyectos "
                        + "WHERE estado = 1;";
                    resultset = statement.executeQuery(query);
                    break;

                default:
                    System.out.println("Tipo de usuario no valido");
                    break;
            }

            listaDeProyectos = getIdxNombre(resultset);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarBase(connect, statement);
        }
        return listaDeProyectos;
    }

    /**
     * Este meotdo es tiene codigo redundate con verProyectos. Corregir
     */
    public LinkedList<String[]> verMisProyectosDb(final int tipoUsuario, final int idUsuario) {

        LinkedList<String[]> listaDeProyectos = new LinkedList<String[]>();
        String query = "";

        try {
            connect = cargarBase();
            statement = connect.createStatement();

            switch (tipoUsuario) {
                case TipoUsuario.ADMINISTRADOR_VALUE:
                    query = "SELECT nombre, id_p FROM  proyectos WHERE estado = 0;";
                    resultset = statement.executeQuery(query);
                    break;

                case TipoUsuario.RESPONSABLE_VALUE:
                    query = "SELECT nombre, id_p FROM  proyectos "
                            + "WHERE estado = 0 AND" + " id_u =" + idUsuario
                            + ";";
                    resultset = statement.executeQuery(query);
                    break;

                case TipoUsuario.ALUMNO_VALUE:
                    query = "SELECT nombre, proyectos.id_p "
                            + "FROM  proyectos, postulados "
                            + "WHERE postulados.estado = 0 " + "AND id_u = "
                            + idUsuario + ";";
                    resultset = statement.executeQuery(query);
                    break;
            }
            listaDeProyectos = getIdxNombre(resultset);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarBase(connect, statement);
        }
        return listaDeProyectos;
    }

    /**
     * Se puede agregar una columna tipo BLOB (binary large object b) a la
     * base de datos para guardar un Proyecto completo. De esta manera
     * podemos regresar un objeto Proyecto, sin hacer el codigo ilegible.
     * Solo hay que cuidar la integredida de la base de datos, a la hora
     * de actualizar el un proyecto. Sin embargo ningun caso de uso,
     * realiza modificaciones a los proyectos.
     */
    public ResultSet verDetallesProyectoDb(final int idProyecto) {

        String query = "SELECT DISTINCT proyectos.*, "
            + " proycarr.id_c, proyac.id_ac "
            + " FROM proyectos,proycarr,proyac "
            + " WHERE proyectos.id_p = " + idProyecto
            + " AND proycarr.id_p = " + idProyecto
            + " AND proyac.id_p = " + idProyecto + ";";
        try {
            resultset = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultset;
    }

    /**
     * Agrega un proyecto a la tabla Proyectos con un estado NO_AUTORIZADO
     * Tambien agrega entradas a las tablas proycarr y proyac.
     *
     * @param proy Proyecto que se quiere agregar a la base de datos.
     * @throws Se lanza una excepcion si ninguna fila en la base de datos es
     * afectada, es decir, no se pudo agregar el proyecto.
     */
    public void proponerProyectoDb(final Proyecto proy)
            throws DBCreationException {

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
                + id_u + ",'"
                + nombre + "','"
                + email + "',"
                + telefono + ",'"
                + direccion + "',"
                + maxParticipantes + ",'"
                + descripcion + "'," 
                + estado + ");";

            if (statement.executeUpdate(update) == 0) {
                throw new DBCreationException();
            } else {
                int id_p = statement.executeQuery("SELECT LAST_INSERT_ID();").getInt(1);
                // getInt(1) hace referencia a la primer columna.

                // Areas
                update = "INSERT INTO proyac (id_p,id_ac) VALUES";
                update += getPairValues(id_p, id_ac); 
                // Regresa el par de valores a agregar a la tabla proyac.

                if (statement.executeUpdate(update) == 0) {
                    throw new DBCreationException();
                }
                // Careers
                update = "INSERT INTO proycarr (id_p,id_c) VALUES ";
                update += getPairValues(id_p, carreras);

                if (statement.executeUpdate(update) == 0) {
                    throw new DBCreationException();
                }
            }

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }

    /**
     * El administrador autoriza un proyecto. Esto significa que la columna
     * "estado" en la tabla "proyectos" correspondiente al proyecto a autorizar
     * sera cambiado a 1.
     *
     * @param idProyecto id del proyecto que el administrador desea autorizar.
     * @throws Se lanza una excepcion si no se puede modificar el
     * estado del proyecto.
     */
    public void autorizarProyectoDb(final int idProyecto)
            throws DBModificationException {

        String query = "UPDATE proyectos SET estado = " + AUTO
                + "WHERE id_p = '" + idProyecto + "';";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } finally {
            cerrarBase(connect, statement);
        }
    }

    /**
     * El administrador rechaza un proyecto y es eliminado de la db.
     *
     * @param idProyecto id del proyecto que se eliminara de la base de datos.
     * @throws Se lanza una excepcion si no se pudo elimiar el proyecto.
     */
    public void rechazarProyectoDb(final int idProyecto)
            throws DBModificationException {

        String query = "DELETE FROM proyectos "
            + "WHERE id_p = '" + idProyecto + "';";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Agrega un alumno a la lista (tabla) de postulados de un proyecto.
     * Los estados, estadoa (administrador) y estadr (responsable), de un alumno
     * postulado se inicializan en NO_AUOT = 0;
     *
     * @param idProyecto id del proyecto al cual se quiere postular un alumno.
     * @param idAlumno id del alumno que se quiere postular a un proyecto.
     * @throws Se lanza un excepcion si el si no se puede agregar al usuario
     * a la lista de postulados.
     */
    public void postularAProyectoDb(final int idProyecto, final int idAlumno)
            throws DBModificationException {

        String query = "INSERT INTO postulados (id_p, id_u, estadoa, estador)"
            + "VALUES (" + idProyecto + "," + idAlumno + ","
            + NO_AUTO + "," + NO_AUTO + ");";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Regresa una lista de alumnos postulados a un proyecto.
     *
     * @param idProyecto id del proyecto del cual se quiere cononcer
     * la lista de postulados.
     * @return Regresa una lista ligada cuyos elemenos son el par ordenado
     * de id del usuario y su nombre.
     * @throws Lanza una excepcion
     */
    public LinkedList<String[]> verPostuladosDb(final int idProyecto)
            throws DBConsultException {

        String query = "SELECT postulados.id_u,usuarios.nombre "
                + "FROM  postulados, usuario "
                + "WHERE postulados.id_p = " + idProyecto
                + " AND postulados.id_u = usuario.id_u"
                + "';";

        LinkedList<String[]> listaPos = new LinkedList<String[]>();

        try {
            connect = cargarBase();
            statement = connect.createStatement();
            resultset = statement.executeQuery(query);

            listaPos = getIdxNombre(resultset);

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } finally {
            cerrarBase(connect, statement);
        }
        return listaPos;
    }

    /**
     * El reaponsable de un proyecto acepta un alumno en su proyecto. Por lo cual
     * se cambia el contenido de la columna "estador" a 1 donde el id del usuario
     * y el id de proyecto coicidan con los pasados como parametros.
     *
     * @param idProyecto id del proyecto en el cual se aceptara al alumno.
     * @param idAlumno id el alumno al cual se acepto en el proyecto.
     * @throws Se lanza una excepcion si no se puede actualizar el estado del
     * alumno en la lista (tabla) de ponstulados.
     */
    public void aceptarAlumnoProyectoDb(final int idProyecto, final int idAlumno)
            throws DBModificationException {

        String query = "UPDATE postulados " + "SET estador = 1 "
                + "WHERE id_u = '" + idAlumno + "'"
                + "AND id_p = '" + idProyecto + ";";

        try {
            if (statement.executeUpdate(query) ==  0) {
                    throw new DBModificationException();
            }
            if (estadoA(idAlumno) == 1) {
                borrarPostulaciones(idAlumno, idProyecto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * El administrador autoriza a un alumno en un proyecto. Por lo cual
     * se cambia el contenido de la columna "estadoa" a 1 donde el id del usuario
     * y el id de proyecto coicidan con los pasados como parametros.
     *
     * @param idProyecto id del proyecto en el cual se autorizara al alumno.
     * @param idAlumno id el alumno al cual se autorizara en el proyecto.
     * @throws Se lanza una excepcion si no se puede actualizar el estado del
     * alumno en la lista (tabla) de ponstulados.
     */
    public void autorizarAlumnoProyecto(final int idAlumno, final int idProyecto)
            throws DBModificationException {

        String query = "UPDATE postulados " + "SET estadoa = 1 "
                + "WHERE id_u = " + idAlumno
                + "AND id_p = '" + idProyecto + ";";

        try {
            if (statement.executeUpdate(query) ==  0) {
                    throw new DBModificationException();
            }
            if (estadoR(idAlumno) == 1) {
                borrarPostulaciones(idAlumno, idProyecto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * En este punto, tanto el administrador como el responsable
     * han autorizado y aceptado respectivamente a un alumno. De aqui
     * que se proceda a borrar el todas las postulaciones del alumno
     * excepto en este proyecto cuyo id se pasa como parametro.
     */
    private void borrarPostulaciones(final int idAlumno, final int idProyecto)
        throws DBModificationException, SQLException {

        String query = "DELETE postulados WHERE id_u = " + idAlumno
            + " AND id_p != " + idProyecto + ";";
        if (statement.executeUpdate(query) == 0) {
            throw new DBModificationException();
        }
    }

    /**
     * El responsable rechaza (elimina) un alumno de su proycto.
     *
     * @param idProyecto id del proyecto del cual se quiere rechazar un alumno.
     * @param idAlumno id del alumno que se va a rechazar.
     * @throws Se lanza una excepcion si no se puede eliminar al alumno del proyecto.
     */
    public void rechazaAlumnoProyectoDb(final int idProyecto, final int idAlumno)
        throws DBModificationException {

        String query = "DELETE FROM postulados " + "WHERE id_p = '"
                + idProyecto + "' AND id_u = '" + idAlumno + "';";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * Agrega un nuevo usuario y un nuevo responsalbe a a la base de datos.
     *
     * @param repo un objeto Responsble.
     * @throws Se lanza una excepcion si no se puede agregar al responsable.
     */
    public void registrarDb(final Responsable repo)
        throws DBCreationException {

        int id_u = 0;

        try {
            String update = insertaUsuario(repo);

            if (statement.executeUpdate(update) == 0) {
                throw new DBCreationException();
            } else {

                id_u = statement.executeQuery("LAST_INSERT_ID()").getInt(1);
                update = insertaResponsable(repo, id_u);

                if (statement.executeUpdate(update) == 0) {
                    throw new DBCreationException();
                }
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }



    /**
     * El adminstrador acepta un responsable. Es decir, cambia el valor de la
     * columna estado en al tabla responsable a 1 (Autorizado).
     *
     * @param idResponsable id del responsable que sera aceptado.
     * @throws Se lanza un excepcion si no se puede cambiar el estado del
     * responsable.
     */
    public void aceptarResponsableDb(final int idResponsable)
            throws DBModificationException {

        String query = "UPDATE responsables SET estado = 1"
                + " WHERE id_u = '" + idResponsable + "';";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * El administrador rechaza un responsable, por lo cual es eliminado de la
     * base de datos.
     *
     * @param idResponsable id del responsable que se quiere eliminar.
     * @throws Se lanza una excepcion si no se puede eliminar al responsable.
     */
    public void rechazaResponsableDb(final int idResponsable)
        throws DBModificationException {

        String query = "DELETE FROM responsables " 
            + "WHERE id_u  = '" + idResponsable + "';";

        try {
            if (statement.executeUpdate(query) == 0) {
                throw new DBModificationException();
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
    }


    /**
     * regresa arreglo de tres enteros 
     * |tipoUsu|id_u|estado| de no existir tipo Usu = "-1"
     *
     */
    public ResultSet validaUsuarioDb(final String nombreUsuario,
            final String passwd) {
        String query = "SELECT * " + "FROM usuarios, alumnos,responsables "
                + "WHERE username = '" + nombreUsuario + "' "
                + "AND contrasena='" + passwd + "';";

        try {
            resultset = statement.executeQuery(query);

        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        }
        return resultset;
    }

    public void modificarEstadoAlumno(final int idAlumno, final boolean estadoAlumno)
        throws DBModificationException {

        int estado = 0;
        if (estadoAlumno) {
            estado = 1;

            String query = "UPDATE alumno SET estado =  " + estado
                + " WHERE id_u = " + idAlumno + ";";

            try {
                if (statement.executeUpdate(query) == 0) {
                    throw new DBModificationException();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     *
     */
    private String getPairValues(final int id, final int[] dataArray) {

        String coma = ",";
        String result = "";
        for (int i = 0; i < dataArray.length; i++) {
            if ((i + 1) == dataArray.length) {
                coma = ";";
            }
            result += "(" + id + "," + dataArray[i] + ")" + coma;
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
                + "'" + nombreUsuario + "','" + contrasena + "',"
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

        String update = "INSERT INTO responsables (id_u,descripcion,sitioweb,"
                + "estado) VALUES ("
                + idUsuario + ",'" + descripcion + "','"
                + sitioweb + "'," + estado + ");";
        return update;
    }

    /**
     * Este metodo se utiliza para conseguir una lista de arreglos,
     * cada uno con dos entradas. Cada uno de estos vectores,
     * tienen como primer elemento un entero que representa un un id y una
     * cadena que representa, generalmente, un nombre.
     * @param rs
     * @return Lista ligada de arreglos de cadenas de tamaño 2.
     * @throws SQLException
     */
    private LinkedList<String[]> getIdxNombre(final ResultSet rs) throws SQLException {

        LinkedList<String[]> lista = new LinkedList<String[]>();
        String[] idxnombre = null;

        while (rs.next()) {
            idxnombre = new String[2];
            idxnombre[0] = Integer.toString(rs.getInt(1));
            idxnombre[1] = rs.getString(2);
            lista.add(idxnombre);
        }

        return lista;
    }

    private int estadoA(final int idAlumno) {
        return estadoAR(idAlumno, "estadoa");
    }

    private int estadoR(final int idAlumno) {
        return estadoAR(idAlumno, "estador");
    }

    private int estadoAR(final int idAlumno, final String AR){

        String query = "SELECT postulados (" + AR + ") "
            + "WHERE id_u=" + idAlumno + ");";
        int estado = -1;

        try {
            resultset = statement.executeQuery(query);
            estado = resultset.getInt(1);
        } catch (SQLException e) {
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
