package client.read.event.single_user.course_module.discussion.discussion_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class DiscussionCreatedEvent extends DiscussionActionEvent {
    private static final String action = "created";
    private static final Pattern pattern = DiscussionActionEvent.disscussionPattern(action);
    
    public static final String eventNameValue = DiscussionActionEvent.discussionEventName(action);

    public static DiscussionCreatedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final DiscussionActionEvent.DescriptionData data = DiscussionActionEvent.fromDescription(pattern, description);
        return new DiscussionCreatedEvent(data.userID, data.discussionID, data.courseModuleID); 
    }

    public DiscussionCreatedEvent(int userID, int discussionID, int courseModuleID) {
        super(eventNameValue, userID, discussionID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForDiscussionDescription(action);
    }
}