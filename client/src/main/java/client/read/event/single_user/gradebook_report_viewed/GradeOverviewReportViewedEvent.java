package client.read.event.single_user.gradebook_report_viewed;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class GradeOverviewReportViewedEvent extends GradebookReportViewedEvent {
    private static final String report = "overview";
    private static final Pattern pattern = GradebookReportViewedEvent.gradebookReportViewedPattern(report);
    
    public static final String componentValue = "Overview report";
    public static final String eventNameValue = GradeUserReportViewedEvent.gradebookReportViewedEventName(report);

    public static GradeOverviewReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final int userID = GradeUserReportViewedEvent.fromDescription(pattern, description);
        return new GradeOverviewReportViewedEvent(userID);
    }

    public GradeOverviewReportViewedEvent(int userID) {
        super(componentValue, eventNameValue, userID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForGradebookReportViewedDescription(report);
    }
}