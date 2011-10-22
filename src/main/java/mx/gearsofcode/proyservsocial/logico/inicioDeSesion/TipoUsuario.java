/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.inicioDeSesion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tipo Usuario</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see mx.gearsofcode.proyservsocial.logico.usuarios.UsuariosPackage#getTipoUsuario()
 * @model
 * @generated
 */
public enum TipoUsuario implements Enumerator {
    /**
     * The '<em><b>Administrador</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ADMINISTRADOR_VALUE
     * @generated
     * @ordered
     */
    ADMINISTRADOR(0, "administrador", "administrador"),

    /**
     * The '<em><b>Responsable</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RESPONSABLE_VALUE
     * @generated
     * @ordered
     */
    RESPONSABLE(1, "responsable", "responsable"),

    /**
     * The '<em><b>Alumno</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ALUMNO_VALUE
     * @generated
     * @ordered
     */
    ALUMNO(2, "alumno", "alumno");

    /**
     * The '<em><b>Administrador</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Administrador</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ADMINISTRADOR
     * @model name="administrador"
     * @generated
     * @ordered
     */
    public static final int ADMINISTRADOR_VALUE = 0;

    /**
     * The '<em><b>Responsable</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Responsable</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RESPONSABLE
     * @model name="responsable"
     * @generated
     * @ordered
     */
    public static final int RESPONSABLE_VALUE = 1;

    /**
     * The '<em><b>Alumno</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Alumno</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ALUMNO
     * @model name="alumno"
     * @generated
     * @ordered
     */
    public static final int ALUMNO_VALUE = 2;

    /**
     * An array of all the '<em><b>Tipo Usuario</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final TipoUsuario[] VALUES_ARRAY = new TipoUsuario[] {
            ADMINISTRADOR, RESPONSABLE, ALUMNO, };

    /**
     * A public read-only list of all the '<em><b>Tipo Usuario</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<TipoUsuario> VALUES = Collections
            .unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Tipo Usuario</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TipoUsuario get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TipoUsuario result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tipo Usuario</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TipoUsuario getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TipoUsuario result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tipo Usuario</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TipoUsuario get(int value) {
        switch (value) {
        case ADMINISTRADOR_VALUE:
            return ADMINISTRADOR;
        case RESPONSABLE_VALUE:
            return RESPONSABLE;
        case ALUMNO_VALUE:
            return ALUMNO;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private TipoUsuario(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} //TipoUsuario
