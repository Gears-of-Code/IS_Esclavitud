/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios.impl;

import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion;

import mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado;
import mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage;
import mx.gearsofcode.proyservsocial.logico.util.DBConsultException;

import mx.gearsofcode.proyservsocial.logico.impl.LogicoFactoryImpl;
import mx.gearsofcode.proyservsocial.logico.ConectaDb;

import mx.gearsofcode.proyservsocial.logico.proyectos.Proyecto;
import mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectosFactoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usuario Registrado</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getId <em>Id</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getContraseña <em>Contraseña</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getTipo <em>Tipo</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getNombre <em>Nombre</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getTelefono <em>Telefono</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.UsuarioRegistradoImpl#getSesion <em>Sesion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsuarioRegistradoImpl extends EObjectImpl implements
UsuarioRegistrado {


    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected static final String USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected String username = USERNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getContraseña() <em>Contraseña</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContraseña()
     * @generated
     * @ordered
     */
    protected static final String CONTRASEÑA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContraseña() <em>Contraseña</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContraseña()
     * @generated
     * @ordered
     */
    protected String contraseña = CONTRASEÑA_EDEFAULT;

    /**
     * The default value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTipo()
     * @generated
     * @ordered
     */
    protected static final int TIPO_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTipo()
     * @generated
     * @ordered
     */
    protected int tipo = TIPO_EDEFAULT;

    /**
     * The default value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNombre()
     * @generated
     * @ordered
     */
    protected static final String NOMBRE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNombre()
     * @generated
     * @ordered
     */
    protected String nombre = NOMBRE_EDEFAULT;

    /**
     * The default value of the '{@link #getTelefono() <em>Telefono</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTelefono()
     * @generated
     * @ordered
     */
    protected static final String TELEFONO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTelefono() <em>Telefono</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTelefono()
     * @generated
     * @ordered
     */
    protected String telefono = TELEFONO_EDEFAULT;

    /**
     * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEmail()
     * @generated
     * @ordered
     */
    protected static final String EMAIL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEmail()
     * @generated
     * @ordered
     */
    protected String email = EMAIL_EDEFAULT;

    /**
     * The cached value of the '{@link #getSesion() <em>Sesion</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSesion()
     * @generated
     * @ordered
     */
    protected Sesion sesion;

    /**
     * Se declara un elemento tipo ConectaDb.
     * Clase ConectaDb contiene los metodos de conexion a la base de datos.
     * Aqui se realizan los queries directamente a la base de datos.
     **/
    private ConectaDb conexion = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UsuarioRegistradoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsuariosPackage.Literals.USUARIO_REGISTRADO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsername(String newUsername) {
        String oldUsername = username;
        username = newUsername;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__USERNAME, oldUsername,
                    username));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContraseña(String newContraseña) {
        String oldContraseña = contraseña;
        contraseña = newContraseña;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__CONTRASEÑA,
                    oldContraseña, contraseña));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTipo(final int newTipo) {
        int oldTipo = tipo;
        tipo = (newTipo == -1 )? TIPO_EDEFAULT : newTipo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__TIPO, oldTipo, tipo));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNombre(String newNombre) {
        String oldNombre = nombre;
        nombre = newNombre;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__NOMBRE, oldNombre,
                    nombre));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTelefono(String newTelefono) {
        String oldTelefono = telefono;
        telefono = newTelefono;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__TELEFONO, oldTelefono,
                    telefono));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEmail(String newEmail) {
        String oldEmail = email;
        email = newEmail;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__EMAIL, oldEmail, email));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Sesion getSesion() {
        if (sesion != null && sesion.eIsProxy()) {
            InternalEObject oldSesion = (InternalEObject) sesion;
            sesion = (Sesion) eResolveProxy(oldSesion);
            if (sesion != oldSesion) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            UsuariosPackage.USUARIO_REGISTRADO__SESION,
                            oldSesion, sesion));
            }
        }
        return sesion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Sesion basicGetSesion() {
        return sesion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSesion(Sesion newSesion) {
        Sesion oldSesion = sesion;
        sesion = newSesion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__SESION, oldSesion,
                    sesion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UsuariosPackage.USUARIO_REGISTRADO__ID:
                return getId();
            case UsuariosPackage.USUARIO_REGISTRADO__USERNAME:
                return getUsername();
            case UsuariosPackage.USUARIO_REGISTRADO__CONTRASEÑA:
                return getContraseña();
            case UsuariosPackage.USUARIO_REGISTRADO__TIPO:
                return getTipo();
            case UsuariosPackage.USUARIO_REGISTRADO__NOMBRE:
                return getNombre();
            case UsuariosPackage.USUARIO_REGISTRADO__TELEFONO:
                return getTelefono();
            case UsuariosPackage.USUARIO_REGISTRADO__EMAIL:
                return getEmail();
            case UsuariosPackage.USUARIO_REGISTRADO__SESION:
                if (resolve)
                    return getSesion();
                return basicGetSesion();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UsuariosPackage.USUARIO_REGISTRADO__ID:
                setId((Integer) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__USERNAME:
                setUsername((String) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__CONTRASEÑA:
                setContraseña((String) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__TIPO:
                setTipo((Integer) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__NOMBRE:
                setNombre((String) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__TELEFONO:
                setTelefono((String) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__EMAIL:
                setEmail((String) newValue);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__SESION:
                setSesion((Sesion) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UsuariosPackage.USUARIO_REGISTRADO__ID:
                setId(ID_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__USERNAME:
                setUsername(USERNAME_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__CONTRASEÑA:
                setContraseña(CONTRASEÑA_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__TIPO:
                setTipo(TIPO_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__NOMBRE:
                setNombre(NOMBRE_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__TELEFONO:
                setTelefono(TELEFONO_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__EMAIL:
                setEmail(EMAIL_EDEFAULT);
                return;
            case UsuariosPackage.USUARIO_REGISTRADO__SESION:
                setSesion((Sesion) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UsuariosPackage.USUARIO_REGISTRADO__ID:
                return id != ID_EDEFAULT;
            case UsuariosPackage.USUARIO_REGISTRADO__USERNAME:
                return USERNAME_EDEFAULT == null ? username != null
                : !USERNAME_EDEFAULT.equals(username);
            case UsuariosPackage.USUARIO_REGISTRADO__CONTRASEÑA:
                return CONTRASEÑA_EDEFAULT == null ? contraseña != null
                : !CONTRASEÑA_EDEFAULT.equals(contraseña);
            case UsuariosPackage.USUARIO_REGISTRADO__TIPO:
                return tipo != TIPO_EDEFAULT;
            case UsuariosPackage.USUARIO_REGISTRADO__NOMBRE:
                return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT
                .equals(nombre);
            case UsuariosPackage.USUARIO_REGISTRADO__TELEFONO:
                return TELEFONO_EDEFAULT == null ? telefono != null
                : !TELEFONO_EDEFAULT.equals(telefono);
            case UsuariosPackage.USUARIO_REGISTRADO__EMAIL:
                return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT
                .equals(email);
            case UsuariosPackage.USUARIO_REGISTRADO__SESION:
                return sesion != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", username: ");
        result.append(username);
        result.append(", contraseña: ");
        result.append(contraseña);
        result.append(", tipo: ");
        result.append(tipo);
        result.append(", nombre: ");
        result.append(nombre);
        result.append(", telefono: ");
        result.append(telefono);
        result.append(", email: ");
        result.append(email);
        result.append(')');
        return result.toString();
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

    /**
     * Llama a la base de datos para obtener y listar todos los proyectos
     * que se encuentran disponibles para el usuario.
     *
     * @throws DBConsultException 
     */
    public String[][] verProyectos() throws DBConsultException {

        String[][] bloqueProyectos = null;        
        conexion = new LogicoFactoryImpl().createConectaDb();
        LinkedList<String[]> queryResult = conexion.verProyectosDb(tipo, id);

        int pos = 0;
        int numProy = queryResult.size();

        // String[] bloqueproyectos contiene ["id","Nombre"]
        // Nota anterior para saber en que orden esta la informacion (Capa de Interfaz)

        bloqueProyectos = new String[numProy][2];

        for (String[] proy : queryResult) {
            bloqueProyectos[pos] = proy;
            pos++;
        }

        return bloqueProyectos;
    }

    /**
     * Llama a la base de datos y obtiene una vista reducida o filtada de
     * los proyectos dependiendo del caso de usuario que este realizando
     * la consulta.
     * 
     * @throws DBConsultException
     */
    public String[][] verMisProyectos() throws DBConsultException {

        String[][] bloqueProyectos = null;
        conexion = new LogicoFactoryImpl().createConectaDb();
        LinkedList<String[]> queryResult = conexion.verMisProyectosDb(tipo, id); //Tipo de usuario y id de usuario.

        int pos = 0;
        int misProy = queryResult.size();        

        // String[] bloqueproyectos contiene ["id","Nombre"]
        // Nota anterior para saber en que orden esta la informacion (Capa de Interfaz)

        bloqueProyectos = new String[misProy][2];

        for (String[] unProy : bloqueProyectos) {
            bloqueProyectos[pos] = unProy;
            pos++;
        }

        return bloqueProyectos;
    }

    /**
     * Llama a la base de datos para obtener los datos detallados de un
     * proyecto y se los despliega al usuario.
     * 
     * @param idProyecto Un identificador de algun proyecto.
     */
    public Proyecto verDetallesProyecto(final int idProyect) throws DBConsultException {
        
        conexion = new LogicoFactoryImpl().createConectaDb();
        ResultSet queryResult = conexion.verDetallesProyectoDb(idProyect);
        Proyecto unProyecto = new ProyectosFactoryImpl().createProyecto();
        /*[1] -> nombre  responsable
        [2] -> nombre  proyectos
        [3] -> areas de conocimientos
        [4] -> carreras
        [5] -> email del poyecto
        [6] -> telefono del poyecto 
        [7] -> direccion del poyecto
        [8] -> maximo Participantes 
        [9] -> Descripcion del problema
         */
        String nomProy, descrProy,dirProy,mailProy;
        int [] areaDeConocimiento = null; 
        int[] carreraProy = null; 
        int capMax,id_resp,telProy;
        try {
            nomProy = queryResult.getString("nombre");
            descrProy = (String)(queryResult.getString("descripcion"));
            dirProy = (String)(queryResult.getString("direccion"));
            mailProy = (String)(queryResult.getString("email"));
            telProy = ((Integer)(queryResult.getInt("telefono")));
            id_resp = ((Integer)(queryResult.getInt("id_u")));
            capMax = ((Integer)(queryResult.getInt("maxParticipantes")));

 //           int tamano = queryResult.getFetchSize();
//            carreraProy = new int[tamano];  // Se desperdicia memoria a lo tonto pero 
 //           areaDeConocimiento = new int [tamano];  // seguro entran los resultados.
            LinkedList<Integer> tmpCareer, tmpKnow;
            tmpCareer = new LinkedList<Integer>();
            tmpKnow = new LinkedList<Integer>();
            tmpCareer.add(queryResult.getInt("carreras.nombre"));
            tmpKnow.add(queryResult.getInt("areasconocimiento.nombre"));

            while (queryResult.next()) {
                tmpCareer.add(queryResult.getInt("carreras.nombre"));
                tmpKnow.add(queryResult.getInt("areasconocimiento.nombre"));
            }

            carreraProy = new int [tmpCareer.size()];
            areaDeConocimiento = new int [tmpKnow.size()];
            int arrayIndex = 0;
            for(int carrera: tmpCareer){
                carreraProy[arrayIndex] = carrera;
                arrayIndex++;
            }
            arrayIndex = 0;
            for(int carrera: tmpKnow){
                areaDeConocimiento[arrayIndex] = carrera;
                arrayIndex++;
            }
            
            unProyecto.setNombre(nomProy);
            unProyecto.setDescripcion(descrProy);
            unProyecto.setDireccion(dirProy);
            unProyecto.setEmail(mailProy);
            unProyecto.setTelefono(telProy);
            unProyecto.setMaxParticipantes(capMax);
            unProyecto.setResponsable(id_resp);
            unProyecto.setAreaConocimiento(areaDeConocimiento);
            unProyecto.setCarreras(carreraProy);
            

        }catch(SQLException dbException){
            //TODO: do something meaningful with this exception
            DBConsultException e = new DBConsultException();
            throw e ;
        }
        //TODO: Check return from ConectaDb might be a ResultSet instead of String[]
        // Check documentation of ResultSet in that case else pass the object or do something.

        return unProyecto;
    }

} //UsuarioRegistradoImpl
