package client.read.event_context;

public final class PageEventContext extends EventContextWithResourceName {
    public static final String kindValue = "Page";

    public PageEventContext(String pageName) {
        super(kindValue, pageName);
    }
}