package exceptions;

/**
 * Exceção utilizada para representar erros de validação de dados de entrada.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
