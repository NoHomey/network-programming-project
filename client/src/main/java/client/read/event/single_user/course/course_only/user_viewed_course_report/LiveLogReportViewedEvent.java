package client.read.event.single_user.course.course_only.user_viewed_course_report;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class LiveLogReportViewedEvent extends UserViewedCourseReportEvent {
    private static final String report = "live log";
    private static final String preposition = "for";
    private static final Pattern pattern = UserViewedCourseReportEvent.userViewedCourseReportPattern(report, preposition);

    public static final String componentValue = "Live logs";
    public static final String eventNameValue = "Live log report viewed";

    public static LiveLogReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserViewedCourseReportEvent.DescriptionData data = UserViewedCourseReportEvent.fromDescription(pattern, description);;
        return new LiveLogReportViewedEvent(data.userID, data.courseID);
    }

    public LiveLogReportViewedEvent(int userID, int courseID) {
        super(componentValue, eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserViewedCourseReportDescription(report, preposition);
    }
}