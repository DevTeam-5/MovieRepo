package utility.customException;

/**
 * Reflection 에서 예외 발생 시 사용
 */
public class CustomReflectionException extends RuntimeException{

    public CustomReflectionException() {}
    public CustomReflectionException(Exception e) {}
    public CustomReflectionException(String message) {
        super(message);
    }
}
