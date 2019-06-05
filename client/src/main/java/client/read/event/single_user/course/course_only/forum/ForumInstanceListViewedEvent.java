package client.read.event.single_user.course.course_only.forum;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class ForumInstanceListViewedEvent extends SingleUserCourseOnlyForumEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' viewed the instance list for the module 'forum' in the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    private static final String module = "forum";

    public static final String eventNameValue = "Course module instance list viewed";

    public static ForumInstanceListViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final SingleUserCourseOnlyForumEvent.DescriptionData data = SingleUserCourseOnlyForumEvent.fromDescription(pattern, description);
        return new ForumInstanceListViewedEvent(data.userID, data.courseID);
    }

    public ForumInstanceListViewedEvent(int userID, int courseID) {
        super(eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + userID + "' viewed the instance list for the module 'forum' in the course with id '" + courseID + "'.";    
    }

    @Override
    public final String valueForModule() {
        return module;
    }
}