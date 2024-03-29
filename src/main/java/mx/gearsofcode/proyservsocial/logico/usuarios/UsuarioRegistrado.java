/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios;

import mx.gearsofcode.proyservsocial.logico.inicioDeSesion.Sesion;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usuario Registrado</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getId <em>Id</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getUsername <em>Username</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getContraseña <em>Contraseña</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getTipo <em>Tipo</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getNombre <em>Nombre</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getTelefono <em>Telefono</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getEmail <em>Email</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getSesion <em>Sesion</em>}</li>
 * </ul>
 * </p>
 *
 * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado()
 * @model
 * @generated
 */
public interface UsuarioRegistrado extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Id()
     * @model default="-1" required="true" ordered="false"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username</em>' attribute.
     * @see #setUsername(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Username()
     * @model required="true" ordered="false"
     * @generated
     */
    String getUsername();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getUsername <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */
    void setUsername(String value);

    /**
     * Returns the value of the '<em><b>Contraseña</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contraseña</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contraseña</em>' attribute.
     * @see #setContraseña(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Contraseña()
     * @model required="true" ordered="false"
     * @generated
     */
    String getContraseña();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getContraseña <em>Contraseña</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Contraseña</em>' attribute.
     * @see #getContraseña()
     * @generated
     */
    void setContraseña(String value);

    /**
     * Returns the value of the '<em><b>Tipo</b></em>' attribute.
     * The literals are from the enumeration {@link mx.gearsofcode.proyservsocial.logico.usuarios.TipoUsuario}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tipo</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tipo</em>' attribute.
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.TipoUsuario
     * @see #setTipo(TipoUsuario)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Tipo()
     * @model required="true" ordered="false"
     * @generated
     */
    TipoUsuario getTipo();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getTipo <em>Tipo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tipo</em>' attribute.
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.TipoUsuario
     * @see #getTipo()
     * @generated
     */
    void setTipo(TipoUsuario value);

    /**
     * Returns the value of the '<em><b>Nombre</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nombre</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nombre</em>' attribute.
     * @see #setNombre(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Nombre()
     * @model required="true" ordered="false"
     * @generated
     */
    String getNombre();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getNombre <em>Nombre</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nombre</em>' attribute.
     * @see #getNombre()
     * @generated
     */
    void setNombre(String value);

    /**
     * Returns the value of the '<em><b>Telefono</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Telefono</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Telefono</em>' attribute.
     * @see #setTelefono(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Telefono()
     * @model required="true" ordered="false"
     * @generated
     */
    String getTelefono();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getTelefono <em>Telefono</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Telefono</em>' attribute.
     * @see #getTelefono()
     * @generated
     */
    void setTelefono(String value);

    /**
     * Returns the value of the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Email</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Email</em>' attribute.
     * @see #setEmail(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Email()
     * @model required="true" ordered="false"
     * @generated
     */
    String getEmail();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getEmail <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Email</em>' attribute.
     * @see #getEmail()
     * @generated
     */
    void setEmail(String value);

    /**
     * Returns the value of the '<em><b>Sesion</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sesion</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sesion</em>' reference.
     * @see #setSesion(Sesion)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getUsuarioRegistrado_Sesion()
     * @model required="true" ordered="false"
     * @generated
     */
    Sesion getSesion();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.UsuarioRegistrado#getSesion <em>Sesion</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sesion</em>' reference.
     * @see #getSesion()
     * @generated
     */
    void setSesion(Sesion value);

} // UsuarioRegistrado
