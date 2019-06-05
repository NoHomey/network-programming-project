package client.read.event_context;

public abstract class EventContext implements EventContextValues {
    public static class EventContextParseException extends Exception {
        private static final long serialVersionUID = 9132108635525574045L;

        public EventContextParseException(String context) {
            super(context + " is not a valid Event context data");
        }
    }

    public static EventContext fromContext(String context) throws EventContextParseException {
        EventContext eventContext = OtherEventContext.fromContext(context);
        if(eventContext != null) {
            return eventContext;
        }
        eventContext = EventContextWithResourceName.fromContext(context);
        if(eventContext != null) {
            return eventContext;
        }
        throw new EventContextParseException(context);
    }

    public abstract String valueForEventContext();

    public abstract String valueForEventContextKind();

    public abstract String valueForResourceName();
}