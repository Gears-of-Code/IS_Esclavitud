/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.usuarios.impl;

import mx.gearsofcode.proyservsocial.logico.ConectaDb;
import mx.gearsofcode.proyservsocial.logico.impl.LogicoFactoryImpl;
import mx.gearsofcode.proyservsocial.logico.usuarios.Admin;
import mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage;
import mx.gearsofcode.proyservsocial.logico.util.DBModificationException;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Admin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AdminImpl extends UsuarioRegistradoImpl implements Admin {
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AdminImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsuariosPackage.Literals.ADMIN;
    }

    /**
     * <!-- begin-user-doc -->
     * Método que se manda llamar cuando un Administrador de Sistema pulsa aceptar, luego 
     * de haber seleccionado dentro de una lista a los responsables de proyecto que desea
     * autorizar.
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @generated NOT
     */
    public void aceptaResponsable(final int respID) throws DBModificationException {
        ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();
        conexion.aceptarResponsableDb(respID);
    }

    /**
     * <!-- begin-user-doc -->
     * Método que se utiliza para dejar constancia de que un alumno ha sido autorizado en un proyecto.
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @generated NOT
     */
    public void actualizaEstadoAlumno(final int studentID, boolean studentState) throws DBModificationException {
        ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();
        //falta metodo de ConectaDb modificarEstadoAlumno(final int studentID, boolean studentState)
        //se agrega temporalmente.
        conexion.modificarEstadoAlumno(studentID,studentState);
    }

    /**
     * <!-- begin-user-doc -->
     * Método que se utiliza para actualizar al alumno autorizado en un proyecto dado.
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @generated NOT
     */
    public void autorizarAlumnoProyecto(final int studentID, final int proyectID) throws DBModificationException {
        ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();
        //falta metodo de ConectaDb autorizarAlumnoProyecto(final int studentID, final int proyectID)
        //se agrega temporalmente.
        conexion.autorizarAlumnoProyecto(studentID,proyectID);
        this.actualizaEstadoAlumno(studentID, true);
    }

} //AdminImpl
