package client.read.event.single_user.course_module.discussion.discussion_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class DiscussionViewedEvent extends DiscussionActionEvent {
    private static final String action = "viewed";
    private static final Pattern pattern = DiscussionActionEvent.disscussionPattern(action);
    
    public static final String eventNameValue = DiscussionActionEvent.discussionEventName(action);

    public static DiscussionViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final DiscussionActionEvent.DescriptionData data = DiscussionActionEvent.fromDescription(pattern, description);
        return new DiscussionViewedEvent(data.userID, data.discussionID, data.courseModuleID); 
    }

    public DiscussionViewedEvent(int userID, int discussionID, int courseModuleID) {
        super(eventNameValue, userID, discussionID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForDiscussionDescription(action);
    }
}