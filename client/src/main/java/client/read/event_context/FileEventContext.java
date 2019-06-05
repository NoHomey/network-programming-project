package client.read.event_context;

public final class FileEventContext extends EventContextWithResourceName {
    public static final String kindValue = "File";

    public FileEventContext(String fileName) {
        super(kindValue, fileName);
    }
}