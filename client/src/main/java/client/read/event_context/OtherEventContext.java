package client.read.event_context;

public final class OtherEventContext extends EventContext {
    private static final String other = "Other";
    private static final OtherEventContext instance = new OtherEventContext();

    public static EventContext fromContext(String context) {
        if(context.equals(other)) {
            return obtainInstance();
        }
        return null;
    }

    public static OtherEventContext obtainInstance() {
        return instance;
    }

    private OtherEventContext() {
        super();
    }

    @Override
    public final String valueForEventContext() {
        return other;
    }

    @Override
    public final String valueForEventContextKind() {
        return other;
    }

    @Override
    public final String valueForResourceName() {
        return null;
    }
}