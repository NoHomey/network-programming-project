package client.read.event.single_user.gradebook_report_viewed;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class GraderReportViewedEvent extends GradebookReportViewedEvent {
    private static final String report = "grader";
    private static final Pattern pattern = GradebookReportViewedEvent.gradebookReportViewedPattern(report);
    
    public static final String componentValue = "Grader report";
    public static final String eventNameValue = "Grader report viewed";

    public static GraderReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final int userID = GradeUserReportViewedEvent.fromDescription(pattern, description);
        return new GraderReportViewedEvent(userID);
    }

    public GraderReportViewedEvent(int userID) {
        super(componentValue, eventNameValue, userID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForGradebookReportViewedDescription(report);
    }
}