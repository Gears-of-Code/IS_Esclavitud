/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mx.gearsofcode.proyservsocial.logico.proyectos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Estado Proyecto</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see mx.gearsofcode.proyservsocial.logico.proyectos.ProyectosPackage#getEstadoProyecto()
 * @model
 * @generated
 */
public enum EstadoProyecto implements Enumerator {
    /**
     * The '<em><b>Aceptado</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ACEPTADO_VALUE
     * @generated
     * @ordered
     */
    ACEPTADO(0, "aceptado", "aceptado"),

    /**
     * The '<em><b>Rechazado</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RECHAZADO_VALUE
     * @generated
     * @ordered
     */
    RECHAZADO(1, "rechazado", "rechazado"),

    /**
     * The '<em><b>En Autorizacion</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EN_AUTORIZACION_VALUE
     * @generated
     * @ordered
     */
    EN_AUTORIZACION(2, "enAutorizacion", "enAutorizacion");

    /**
     * The '<em><b>Aceptado</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Aceptado</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ACEPTADO
     * @model name="aceptado"
     * @generated
     * @ordered
     */
    public static final int ACEPTADO_VALUE = 0;

    /**
     * The '<em><b>Rechazado</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Rechazado</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RECHAZADO
     * @model name="rechazado"
     * @generated
     * @ordered
     */
    public static final int RECHAZADO_VALUE = 1;

    /**
     * The '<em><b>En Autorizacion</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>En Autorizacion</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #EN_AUTORIZACION
     * @model name="enAutorizacion"
     * @generated
     * @ordered
     */
    public static final int EN_AUTORIZACION_VALUE = 2;

    /**
     * An array of all the '<em><b>Estado Proyecto</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final EstadoProyecto[] VALUES_ARRAY = new EstadoProyecto[] {
            ACEPTADO, RECHAZADO, EN_AUTORIZACION, };

    /**
     * A public read-only list of all the '<em><b>Estado Proyecto</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<EstadoProyecto> VALUES = Collections
            .unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Estado Proyecto</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EstadoProyecto get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EstadoProyecto result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Estado Proyecto</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EstadoProyecto getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            EstadoProyecto result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Estado Proyecto</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EstadoProyecto get(int value) {
        switch (value) {
        case ACEPTADO_VALUE:
            return ACEPTADO;
        case RECHAZADO_VALUE:
            return RECHAZADO;
        case EN_AUTORIZACION_VALUE:
            return EN_AUTORIZACION;
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
    private EstadoProyecto(int value, String name, String literal) {
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

} //EstadoProyecto
