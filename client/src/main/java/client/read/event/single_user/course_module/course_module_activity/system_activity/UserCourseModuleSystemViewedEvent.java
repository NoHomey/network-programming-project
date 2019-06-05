package client.read.event.single_user.course_module.course_module_activity.system_activity;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserCourseModuleSystemViewedEvent extends UserCourseModuleSystemActivityEvent {
    private static final String action = "viewed";
    private static final Pattern pattern = UserCourseModuleSystemActivityEvent.userCourseModuleActivityPattern(action, activity);
    
    public static final String eventNameValue = UserCourseModuleSystemActivityEvent.courseModuleEventName(action);

    public static UserCourseModuleSystemViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserCourseModuleSystemActivityEvent.DescriptionData data = UserCourseModuleSystemActivityEvent.fromDescription(pattern, description);
        return new UserCourseModuleSystemViewedEvent(data.userID, data.courseModuleID); 
    }

    public UserCourseModuleSystemViewedEvent(int userID, int courseModuleID) {
        super(eventNameValue, userID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserCourseModuleActivityDescription(action);
    }
}