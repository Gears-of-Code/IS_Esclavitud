/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico;

import org.eclipse.emf.ecore.EObject;

import mx.gearsofcode.proyservsocial.logico.proyectos.Proyecto;
import mx.gearsofcode.proyservsocial.logico.usuarios.Responsable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conecta Db</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see mx.gearsofcode.proyservsocial.logico.LogicoPackage#getConectaDb()
 * @model
 * @generated
 */
public interface ConectaDb extends EObject {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void verProyectosDb(final int tipoUsuario);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void proponerProyectoDBb(final Proyecto unProyecto);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void autorizarProyectoDb(final int idProy);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazarProyectoDb(final int idProy);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void verPostuladosDb(final int idProy);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void aceptarAlumnoProyectoDb(final int idProy, final int idAlum);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void registrarDb(final Responsable unResponsable);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void aceptarResponsableDb(final int idResp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazaAlumnoProyectoDb(final int idProy, final int idAlum);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazaResponsableDb(final int idResp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void postularAProyectoDb(final int idProy, final int idAlum);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void validaUsuarioDb(final String nombreUsuario, final String passwd);
} // ConectaDb
