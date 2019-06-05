package client.read.event;

public final class DescriptionMatchFailException extends Exception {;
    private static final long serialVersionUID = -1515079140013599202L;
    private static final String message = "Failed to match description pattern for: ";

    public DescriptionMatchFailException(String description) {
        super(message + description);
    }
}