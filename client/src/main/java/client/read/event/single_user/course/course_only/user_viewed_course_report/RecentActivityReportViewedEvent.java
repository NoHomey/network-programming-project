package client.read.event.single_user.course.course_only.user_viewed_course_report;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class RecentActivityReportViewedEvent extends UserViewedCourseReportEvent {
    private static final String report = "recent activity";
    private static final String preposition = "in";
    private static final Pattern pattern = UserViewedCourseReportEvent.userViewedCourseReportPattern(report, preposition);

    public static final String componentValue = "System";
    public static final String eventNameValue = "Recent activity viewed";

    public static RecentActivityReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final UserViewedCourseReportEvent.DescriptionData data = UserViewedCourseReportEvent.fromDescription(pattern, description);
        return new RecentActivityReportViewedEvent(data.userID, data.courseID);
    }

    public RecentActivityReportViewedEvent(int userID, int courseID) {
        super(componentValue, eventNameValue, userID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForUserViewedCourseReportDescription(report, preposition);
    }
}