/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.proyectos.impl;

import java.util.LinkedList;

import mx.gearsofcode.proyservsocial.logico.proyectos.CarreraProyecto;
import mx.gearsofcode.proyservsocial.logico.proyectos.Proyecto;
import mx.gearsofcode.proyservsocial.logico.proyectos.ProyectosPackage;
import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

import mx.gearsofcode.proyservsocial.logico.ConectaDb;
import mx.gearsofcode.proyservsocial.logico.impl.LogicoFactoryImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Modela el contenido de un '* <em><b>Proyecto</b></em>'con sus elementos.
 * <p>
 * Las siguientes funciones estan implementadas:
 * <ul>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getNombre
 * <em>Nombre</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getResponsable
 * <em>Responsable</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getAreaConocimiento
 * <em>Area Conocimiento</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getEmail
 * <em>Email</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getTelefono
 * <em>Telefono</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getDireccion
 * <em>Direccion</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getCarrera
 * <em>Carrera</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getMaxParticipante
 * <em>Max Participante</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getDescripcion
 * <em>Descripcion</em>}</li>
 * <li>
 * {@link mx.gearsofcode.proyservsocial.logico.proyectos.impl.ProyectoImpl#getEstado
 * <em>Estado</em>}</li>
 * </ul>
 * </p>
 */
public class ProyectoImpl extends EObjectImpl implements Proyecto {
    /**
     * Valor por defecto del atributo '{@link #getId() <em>Id</em>}'.
     * 
     * @see #getId()
     */
    protected static final int ID_EDEFAULT = -1;

