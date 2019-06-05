package client.read.event.two_users.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserProfileViewedEvent extends TwoUsersCourseEvent {
    private static final Pattern pattern = Pattern.compile(
            "\\AThe user with id '(0|[123456789]\\d*)' viewed the profile for the user with id '(0|[123456789]\\d*)' in the course with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    
    public static final String componentValue = "System";
    public static final String eventNameValue = "User profile viewed";

    public static UserProfileViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int affectedUserID = Integer.parseInt(matcher.group(2));
            final int courseID = Integer.parseInt(matcher.group(3));
            return new UserProfileViewedEvent(eventUserID, affectedUserID, courseID);
        } else throw new DescriptionMatchFailException(description);
    }

    public UserProfileViewedEvent(int eventUserID, int affectedUserID, int courseID) {
        super(componentValue, eventNameValue, eventUserID, affectedUserID, courseID);
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + eventUserID + "' viewed the profile for the user with id '" + affectedUserID + "' in the course with id '" + courseID + "'.";
    }
}