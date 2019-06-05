package client.read.event.single_user.course.course_only.user_viewed_course_report;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.course_only.SingleUserCourseOnlyEvent;

public abstract class UserViewedCourseReportEvent extends SingleUserCourseOnlyEvent {
    protected static Pattern userViewedCourseReportPattern(String report, String preposition) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' viewed the " + report + " report " + preposition + " the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(ActivityReportViewedEvent.componentValue.equals(component) && ActivityReportViewedEvent.eventNameValue.equals(eventName)) {
            return ActivityReportViewedEvent.fromDescription(description);
        }
        if(LiveLogReportViewedEvent.componentValue.equals(component) && LiveLogReportViewedEvent.eventNameValue.equals(eventName)) {
            return LiveLogReportViewedEvent.fromDescription(description);
        }
        if(LogReportViewedEvent.componentValue.equals(component) && LogReportViewedEvent.eventNameValue.equals(eventName)) {
            return LogReportViewedEvent.fromDescription(description);
        }
        if(RecentActivityReportViewedEvent.componentValue.equals(component) && RecentActivityReportViewedEvent.eventNameValue.equals(eventName)) {
            return RecentActivityReportViewedEvent.fromDescription(description);
        }
        return null;
    }

    public UserViewedCourseReportEvent(String component, String eventName, int userID, int courseID) {
        super(component, eventName, userID, courseID);
    }

    protected final String valueForUserViewedCourseReportDescription(String report, String preposition) {
        return "The user with id '" + userID + "' viewed the " + report + " report " + preposition + " the course with id '" + courseID + "'.";
    }
}