package client.read.event.single_user.course_module.course_module_activity.file_activity;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserCourseModuleFileDeletedEvent extends UserCourseModuleFileActivityEvent {
    private static final String action = "deleted";
    private static final Pattern pattern = UserCourseModuleFileActivityEvent.userCourseModuleActivityPattern(action, activity);
    
    public static final String eventNameValue = UserCourseModuleFileActivityEvent.courseModuleEventName(action);

    public static UserCourseModuleFileDeletedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserCourseModuleFileActivityEvent.DescriptionData data = UserCourseModuleFileActivityEvent.fromDescription(pattern, description);
        return new UserCourseModuleFileDeletedEvent(data.userID, data.courseModuleID); 
    }

    public UserCourseModuleFileDeletedEvent(int userID, int courseModuleID) {
        super(eventNameValue, userID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserCourseModuleActivityDescription(action);
    }
}