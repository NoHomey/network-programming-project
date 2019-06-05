package client.read.event.single_user.course.course_only.user_viewed_course_report;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class LogReportViewedEvent extends UserViewedCourseReportEvent {
    private static final String report = "log";
    private static final String preposition = "for";
    private static final Pattern pattern = UserViewedCourseReportEvent.userViewedCourseReportPattern(report, preposition);

    public static final String componentValue = "Logs";
    public static final String eventNameValue = "Log report viewed";

    public static LogReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserViewedCourseReportEvent.DescriptionData data = UserViewedCourseReportEvent.fromDescription(pattern, description);
        return new LogReportViewedEvent(data.userID, data.courseID);
    }

    public LogReportViewedEvent(int userID, int courseID) {
        super(componentValue, eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserViewedCourseReportDescription(report, preposition);
    }
}