package exceptions;

/**
 * Exceção personalizada para erros relacionados ao banco de dados.
 */
public class DbException extends RuntimeException {
    public DbException(String message) {
        super(message);
    }
}
