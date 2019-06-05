package client.read.event.single_user.course_module.course_module_activity.page_activity;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;

public abstract class UserCourseModulePageActivityEvent extends UserCourseModuleActivityEvent {
    protected static final String activity = "page";

    public static final String componentValue = "Page";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserCourseModulePageCreatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModulePageCreatedEvent.fromDescription(description);
            }
            if(UserCourseModulePageDeletedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModulePageDeletedEvent.fromDescription(description);
            }
            if(UserCourseModulePageUpdatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModulePageUpdatedEvent.fromDescription(description);
            }
            if(UserCourseModulePageViewedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModulePageViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public UserCourseModulePageActivityEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID, activity);
    }
}