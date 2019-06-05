package client.read.event.two_users.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.TwoUsersEvent;
import client.read.event.two_users.course.enrolment_action.EnrolmentActionEvent;

public abstract class TwoUsersCourseEvent extends TwoUsersEvent {
    protected static class DescriptionData extends TwoUsersEvent.DescriptionData {
        public final int courseID;

        public DescriptionData(int eventUserID, int affectedUserID, int courseID) {
            super(eventUserID, affectedUserID);
            this.courseID = courseID;
        }
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int courseID = Integer.parseInt(matcher.group(2));
            final int affectedUserID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(eventUserID, courseID, affectedUserID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(CourseUserReportViewedEvent.componentValue.equals(component) && CourseUserReportViewedEvent.eventNameValue.equals(eventName)) {
            return CourseUserReportViewedEvent.fromDescription(description);
        }
        if(UserReportViewedEvent.componentValue.equals(component) && UserReportViewedEvent.eventNameValue.equals(eventName)) {
            return UserReportViewedEvent.fromDescription(description);
        }
        if(UserProfileViewedEvent.componentValue.equals(component) && UserProfileViewedEvent.eventNameValue.equals(eventName)) {
            return UserProfileViewedEvent.fromDescription(description);
        }
        return EnrolmentActionEvent.fromData(component, eventName, description);
    }

    protected final int courseID;

    public TwoUsersCourseEvent(String component, String eventName, int eventUserID, int affectedUserID, int courseID) {
        super(component, eventName, eventUserID, affectedUserID);
        this.courseID = courseID;
    }

    @Override
    public final Integer valueForCourseID() {
        return courseID;
    }
}