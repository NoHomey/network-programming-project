package client.read.event.single_user.course.course_only.system;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CourseViewedEvent extends SingleUserCourseOnlySystemEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' viewed the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");

    public static final String eventNameValue = "Course viewed";

    public static CourseViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final SingleUserCourseOnlySystemEvent.DescriptionData data = SingleUserCourseOnlySystemEvent.fromDescription(pattern, description);
        return new CourseViewedEvent(data.userID, data.courseID);
    }

    public CourseViewedEvent(int userID, int courseID) {
        super(eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + userID + "' viewed the course with id '" + courseID + "'.";
    }
}