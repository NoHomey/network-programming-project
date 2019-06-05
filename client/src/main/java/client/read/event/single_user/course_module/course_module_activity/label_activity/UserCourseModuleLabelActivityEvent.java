package client.read.event.single_user.course_module.course_module_activity.label_activity;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;

public abstract class UserCourseModuleLabelActivityEvent extends UserCourseModuleActivityEvent {
    protected static final String activity = "label";

    public static final String componentValue = "System";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserCourseModuleLabelCreatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleLabelCreatedEvent.fromDescription(description);
            }
            if(UserCourseModuleLabelDeletedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleLabelDeletedEvent.fromDescription(description);
            }
            if(UserCourseModuleLabelUpdatedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleLabelUpdatedEvent.fromDescription(description);
            }
            if(UserCourseModuleLabelViewedEvent.eventNameValue.equals(eventName)) {
                return UserCourseModuleLabelViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public UserCourseModuleLabelActivityEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID, activity);
    }
}