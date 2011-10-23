package mx.gearsofcode.proyservsocial.logico.util;
/**
 * Clase utilizada para identificar cuando una operacion de modificacion
 * en la base de datos tuvo algun problema.
 * @author snowingheart
 *
 */
public class DBModificationException extends Exception {

    public DBModificationException() {
        // TODO Auto-generated constructor stub
    }

    public DBModificationException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public DBModificationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public DBModificationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
