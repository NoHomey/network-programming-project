package client.read.event.single_user.course.course_only.user_viewed_course_report;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class ActivityReportViewedEvent extends UserViewedCourseReportEvent {
    private static final String report = "outline activity";
    private static final String preposition = "for";
    private static final Pattern pattern = UserViewedCourseReportEvent.userViewedCourseReportPattern(report, preposition);

    public static final String componentValue = "Activity report";
    public static final String eventNameValue = "Activity report viewed";

    public static ActivityReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserViewedCourseReportEvent.DescriptionData data = UserViewedCourseReportEvent.fromDescription(pattern, description);
        return new ActivityReportViewedEvent(data.userID, data.courseID);
    }

    public ActivityReportViewedEvent(int userID, int courseID) {
        super(componentValue, eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserViewedCourseReportDescription(report, preposition);
    }
}