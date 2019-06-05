package client.read.event.single_user.enrolment_instance_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class EnrolmentInstanceCreatedEvent extends EnrolmentInstanceActionEvent {
    private static final String action = "created";
    private static final Pattern pattern = EnrolmentInstanceActionEvent.enrolmentInstanceActionPattern(action);
    
    public static final String eventNameValue = "Enrolment instance created";

    public static EnrolmentInstanceCreatedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final EnrolmentInstanceActionEvent.DescriptionData data = EnrolmentInstanceActionEvent.fromDescription(pattern, description);
        return new EnrolmentInstanceCreatedEvent(data.userID, data.enrolmentMethod, data.enrolmentID); 
    }

    public EnrolmentInstanceCreatedEvent(int userID, String enrolmentMethod, int enrolmentID) {
        super(eventNameValue, userID, enrolmentMethod, enrolmentID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForEnrolmentInstanceActionDescription(action);
    }
}