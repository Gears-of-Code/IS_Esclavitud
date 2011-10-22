/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.inicioDeSesion.impl;

import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.InicioDeSesionPackage;
import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion;
import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.TipoUsuario;

import mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado;
import mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage;

import mx.gearsofcode.proyservsocial.logico.LogicoFactory;
import mx.gearsofcode.proyservsocial.logico.impl.LogicoFactoryImpl;
import mx.gearsofcode.proyservsocial.logico.ConectaDb;

import java.security.MessageDigest;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * La clase '<em><b>Sesion</b></em>' se encarga de manejar
 * parte del inicio de sesion del usuario en el sistema.
 * Acepta o rechaza usuarios y les genera su respectiva clase
 * de trabajo.
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.inicioDeSesion.impl.SesionImpl#getUsuario <em>Usuario</em>}</li>
 * </ul>
 * </p>
 *
 */
public class SesionImpl extends EObjectImpl implements Sesion {
    /**
     * The cached value of the '{@link #getUsuario() <em>Usuario</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsuario()
     * @generated
     * @ordered
     */
    protected UsuarioRegistrado usuario;

    /**
     * Se crea un elemento tipo ConectaDb.
     * Clase ConectaDb contiene los metodos de conexion a la base de datos.
     * Aqui se realizan los queries directamente a la base de datos.
     **/
    private ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();

    /**
     * The default value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTipo()
     * @generated
     * @ordered
     */
    protected static final TipoUsuario TIPO_EDEFAULT = TipoUsuario.ALUMNO;

    /**
     * The cached value of the '{@link #getTipo() <em>Tipo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTipo()
     * @generated
     * @ordered
     */
    protected TipoUsuario tipo = TIPO_EDEFAULT;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SesionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InicioDeSesionPackage.Literals.SESION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsuarioRegistrado getUsuario() {
        if (usuario != null && usuario.eIsProxy()) {
            InternalEObject oldUsuario = (InternalEObject) usuario;
            usuario = (UsuarioRegistrado) eResolveProxy(oldUsuario);
            if (usuario != oldUsuario) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InicioDeSesionPackage.SESION__USUARIO, oldUsuario,
                            usuario));
            }
        }
        return usuario;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsuarioRegistrado basicGetUsuario() {
        return usuario;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsuario(UsuarioRegistrado newUsuario) {
        UsuarioRegistrado oldUsuario = usuario;
        usuario = newUsuario;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InicioDeSesionPackage.SESION__USUARIO, oldUsuario, usuario));
    }

    /**
     * Autenticar va a recibir los valores de un usuario, tras aplicar una función
     * md5 o similar pasara los datos a un metodo que los validara en la base de 
     * datos. Si existen en la base de datos, se accede al sistema sino se manda
     * un mensaje de error.
     * @param nombreUsuario Nombre del usuario.
     * @param passwd Contrasena del usuario, en texto plano.
     */
    public void autenticar(final String nombreUsuario, final String passwd) {
        byte[] bytesPasswd = passwd.getBytes("UTF-8");
        MessageDigest cifrado = MessageDigest.getInstance("MD5");
        cifrado.reset();
        byte[] md5bytePass = cifrado.digest(bytesPasswd);
        String md5passwd = cifrado.toString();

        try { 
	        conexion.validaUsuarioDb(nombreUsuario, md5passwd);
	        // TODO: implement this method
	        // Ensure that you remove @generated or mark it @generated NOT
        }
	     catch {
	    
	    } finally {
	        throw new UnsupportedOperationException();
	    }
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void cerrarSesion() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTipo(TipoUsuario newTipo) {
        TipoUsuario oldTipo = tipo;
        tipo = newTipo == null ? TIPO_EDEFAULT : newTipo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.USUARIO_REGISTRADO__TIPO, oldTipo, tipo));
    }

    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InicioDeSesionPackage.SESION__USUARIO:
            if (resolve)
                return getUsuario();
            return basicGetUsuario();
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
        case InicioDeSesionPackage.SESION__USUARIO:
            setUsuario((UsuarioRegistrado) newValue);
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
        case InicioDeSesionPackage.SESION__USUARIO:
            setUsuario((UsuarioRegistrado) null);
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
        case InicioDeSesionPackage.SESION__USUARIO:
            return usuario != null;
        }
        return super.eIsSet(featureID);
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

} //SesionImpl
