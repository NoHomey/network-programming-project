package client.read.event.single_user.course_module.course_module_activity.system_activity;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;

public abstract class UserCourseModuleSystemActivityEvent extends UserCourseModuleActivityEvent {
    protected static final String activity = "resource";

    public static final String componentValue = "System";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserCourseModuleSystemCreatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleSystemCreatedEvent.fromDescription(description);
            }
            if(UserCourseModuleSystemDeletedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleSystemDeletedEvent.fromDescription(description);
            }
            if(UserCourseModuleSystemUpdatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleSystemUpdatedEvent.fromDescription(description);
            }
            if(UserCourseModuleSystemViewedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleSystemViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public UserCourseModuleSystemActivityEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID, activity);
    }
}