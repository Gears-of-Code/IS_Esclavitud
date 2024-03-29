/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see mx.gearsofcode.proyservsocial.logico.LogicoFactory
 * @model kind="package"
 * @generated
 */
public interface LogicoPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "logico";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http:///proyservsocial/logico.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "proyservsocial.logico";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LogicoPackage eINSTANCE = mx.gearsofcode.proyservsocial.logico.impl.LogicoPackageImpl
            .init();

    /**
     * The meta object id for the '{@link mx.gearsofcode.proyservsocial.logico.impl.ConectaDbImpl <em>Conecta Db</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see mx.gearsofcode.proyservsocial.logico.impl.ConectaDbImpl
     * @see mx.gearsofcode.proyservsocial.logico.impl.LogicoPackageImpl#getConectaDb()
     * @generated
     */
    int CONECTA_DB = 0;

    /**
     * The number of structural features of the '<em>Conecta Db</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONECTA_DB_FEATURE_COUNT = 0;

    /**
     * Returns the meta object for class '{@link mx.gearsofcode.proyservsocial.logico.ConectaDb <em>Conecta Db</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conecta Db</em>'.
     * @see mx.gearsofcode.proyservsocial.logico.ConectaDb
     * @generated
     */
    EClass getConectaDb();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    LogicoFactory getLogicoFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link mx.gearsofcode.proyservsocial.logico.impl.ConectaDbImpl <em>Conecta Db</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see mx.gearsofcode.proyservsocial.logico.impl.ConectaDbImpl
         * @see mx.gearsofcode.proyservsocial.logico.impl.LogicoPackageImpl#getConectaDb()
         * @generated
         */
        EClass CONECTA_DB = eINSTANCE.getConectaDb();

    }

} //LogicoPackage
