package ar.com.apicashonline.cashonline.excepciones;

public class PaginaNoExisteException extends Exception {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PaginaNoExisteException(String mensaje) {
        super(mensaje);
    }
    
}
