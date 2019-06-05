package client.read.event.single_user.course_module.discussion.discussion_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.discussion.DiscussionEvent;

public abstract class DiscussionActionEvent extends DiscussionEvent {
    protected static String discussionEventName(String action) {
        return "Discussion " + action;
    }

    protected static Pattern disscussionPattern(String action) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' has " + action + " the discussion with id '(0|[123456789]\\d*)' in the forum with course module id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(DiscussionCreatedEvent.eventNameValue.equals(eventName)) {
                return DiscussionCreatedEvent.fromDescription(description);
            }
            if(DiscussionDeletedEvent.eventNameValue.equals(eventName)) {
                return DiscussionDeletedEvent.fromDescription(description);
            }
            if(DiscussionUpdatedEvent.eventNameValue.equals(eventName)) {
                return DiscussionUpdatedEvent.fromDescription(description);
            }
            if(DiscussionViewedEvent.eventNameValue.equals(eventName)) {
                return DiscussionViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public DiscussionActionEvent(String eventName, int userID, int discussionID, int courseModuleID) {
        super(eventName, userID, discussionID, courseModuleID);
    }

    protected final String valueForDiscussionDescription(String action) {
        return "The user with id '" + userID + "' has " + action + " the discussion with id '" + discussionID  + "' in the forum with course module id '" + courseModuleID + "'.";
    }
}