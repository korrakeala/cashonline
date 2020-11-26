package ar.com.apicashonline.cashonline.excepciones;

public class UsuarioExisteException extends Exception {

    private static final long serialVersionUID = 1L;

    public UsuarioExisteException(String mensaje) {
        super(mensaje);
    }
    
}
