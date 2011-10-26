/**

 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico;

import org.eclipse.emf.ecore.EObject;

import java.sql.ResultSet;
import java.util.LinkedList;

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
    LinkedList<String[]> verProyectosDb(final int tipoUsuario, 
            final int idUsuario) throws DBConsultException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void proponerProyectoDb(final Proyecto unProyecto) throws DBCreationException;

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
     * @return 
     * @model
     * @generated
     */
    LinkedList<String[]> verPostuladosDb(final int idProy) throws DBConsultException;

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
    ResultSet validaUsuarioDb(final String nombreUsuario, final String passwd);

    void modificarEstadoAlumno(int studentID, boolean studentState) throws DBModificationException;

    void autorizarAlumnoProyecto(int studentID, int proyectID) throws DBModificationException;

    String[] verDetallesProyectoDb(int idProyect)throws DBConsultException;

    LinkedList<String[]> verMisProyectosDb(final int tipoUsuario, final int idUsuario);
} // ConectaDb
