/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios.impl;

import mx.gearsofcode.proyservsocial.logico.usuarios.Responsable;
import mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.ResponsableImpl#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.ResponsableImpl#getSitioweb <em>Sitioweb</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.impl.ResponsableImpl#isEstado <em>Estado</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsableImpl extends UsuarioRegistradoImpl implements
        Responsable {
    /**
     * The default value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescripcion()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPCION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescripcion()
     * @generated
     * @ordered
     */
    protected String descripcion = DESCRIPCION_EDEFAULT;

    /**
     * The default value of the '{@link #getSitioweb() <em>Sitioweb</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSitioweb()
     * @generated
     * @ordered
     */
    protected static final String SITIOWEB_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSitioweb() <em>Sitioweb</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSitioweb()
     * @generated
     * @ordered
     */
    protected String sitioweb = SITIOWEB_EDEFAULT;

    /**
     * The default value of the '{@link #isEstado() <em>Estado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEstado()
     * @generated
     * @ordered
     */
    protected static final boolean ESTADO_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEstado() <em>Estado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEstado()
     * @generated
     * @ordered
     */
    protected boolean estado = ESTADO_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResponsableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsuariosPackage.Literals.RESPONSABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescripcion(String newDescripcion) {
        String oldDescripcion = descripcion;
        descripcion = newDescripcion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.RESPONSABLE__DESCRIPCION, oldDescripcion,
                    descripcion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSitioweb() {
        return sitioweb;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSitioweb(String newSitioweb) {
        String oldSitioweb = sitioweb;
        sitioweb = newSitioweb;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.RESPONSABLE__SITIOWEB, oldSitioweb,
                    sitioweb));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEstado(boolean newEstado) {
        boolean oldEstado = estado;
        estado = newEstado;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsuariosPackage.RESPONSABLE__ESTADO, oldEstado, estado));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void aceptaAlumnoProyecto() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void registrarse() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void seleccionarAlumnos() {
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
        case UsuariosPackage.RESPONSABLE__DESCRIPCION:
            return getDescripcion();
        case UsuariosPackage.RESPONSABLE__SITIOWEB:
            return getSitioweb();
        case UsuariosPackage.RESPONSABLE__ESTADO:
            return isEstado();
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
        case UsuariosPackage.RESPONSABLE__DESCRIPCION:
            setDescripcion((String) newValue);
            return;
        case UsuariosPackage.RESPONSABLE__SITIOWEB:
            setSitioweb((String) newValue);
            return;
        case UsuariosPackage.RESPONSABLE__ESTADO:
            setEstado((Boolean) newValue);
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
        case UsuariosPackage.RESPONSABLE__DESCRIPCION:
            setDescripcion(DESCRIPCION_EDEFAULT);
            return;
        case UsuariosPackage.RESPONSABLE__SITIOWEB:
            setSitioweb(SITIOWEB_EDEFAULT);
            return;
        case UsuariosPackage.RESPONSABLE__ESTADO:
            setEstado(ESTADO_EDEFAULT);
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
        case UsuariosPackage.RESPONSABLE__DESCRIPCION:
            return DESCRIPCION_EDEFAULT == null ? descripcion != null
                    : !DESCRIPCION_EDEFAULT.equals(descripcion);
        case UsuariosPackage.RESPONSABLE__SITIOWEB:
            return SITIOWEB_EDEFAULT == null ? sitioweb != null
                    : !SITIOWEB_EDEFAULT.equals(sitioweb);
        case UsuariosPackage.RESPONSABLE__ESTADO:
            return estado != ESTADO_EDEFAULT;
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
        result.append(" (descripcion: ");
        result.append(descripcion);
        result.append(", sitioweb: ");
        result.append(sitioweb);
        result.append(", estado: ");
        result.append(estado);
        result.append(')');
        return result.toString();
    }

} //ResponsableImpl
