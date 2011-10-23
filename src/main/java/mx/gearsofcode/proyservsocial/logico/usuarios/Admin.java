/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios;

import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Admin</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getAdmin()
 * @model
 * @generated
 */
public interface Admin extends UsuarioRegistrado {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @model
     * @generated
     */
    void aceptaResponsable(final int respID) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @model
     * @generated
     */
    void actualizaEstadoAlumno(final int studentID, boolean studentState) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @model
     * @generated
     */
    void autorizarAlumnoProyecto(final int studentID, final int proyectID) throws DBModificationException;

} // Admin
