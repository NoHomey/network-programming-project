package client.read.event.two_users.course.enrolment_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserUnenrolledFromCourseEvent extends EnrolmentActionEvent {
    private static final String action = "unenrolled";
    private static final String preposition = "from";
    private static final Pattern pattern = EnrolmentActionEvent.enrolementActionPattern(action, preposition);
    
    public static final String eventNameValue = EnrolmentActionEvent.enrolementActionEventName(action, preposition);

    public static UserUnenrolledFromCourseEvent fromDescription(String description) throws DescriptionMatchFailException {
        EnrolmentActionEvent.DescriptionData data = EnrolmentActionEvent.fromDescription(pattern, description);
        return new UserUnenrolledFromCourseEvent(data.eventUserID, data.affectedUserID, data.enrolmentMethod, data.courseID);
    }

    public UserUnenrolledFromCourseEvent(int eventUserID, int affectedUserID, String enrolmentMethod, int courseID) {
        super(eventNameValue, eventUserID, affectedUserID, enrolmentMethod, courseID);
    }

    @Override
    public final String valueForDescription() {
        return super.enrolmentActionEventDescription(action, preposition);
    }
}