package exception;

public class AgeOutOfBound extends RuntimeException{
    public AgeOutOfBound() {
    }

    public AgeOutOfBound(String message) {
        super(message);
    }
}
