package client.read.event.single_user.enrolment_instance_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class EnrolmentInstanceDeletedEvent extends EnrolmentInstanceActionEvent {
    private static final String action = "deleted";
    private static final Pattern pattern = EnrolmentInstanceActionEvent.enrolmentInstanceActionPattern(action);
    
    public static final String eventNameValue = "Grouping deleted";

    public static EnrolmentInstanceDeletedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final EnrolmentInstanceActionEvent.DescriptionData data = EnrolmentInstanceActionEvent.fromDescription(pattern, description);
        return new EnrolmentInstanceDeletedEvent(data.userID, data.enrolmentMethod, data.enrolmentID); 
    }

    public EnrolmentInstanceDeletedEvent(int userID, String enrolmentMethod, int enrolmentID) {
        super(eventNameValue, userID, enrolmentMethod, enrolmentID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForEnrolmentInstanceActionDescription(action);
    }
}