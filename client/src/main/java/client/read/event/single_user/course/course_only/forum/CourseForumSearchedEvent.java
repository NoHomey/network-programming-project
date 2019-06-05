package client.read.event.single_user.course.course_only.forum;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CourseForumSearchedEvent extends SingleUserCourseOnlyForumEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' has searched the course with id '(0|[123456789]\\d*)' for forum posts containing \".*\"\\Q.\\E\\z");

    public static final String eventNameValue = "Course searched";

    public static CourseForumSearchedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final SingleUserCourseOnlyForumEvent.DescriptionData data = SingleUserCourseOnlyForumEvent.fromDescription(pattern, description);
        return new CourseForumSearchedEvent(data.userID, data.courseID);
    }

    public CourseForumSearchedEvent(int userID, int courseID) {
        super(eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + userID + "' has searched the course with id '" + courseID + "' for forum posts containing \"\".";    
    }
}