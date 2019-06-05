package client.read.event.single_user.course_module.course_module_activity.page_activity;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserCourseModulePageCreatedEvent extends UserCourseModulePageActivityEvent {
    private static final String action = "created";
    private static final Pattern pattern = UserCourseModulePageActivityEvent.userCourseModuleActivityPattern(action, activity);
    
    public static final String eventNameValue = UserCourseModulePageActivityEvent.courseModuleEventName(action);

    public static UserCourseModulePageCreatedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserCourseModulePageActivityEvent.DescriptionData data = UserCourseModulePageActivityEvent.fromDescription(pattern, description);
        return new UserCourseModulePageCreatedEvent(data.userID, data.courseModuleID); 
    }

    public UserCourseModulePageCreatedEvent(int userID, int courseModuleID) {
        super(eventNameValue, userID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserCourseModuleActivityDescription(action);
    }
}