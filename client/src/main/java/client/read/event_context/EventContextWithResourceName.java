package client.read.event_context;

public abstract class EventContextWithResourceName extends EventContext {
    private final String kind;
    private final String name;

    public static EventContext fromContext(String context) {
        final String[] info = context.split(": ");
        final String kind = info[0];
        final String name = info[1];
        if(CourseEventContext.kindValue.equals(kind)) {
            return new CourseEventContext(name);
        }
        if(FileEventContext.kindValue.equals(kind)) {
            return new FileEventContext(name);
        }
        if(ForumEventContext.kindValue.equals(kind)) {
            return new ForumEventContext(name);
        }
        if(PageEventContext.kindValue.equals(kind)) {
            return new PageEventContext(name);
        }
        return null;
    }

    public EventContextWithResourceName(String kind, String name) {
        super();
        this.kind = kind;
        this.name = name;
    }

    @Override
    public final String valueForEventContext() {
        return kind + ": " + name;
    }

    @Override
    public final String valueForEventContextKind() {
        return kind;
    }

    @Override
    public final String valueForResourceName() {
        return name;
    }
}