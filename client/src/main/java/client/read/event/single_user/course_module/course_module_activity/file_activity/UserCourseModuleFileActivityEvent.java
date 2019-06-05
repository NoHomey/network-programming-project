package client.read.event.single_user.course_module.course_module_activity.file_activity;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;

public abstract class UserCourseModuleFileActivityEvent extends UserCourseModuleActivityEvent {
    protected static final String activity = "resource";

    public static final String componentValue = "File";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserCourseModuleFileCreatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleFileCreatedEvent.fromDescription(description);
            }
            if(UserCourseModuleFileDeletedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleFileDeletedEvent.fromDescription(description);
            }
            if(UserCourseModuleFileUpdatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleFileUpdatedEvent.fromDescription(description);
            }
            if(UserCourseModuleFileViewedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleFileViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public UserCourseModuleFileActivityEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID, activity);
    }
}