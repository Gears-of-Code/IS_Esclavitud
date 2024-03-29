/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Responsable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#getDescripcion <em>Descripcion</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#getSitioweb <em>Sitioweb</em>}</li>
 *   <li>{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#isEstado <em>Estado</em>}</li>
 * </ul>
 * </p>
 *
 * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getResponsable()
 * @model
 * @generated
 */
public interface Responsable extends UsuarioRegistrado {
    /**
     * Returns the value of the '<em><b>Descripcion</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descripcion</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descripcion</em>' attribute.
     * @see #setDescripcion(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getResponsable_Descripcion()
     * @model required="true" ordered="false"
     * @generated
     */
    String getDescripcion();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#getDescripcion <em>Descripcion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descripcion</em>' attribute.
     * @see #getDescripcion()
     * @generated
     */
    void setDescripcion(String value);

    /**
     * Returns the value of the '<em><b>Sitioweb</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sitioweb</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sitioweb</em>' attribute.
     * @see #setSitioweb(String)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getResponsable_Sitioweb()
     * @model required="true" ordered="false"
     * @generated
     */
    String getSitioweb();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#getSitioweb <em>Sitioweb</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sitioweb</em>' attribute.
     * @see #getSitioweb()
     * @generated
     */
    void setSitioweb(String value);

    /**
     * Returns the value of the '<em><b>Estado</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Estado</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Estado</em>' attribute.
     * @see #setEstado(boolean)
     * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getResponsable_Estado()
     * @model default="false" required="true" ordered="false"
     * @generated
     */
    boolean isEstado();

    /**
     * Sets the value of the '{@link mx.gearsofcode.proyservsocial.logico.usuarios.Responsable#isEstado <em>Estado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Estado</em>' attribute.
     * @see #isEstado()
     * @generated
     */
    void setEstado(boolean value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void aceptaAlumnoProyecto();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void registrarse();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void seleccionarAlumnos();

} // Responsable
