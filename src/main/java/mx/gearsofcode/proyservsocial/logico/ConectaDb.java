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
import mx.gearsofcode.proyservsocial.logico.util.DBConsultException;
import mx.gearsofcode.proyservsocial.logico.util.DBCreationException;
import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

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
    void verProyectosDb(final int tipoUsuario) throws DBConsultException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void proponerProyectoDBb(final Proyecto unProyecto) throws DBCreationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void autorizarProyectoDb(final int idProy) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazarProyectoDb(final int idProy) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void verPostuladosDb(final int idProy) throws DBConsultException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void aceptarAlumnoProyectoDb(final int idProy, final int idAlum) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void registrarDb(final Responsable unResponsable) throws DBCreationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void aceptarResponsableDb(final int idResp) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazaAlumnoProyectoDb(final int idProy, final int idAlum) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void rechazaResponsableDb(final int idResp) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void postularAProyectoDb(final int idProy, final int idAlum) throws DBModificationException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    Integer[] validaUsuarioDb(final String nombreUsuario, final String passwd) throws DBConsultException;

    void modificarEstadoAlumno(int studentID, boolean studentState) throws DBModificationException;

    void autorizarAlumnoProyecto(int studentID, int proyectID) throws DBModificationException;

    void verDetallesProyectosDb(int idProyect)throws DBConsultException;

    void verMisProyectosDb(final int tipoUsuario, final int idUsuario);
} // ConectaDb
