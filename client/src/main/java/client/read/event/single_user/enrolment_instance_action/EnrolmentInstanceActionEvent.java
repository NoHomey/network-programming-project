package client.read.event.single_user.enrolment_instance_action;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.SingleUserEvent;

public abstract class EnrolmentInstanceActionEvent extends SingleUserEvent {
    protected static class DescriptionData extends SingleUserEvent.DescriptionData {
        public final String enrolmentMethod;
        public final int enrolmentID;

        public DescriptionData(int userID, String enrolmentMethod, int enrolmentID) {
            super(userID);
            this.enrolmentMethod = enrolmentMethod;
            this.enrolmentID = enrolmentID;
        }
    }

    public static final String componentValue = "System";

    protected static Pattern enrolmentInstanceActionPattern(String action) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action + " the instance of enrolment method '(\\w+)' with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final String enrolmentMethod = matcher.group(2);
            final int enrolmentID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(userID, enrolmentMethod, enrolmentID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(EnrolmentInstanceCreatedEvent.eventNameValue.equals(eventName)) {
                return EnrolmentInstanceCreatedEvent.fromDescription(description);
            }
            if(EnrolmentInstanceDeletedEvent.eventNameValue.equals(eventName)) {
                return EnrolmentInstanceDeletedEvent.fromDescription(description);
            }
        }
        return null;
    }

    protected final int enrolmentID;
    protected final String enrolmentMethod;

    public EnrolmentInstanceActionEvent(String eventName, int userID, String enrolmentMethod, int enrolmentID) {
        super(componentValue, eventName, userID);
        this.enrolmentMethod = enrolmentMethod;
        this.enrolmentID = enrolmentID;
    }

    protected final String valueForEnrolmentInstanceActionDescription(String action) {
        return "The user with id '" + userID + "' " + action + " the instance of enrolment method '" + enrolmentMethod + "' with id '" + enrolmentID  + "'.";
    }

    @Override
    public final Integer valueForEnrolmentID() {
        return enrolmentID;
    }

    @Override
    public final String valueForEnrolmentMethod() {
        return enrolmentMethod;
    }
}