package web.app.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String msg) {
        super("ERROR: Intento de acceso sin autorización: " + msg);
    }

}