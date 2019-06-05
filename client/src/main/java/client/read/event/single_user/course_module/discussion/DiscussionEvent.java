package client.read.event.single_user.course_module.discussion;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.SingleUserCourseModuleEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionActionEvent;

public abstract class DiscussionEvent extends SingleUserCourseModuleEvent {
    protected static class DescriptionData extends SingleUserCourseModuleEvent.DescriptionData {
        public final int discussionID;

        public DescriptionData(int userID, int discussionID, int courseModuleID) {
            super(userID, courseModuleID);
            this.discussionID = discussionID;
        }
    }

    public static final String componentValue = "Forum";

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final int discussionID = Integer.parseInt(matcher.group(2));
            final int courseModuleID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(userID, discussionID, courseModuleID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(SomeContentHasBeenPostedEvent.eventNameValue.equals(eventName)) {
                return SomeContentHasBeenPostedEvent.fromDescription(description);
            }
            return DiscussionActionEvent.fromData(component, eventName, description);
        }
        return null;
    }

    protected final int discussionID;

    public DiscussionEvent(String eventName, int userID, int discussionID, int courseModuleID) {
        super(componentValue, eventName, userID, courseModuleID);
        this.discussionID = discussionID;
    }

    @Override
    public final Integer valueForDiscussionID() {
        return discussionID;
    }
}