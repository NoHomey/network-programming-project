package client.read.event.two_users.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class UserReportViewedEvent extends TwoUsersCourseEvent {
    private static final Pattern pattern = Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' has viewed the user report for the user with id '(0|[123456789]\\d*)' in the course with id '(0|[123456789]\\d*)' with viewing mode '(\\w+)'\\Q.\\E\\z");
    
    public static final String componentValue = "Forum";
    public static final String eventNameValue = "User report viewed";

    public static UserReportViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int affectedUserID = Integer.parseInt(matcher.group(2));
            final int courseID = Integer.parseInt(matcher.group(3));
            final String viewingMode = matcher.group(4);
            return new UserReportViewedEvent(eventUserID, affectedUserID, courseID, viewingMode);
        } else throw new DescriptionMatchFailException(description);
    }

    private final String viewingMode;

    public UserReportViewedEvent(int eventUserID, int affectedUserID, int courseID, String viewingMode) {
        super(componentValue, eventNameValue, eventUserID, affectedUserID, courseID);
        this.viewingMode = viewingMode;
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + eventUserID + "' has viewed the user report for the user with id '" + affectedUserID + "' in the course with id '" + courseID + "' with viewing mode '" + viewingMode + "'.";
    }

    @Override
    public final String valueForViewingMode() {
        return viewingMode;
    }
}