/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.inicioDeSesion.impl;

import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.InicioDeSesionPackage;
import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion;

import mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado;

import mx.gearsofcode.proyservsocial.logico.LogicoPackage;
import mx.gearsofcode.proyservsocial.logico.ConectaDB;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sesion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.inicioDeSesion.impl.SesionImpl#getUsuario <em>Usuario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
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
     * Crea la fabrica de clases del paquete Logico.
     * Es necesaria para poder crear la clase de conectaDB y 
     * acceder a esos recursos.
     **/
    private LogicoFactory fabrica = new LogicoFactory();

    /**
     * Clase que contiene los metodos de conexion a la base de datos.
     * Aqui se realizan los queries directamente a la base de datos.
     **/
    private ConectaDB conexion = new fabrica.createConectaDb();

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void autenticar(final String nombreUsuario, final String passwd) {
	try { 
	    
	    int tipoUsuario = conexion.validaUsuarioDb(nombreUsuario, passwd);
	    // TODO: implement this method
	    // Ensure that you remove @generated or mark it @generated NOT
	}
	catch {
	}
	    throw new UnsupportedOperationException();
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
