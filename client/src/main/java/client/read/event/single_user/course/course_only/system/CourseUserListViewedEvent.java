package client.read.event.single_user.course.course_only.system;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CourseUserListViewedEvent extends SingleUserCourseOnlySystemEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' viewed the list of users in the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");

    public static final String eventNameValue = "User list viewed";

    public static CourseUserListViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final SingleUserCourseOnlySystemEvent.DescriptionData data = SingleUserCourseOnlySystemEvent.fromDescription(pattern, description);
        return new CourseUserListViewedEvent(data.userID, data.courseID);
    }

    public CourseUserListViewedEvent(int userID, int courseID) {
        super(eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + userID + "' viewed the list of users in the course with id '" + courseID + "'.";
    }
}