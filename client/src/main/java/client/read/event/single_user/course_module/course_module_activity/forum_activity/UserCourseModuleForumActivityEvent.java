package client.read.event.single_user.course_module.course_module_activity.forum_activity;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;

public abstract class UserCourseModuleForumActivityEvent extends UserCourseModuleActivityEvent {
    protected static final String activity = "forum";

    public static final String componentValue = "Forum";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserCourseModuleForumCreatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleForumCreatedEvent.fromDescription(description);
            }
            if(UserCourseModuleForumDeletedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleForumDeletedEvent.fromDescription(description);
            }
            if(UserCourseModuleForumUpdatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleForumUpdatedEvent.fromDescription(description);
            }
            if(UserCourseModuleForumViewedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleForumViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public UserCourseModuleForumActivityEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID, activity);
    }
}