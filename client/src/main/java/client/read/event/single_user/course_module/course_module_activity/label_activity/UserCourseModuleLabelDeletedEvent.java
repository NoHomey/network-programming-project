package client.read.event.single_user.course_module.course_module_activity.label_activity;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserCourseModuleLabelDeletedEvent extends UserCourseModuleLabelActivityEvent {
    private static final String action = "deleted";
    private static final Pattern pattern = UserCourseModuleLabelActivityEvent.userCourseModuleActivityPattern(action, activity);
    
    public static final String eventNameValue = UserCourseModuleLabelActivityEvent.courseModuleEventName(action);

    public static UserCourseModuleLabelDeletedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserCourseModuleLabelActivityEvent.DescriptionData data = UserCourseModuleLabelActivityEvent.fromDescription(pattern, description);
        return new UserCourseModuleLabelDeletedEvent(data.userID, data.courseModuleID); 
    }

    public UserCourseModuleLabelDeletedEvent(int userID, int courseModuleID) {
        super(eventNameValue, userID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserCourseModuleActivityDescription(action);
    }
}