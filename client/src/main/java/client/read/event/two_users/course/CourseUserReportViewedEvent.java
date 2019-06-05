package client.read.event.two_users.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CourseUserReportViewedEvent extends TwoUsersCourseEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' viewed the user report for the course with id '(0|[123456789]\\d*)' for user with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    
    public static final String componentValue = "System";
    public static final String eventNameValue = "Course user report viewed";

    public static CourseUserReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int courseID = Integer.parseInt(matcher.group(2));
            final int affectedUserID = Integer.parseInt(matcher.group(3));
            return new CourseUserReportViewedEvent(eventUserID, courseID, affectedUserID);
        } else throw new DescriptionMatchFailException(description);
    }

    public CourseUserReportViewedEvent(int eventUserID, int courseID, int affectedUserID) {
        super(componentValue, eventNameValue, eventUserID, affectedUserID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + eventUserID + "' viewed the user report for the course with id '" + courseID + "' for user with id '" + affectedUserID + "'.";
    }
}