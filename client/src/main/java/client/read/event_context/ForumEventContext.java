package client.read.event_context;

public final class ForumEventContext extends EventContextWithResourceName {
    public static final String kindValue = "Forum";

    public ForumEventContext(String forumName) {
        super(kindValue, forumName);
    }
}