    /**
     * Valor almacenado del atributo '{@link #getId() <em>Id</em>}'.
     * 
     * @see #getId()
     */
    protected int id = ID_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getNombre() <em>Nombre</em>}'.
     * 
     * @see #getNombre()
     */
    protected static final String NOMBRE_EDEFAULT = null;

    /**
     * Valor almacenado del atributo '{@link #getNombre() <em>Nombre</em>}'.
     * 
     * @see #getNombre()
     */
    protected String nombre = NOMBRE_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getResponsable()
     * <em>Id Responsable</em>}'. 
     * Sera responsable del proyecto, -1 en un proyecto vacio, 
     * se coloca el id del responsable que crea el proyecto.
     * 
     * @see #getResponsable()
     */
    protected static final int RESPONSABLE_EDEFAULT = -1;

    /**
     * Valor almacenado del atributo '{@link #getResponsable() <em>Responsable</em>}'.
     * 
     * @see #getResponsable()
     */
    protected int responsable = RESPONSABLE_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getAreaConocimiento()
     * <em>Area Conocimiento</em>}'. No existe en un proyecto nuevo.
     * 
     * @see #getAreaConocimiento()
     */
    protected static final String AREA_CONOCIMIENTO_EDEFAULT = null;

    /**
     * Valor almacenado del atributo '{@link #getAreaConocimiento() <em>Area Conocimiento</em>}' .
     * 
     * @see #getAreaConocimiento()
     */
    protected int[] areaConocimiento = null;//AREA_CONOCIMIENTO_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getEmail() <em>Email</em>}'. No
     * hay direccion de correo en un proyecto vacio.
     * 
     * @see #getEmail()
     * @generated
     * @ordered
     */
    protected static final String EMAIL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEmail()
     * @generated
     * @ordered
     */
    protected String email = EMAIL_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getTelefono() <em>Telefono</em>}
     * '. No hay telefono en un proyecto nuevo.
     * 
     * @see #getTelefono()
     * @generated
     * @ordered
     */
    protected static final int TELEFONO_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTelefono() <em>Telefono</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTelefono()
     * @generated
     * @ordered
     */
    protected int telefono = TELEFONO_EDEFAULT;

    /**
     * The default value of the '{@link #getDireccion() <em>Direccion</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDireccion()
     * @generated
     * @ordered
     */
    protected static final String DIRECCION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDireccion() <em>Direccion</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDireccion()
     * @generated
     * @ordered
     */
    protected String direccion = DIRECCION_EDEFAULT;

    /**
     * The default value of the '{@link #getCarrera() <em>Carrera</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCarrera()
     * @generated
     * @ordered
     */
    protected static final CarreraProyecto CARRERA_EDEFAULT = CarreraProyecto.MATEMATICAS;

    /**
     * The cached value of the '{@link #getCarrera() <em>Carrera</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCarrera()
     * @generated
     * @ordered
     */
    protected CarreraProyecto carrera = CARRERA_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getMaxParticipante()
     * <em>Max Participante</em>}'. Numero maximo de alumnos que acepta un
     * proyecto vacio.
     * 
     * @see #getMaxParticipante()
     * @generated
     * @ordered
     */
    protected static final int MAX_PARTICIPANTE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxParticipante()
     * <em>Max Participante</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMaxParticipante()
     * @generated
     * @ordered
     */
    protected int maxParticipante = MAX_PARTICIPANTE_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getDescripcion()
     * <em>Descripcion</em>}'. Descripcion del proyecto a realizar.
     * 
     * @see #getDescripcion()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPCION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescripcion() <em>Descripcion</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDescripcion()
     * @generated
     * @ordered
     */
    protected String descripcion = DESCRIPCION_EDEFAULT;

    /**
     * Valor por defecto del atributo '{@link #getEstado() <em>Estado</em}'.
     * Falso implica que aun no ha sido autorizado por el administrador.
     * 
     * @see #getEstado()
     * @generated
     * @ordered
     */
    protected static final boolean ESTADO_EDEFAULT = false;

    /**
     * The cached value of the '{@link #getEstado() <em>Estado</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEstado()
     * @generated
     * @ordered
     */
    protected boolean estado = ESTADO_EDEFAULT;

    /**
     * Clase que contiene los metodos de conexion a la base de datos. 
     * Aqui se realizan los queries directamente a la base de datos.
     **/
    private ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProyectoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProyectosPackage.Literals.PROYECTO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNombre(String newNombre) {
        String oldNombre = nombre;
        nombre = newNombre;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__NOMBRE, oldNombre, nombre));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getResponsable() {
        return responsable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResponsable(int newResponsable) {
        int oldResponsable = responsable;
        responsable = newResponsable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__RESPONSABLE, oldResponsable,
                    responsable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int[] getAreaConocimiento() {
        return areaConocimiento;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAreaConocimiento(int [] newAreaConocimiento) {
        int [] oldAreaConocimiento = areaConocimiento;
        areaConocimiento = newAreaConocimiento;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__AREA_CONOCIMIENTO,
                    oldAreaConocimiento, areaConocimiento));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setEmail(String newEmail) {
        String oldEmail = email;
        email = newEmail;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__EMAIL, oldEmail, email));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTelefono(int newTelefono) {
        int oldTelefono = telefono;
        telefono = newTelefono;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__TELEFONO, oldTelefono, telefono));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDireccion(String newDireccion) {
        String oldDireccion = direccion;
        direccion = newDireccion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__DIRECCION, oldDireccion,
                    direccion));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CarreraProyecto getCarrera() {
        return carrera;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCarrera(CarreraProyecto newCarrera) {
        CarreraProyecto oldCarrera = carrera;
        carrera = newCarrera == null ? CARRERA_EDEFAULT : newCarrera;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__CARRERA, oldCarrera, carrera));
    }

    /**
     * {@inheritDoc}
     */
    public int getMaxParticipante() {
        return maxParticipante;
    }

    /**
     * {@inheritDoc}
     */
    public void setMaxParticipante(int newMaxParticipante) {
        int oldMaxParticipante = maxParticipante;
        maxParticipante = newMaxParticipante;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__MAX_PARTICIPANTE,
                    oldMaxParticipante, maxParticipante));
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * {@inheritDoc}
     */
    public void setDescripcion(String newDescripcion) {
        String oldDescripcion = descripcion;
        descripcion = newDescripcion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__DESCRIPCION, oldDescripcion,
                    descripcion));
    }

    /**
     * Devuelve el estado del proyecto.
     * True = Aceptado o False = En proceso de autorizacion 
     */
    public boolean getEstado() { //TODO: Revisar la salida ¿boolean o string?.
        //String status = "";
        //if (estado) {
        //    status = "Aprobado";
        //} else {
        //    status = "En autorizacion";
        //}
        //return status;
        return estado;
    }

    /**
     * Este metodo es llamado exclusivamente por el metodo autorizarProyecto 
     * y asi garantizar que un administrador sea el unico que lo puede usar.
     * @param newEstado Debe de recibir True solamente para cambiar el estado
     * a Aceptado.
     */
    private void setEstado(final boolean newEstado) {
        boolean oldEstado = estado;
        estado = newEstado;
        if (eNotificationRequired())  // Evaluar si esto sirve o se elimina.
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ProyectosPackage.PROYECTO__ESTADO, oldEstado, estado));
    }

    /**
     * Este metodo solo lo ejecuta el administrador. Sirve para autorizar un
     * proyecto, lo cual hace que pase el estado de false -> true. Al cambiar
     * este valor el proceso queda "Aceptado".
     * 
     * @param idAdmin El tipo del usuario que llama este metodo, debe coincidir
     *            con el tipo del administrador.
     * @throws DBModificationException 
     */
    public void autorizarProyecto(final int idAdmin) throws DBModificationException {
        if (idAdmin == 0) { // <------------Esto no me gusta, se aceptan cambios.
            if (!estado) { // Revisa que el proyecto no este autorizado.
                setEstado(true);
                conexion.autorizarProyectoDb(id);
            }
        } else {

        }
        // TODO: implement this method
        throw new UnsupportedOperationException();
    }

    /**
     * Este metodo solo lo ejecuta el administrador. Sirve para rechazar un
     * proyecto, lo cual hace que el proyecto sea eliminado de la base de datos
     * directamente.
     * 
     * @param idAdmin El tipo del usuario que llama este metodo, debe coincidir
     *            con el tipo del administrador.
     */
    public void rechazarProyecto(final int idAdmin) {
        if (idAdmin == 0) { // <------------Esto no me gusta, se aceptan cambios.
            if (!estado) { // Revisa que el proyecto no este autorizado.
                try {
                    conexion.rechazarProyectoDb(id);
                } finally {
                    throw new UnsupportedOperationException();
                }
            } else {

            }
        }
        // TODO: implement this method
    }

    /**
     * Este metodo solo lo ejecutan el administrador y el responsable. Nos
     * muestra la lista de los alumnos que estan postulados a uno de los
     * proyectos.
     * 
     * @param idUsuario Valor tipo de usuario, debe coincidir con el de un
     *            administrador o un responsabl.
     */
    public LinkedList<String> verListaPostulados(final int idUsuario) { //TODO: Revisar lo que regresa-
        /*
         * Según lo que entiendo, esta parte arma la pantalla de autorizaciones pendientes 
         * para el responsable y el administrador. 
         * Entonces:
         * Al Administrador debemos darle todos los alumnos postulados que hayan sido autorizados por
         * el Responsable.
         * Al Responsable, darle todos los postulados en sus proyectos.
         * Eso es un query a la BD. Luego entonces, necesitamos que el método:
         * verPostuladosDb funcione recibiendo un id de usuario y dependiendo de ello, lleve a cabo la consulta.
         */
        // TODO: implement this method
        throw new UnsupportedOperationException();
    }


