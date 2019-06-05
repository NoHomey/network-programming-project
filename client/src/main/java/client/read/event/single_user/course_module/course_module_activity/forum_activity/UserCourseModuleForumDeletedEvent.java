package client.read.event.single_user.course_module.course_module_activity.forum_activity;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserCourseModuleForumDeletedEvent extends UserCourseModuleForumActivityEvent {
    private static final String action = "deleted";
    private static final Pattern pattern = UserCourseModuleForumActivityEvent.userCourseModuleActivityPattern(action, activity);
    
    public static final String eventNameValue = UserCourseModuleForumActivityEvent.courseModuleEventName(action);

    public static UserCourseModuleForumDeletedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserCourseModuleForumActivityEvent.DescriptionData data = UserCourseModuleForumActivityEvent.fromDescription(pattern, description);
        return new UserCourseModuleForumDeletedEvent(data.userID, data.courseModuleID); 
    }

    public UserCourseModuleForumDeletedEvent(int userID, int courseModuleID) {
        super(eventNameValue, userID, courseModuleID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserCourseModuleActivityDescription(action);
    }
}