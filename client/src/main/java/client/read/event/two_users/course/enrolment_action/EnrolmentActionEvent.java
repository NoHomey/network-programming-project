package client.read.event.two_users.course.enrolment_action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.course.TwoUsersCourseEvent;

public abstract class EnrolmentActionEvent extends TwoUsersCourseEvent {
    public static class DescriptionData extends TwoUsersCourseEvent.DescriptionData {
        public final String enrolmentMethod;

        public DescriptionData(int eventUserID, int affectedUserID, String enrolmentMethod, int courseID) {
            super(eventUserID, affectedUserID, courseID);
            this.enrolmentMethod = enrolmentMethod;
        }
    }

    public static final String componentValue = "System";

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int affectedUserID = Integer.parseInt(matcher.group(2));
            final String enrolmentMehtod = matcher.group(3);
            final int courseID = Integer.parseInt(matcher.group(4));
            return new DescriptionData(eventUserID, affectedUserID, enrolmentMehtod, courseID);
        } else throw new DescriptionMatchFailException(description);
    }

    protected static Pattern enrolementActionPattern(String action, String preposition) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action + " the user with id '(0|[123456789]\\d*)' using the enrolment method '(\\w+)' " + preposition + " the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    protected static String enrolementActionEventName(String action, String preposition) {
        return "User " + action + " " + preposition + " course";
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(UserEnrolledInCourseEvent.eventNameValue.equals(eventName)) {
                return UserEnrolledInCourseEvent.fromDescription(description);
            }
            if(UserUnenrolledFromCourseEvent.eventNameValue.equals(eventName)) {
                return UserUnenrolledFromCourseEvent.fromDescription(description);
            }
        }
        return null;
    }

    private final String enrolmentMethod;

    public EnrolmentActionEvent(String eventName, int eventUserID, int affectedUserID, String enrolmentMethod, int courseID) {
        super(componentValue, eventName, eventUserID, affectedUserID, courseID);
        this.enrolmentMethod = enrolmentMethod;
    }

    protected final String enrolmentActionEventDescription(String action, String preposition) {
        return "The user with id '" + eventUserID + "' " + action + " the user with id '" +  affectedUserID + "' using the enrolment method '" + enrolmentMethod + "' " + preposition + " the course with id '" + courseID + "'.";
    }

    @Override
    public final String valueForEnrolmentMethod() {
        return enrolmentMethod;
    }
}