/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Override
public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
        case ProyectosPackage.PROYECTO__ID:
            return getId();
        case ProyectosPackage.PROYECTO__NOMBRE:
            return getNombre();
        case ProyectosPackage.PROYECTO__RESPONSABLE:
            return getResponsable();
        case ProyectosPackage.PROYECTO__AREA_CONOCIMIENTO:
            return getAreaConocimiento();
        case ProyectosPackage.PROYECTO__EMAIL:
            return getEmail();
        case ProyectosPackage.PROYECTO__TELEFONO:
            return getTelefono();
        case ProyectosPackage.PROYECTO__DIRECCION:
            return getDireccion();
        case ProyectosPackage.PROYECTO__CARRERA:
            return getCarrera();
        case ProyectosPackage.PROYECTO__MAX_PARTICIPANTE:
            return getMaxParticipante();
        case ProyectosPackage.PROYECTO__DESCRIPCION:
            return getDescripcion();
        case ProyectosPackage.PROYECTO__ESTADO:
            return getEstado();
    }
    return super.eGet(featureID, resolve, coreType);
}

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Override
public void eSet(int featureID, Object newValue) {
    switch (featureID) {
        case ProyectosPackage.PROYECTO__ID:
            setId((Integer) newValue);
            return;
        case ProyectosPackage.PROYECTO__NOMBRE:
            setNombre((String) newValue);
            return;
        case ProyectosPackage.PROYECTO__RESPONSABLE:
            setResponsable((Integer) newValue);
            return;
        case ProyectosPackage.PROYECTO__AREA_CONOCIMIENTO:
            setAreaConocimiento((int[]) newValue);
            return;
        case ProyectosPackage.PROYECTO__EMAIL:
            setEmail((String) newValue);
            return;
        case ProyectosPackage.PROYECTO__TELEFONO:
            setTelefono((Integer) newValue);
            return;
        case ProyectosPackage.PROYECTO__DIRECCION:
            setDireccion((String) newValue);
            return;
        case ProyectosPackage.PROYECTO__CARRERA:
            setCarrera((CarreraProyecto) newValue);
            return;
        case ProyectosPackage.PROYECTO__MAX_PARTICIPANTE:
            setMaxParticipante((Integer) newValue);
            return;
        case ProyectosPackage.PROYECTO__DESCRIPCION:
            setDescripcion((String) newValue);
            return;
        case ProyectosPackage.PROYECTO__ESTADO:
            setEstado((Boolean) newValue);
            return;
    }
    super.eSet(featureID, newValue);
}

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Override
public void eUnset(int featureID) {
    switch (featureID) {
        case ProyectosPackage.PROYECTO__ID:
            setId(ID_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__NOMBRE:
            setNombre(NOMBRE_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__RESPONSABLE:
            setResponsable(RESPONSABLE_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__AREA_CONOCIMIENTO:
            setAreaConocimiento(null);
            return;
        case ProyectosPackage.PROYECTO__EMAIL:
            setEmail(EMAIL_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__TELEFONO:
            setTelefono(TELEFONO_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__DIRECCION:
            setDireccion(DIRECCION_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__CARRERA:
            setCarrera(CARRERA_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__MAX_PARTICIPANTE:
            setMaxParticipante(MAX_PARTICIPANTE_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__DESCRIPCION:
            setDescripcion(DESCRIPCION_EDEFAULT);
            return;
        case ProyectosPackage.PROYECTO__ESTADO:
            setEstado(ESTADO_EDEFAULT);
            return;
    }
    super.eUnset(featureID);
}

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Override
public boolean eIsSet(int featureID) {
    switch (featureID) {
        case ProyectosPackage.PROYECTO__ID:
            return id != ID_EDEFAULT;
        case ProyectosPackage.PROYECTO__NOMBRE:
            return NOMBRE_EDEFAULT == null ? nombre != null : !NOMBRE_EDEFAULT
            .equals(nombre);
        case ProyectosPackage.PROYECTO__RESPONSABLE:
            return responsable != RESPONSABLE_EDEFAULT;
        case ProyectosPackage.PROYECTO__AREA_CONOCIMIENTO:
            return AREA_CONOCIMIENTO_EDEFAULT == null ? areaConocimiento != null
            : !AREA_CONOCIMIENTO_EDEFAULT.equals(areaConocimiento);
        case ProyectosPackage.PROYECTO__EMAIL:
            return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT
            .equals(email);
        case ProyectosPackage.PROYECTO__TELEFONO:
            return telefono != TELEFONO_EDEFAULT;
        case ProyectosPackage.PROYECTO__DIRECCION:
            return DIRECCION_EDEFAULT == null ? direccion != null
            : !DIRECCION_EDEFAULT.equals(direccion);
        case ProyectosPackage.PROYECTO__CARRERA:
            return carrera != CARRERA_EDEFAULT;
        case ProyectosPackage.PROYECTO__MAX_PARTICIPANTE:
            return maxParticipante != MAX_PARTICIPANTE_EDEFAULT;
        case ProyectosPackage.PROYECTO__DESCRIPCION:
            return DESCRIPCION_EDEFAULT == null ? descripcion != null
            : !DESCRIPCION_EDEFAULT.equals(descripcion);
        case ProyectosPackage.PROYECTO__ESTADO:
            return estado != ESTADO_EDEFAULT;
    }
    return super.eIsSet(featureID);
}

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Override
public String toString() {
    if (eIsProxy())
        return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(", nombre: ");
    result.append(nombre);
    result.append(", responsable: ");
    result.append(responsable);
    result.append(", areaConocimiento: ");
    result.append(areaConocimiento);
    result.append(", email: ");
    result.append(email);
    result.append(", telefono: ");
    result.append(telefono);
    result.append(", direccion: ");
    result.append(direccion);
    result.append(", carrera: ");
    result.append(carrera);
    result.append(", maxParticipante: ");
    result.append(maxParticipante);
    result.append(", descripcion: ");
    result.append(descripcion);
    result.append(", estado: ");
    result.append(estado);
    result.append(')');
    return result.toString();
}

/**
 * Creates a new instance of the specified Ecore class. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @param eClass The Ecore class of the instance to create.
 * @return The new instance.
 * @generated
 */
protected EObject create(EClass eClass) {
    return EcoreUtil.create(eClass);
}

} // ProyectoImpl
