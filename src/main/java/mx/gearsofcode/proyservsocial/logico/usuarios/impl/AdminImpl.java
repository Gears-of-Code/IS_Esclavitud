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
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @generated
     */
    public void actualizaEstadoAlumno(final int studentID, boolean studentState) throws DBModificationException {
        ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();
        //falta metodo de ConectaDb modificarEstadoAlumno(final int studentID, boolean studentState)
        //se agrega temporalmente.
        conexion.modificarEstadoAlumno(studentID,studentState);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @throws DBModificationException 
     * @generated
     */
    public void autorizarAlumnoProyecto(final int studentID, final int proyectID) throws DBModificationException {
        ConectaDb conexion = new LogicoFactoryImpl().createConectaDb();
        //falta metodo de ConectaDb autorizarAlumnoProyecto(final int studentID, final int proyectID)
        //se agrega temporalmente.
        conexion.autorizarAlumnoProyecto(studentID,proyectID);
        this.actualizaEstadoAlumno(studentID, true);
    }

} //AdminImpl
