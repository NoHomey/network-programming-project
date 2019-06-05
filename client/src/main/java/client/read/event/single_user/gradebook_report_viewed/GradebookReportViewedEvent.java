package client.read.event.single_user.gradebook_report_viewed;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.SingleUserEvent;

public abstract class GradebookReportViewedEvent extends SingleUserEvent {
    protected static String gradebookReportViewedEventName(String report) {
        return "Grade " + report + " report viewed";
    }

    protected static Pattern gradebookReportViewedPattern(String report) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' viewed the " + report + " report in the gradebook\\Q.\\E\\z");
    }

    protected static int fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            return userID;
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(GradeOverviewReportViewedEvent.componentValue.equals(component) && GradeOverviewReportViewedEvent.eventNameValue.equals(eventName)) {
            return GradeOverviewReportViewedEvent.fromDescription(description);
        }
        if(GraderReportViewedEvent.componentValue.equals(component) && GraderReportViewedEvent.eventNameValue.equals(eventName)) {
            return GraderReportViewedEvent.fromDescription(description);
        }
        if(GradeUserReportViewedEvent.componentValue.equals(component) && GradeUserReportViewedEvent.eventNameValue.equals(eventName)) {
            return GradeUserReportViewedEvent.fromDescription(description);
        }
        return null;
    }

    public GradebookReportViewedEvent(String component, String eventName, int userID) {
        super(component, eventName, userID);
    }

    protected final String valueForGradebookReportViewedDescription(String report) {
        return "The user with id '" + userID + "' viewed the " + report + " report in the gradebook.";
    }
}