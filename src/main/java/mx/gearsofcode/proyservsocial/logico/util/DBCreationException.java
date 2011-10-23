/**
 * 
 */
package mx.gearsofcode.proyservsocial.logico.util;

/**
 * Clase utilizada para identificar cuando una operacion de creacion en la
 * base de datos tuvo algun problema.
 * 
 * @author snowingheart
 * 
 */
public class DBCreationException extends Exception {

    /**
     * 
     */
    public DBCreationException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public DBCreationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public DBCreationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public DBCreationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
