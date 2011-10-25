/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.inicioDeSesion;

import mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado;
import mx.gearsofcode.proyservsocial.logico.util.DBConsultException;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sesion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion#getUsuario <em>Usuario</em>}</li>
 * </ul>
 * </p>
 *
 * @see mx.gearsofcode.proyservsocial.logico.inicioDeSesion.InicioDeSesionPackage#getSesion()
 * @model
 * @generated
 */
public interface Sesion extends EObject {
    /**
     * Returns the value of the '<em><b>Usuario</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usuario</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Usuario</em>' reference.
     * @see #setUsuario(UsuarioRegistrado)
     * @see mx.gearsofcode.proyservsocial.logico.inicioDeSesion.InicioDeSesionPackage#getSesion_Usuario()
     * @model required="true" ordered="false"
     * @generated
     */
    UsuarioRegistrado getUsuario();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion#getUsuario <em>Usuario</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Usuario</em>' reference.
     * @see #getUsuario()
     * @generated
     */
    void setUsuario(UsuarioRegistrado value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return 
     * @throws DBConsultException 
     */
    UsuarioRegistrado autenticar(final String nombreUsuario, final String password) throws DBConsultException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void cerrarSesion();

} // Sesion
