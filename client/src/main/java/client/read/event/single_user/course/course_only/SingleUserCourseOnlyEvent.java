package client.read.event.single_user.course.course_only;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.SingleUserCourseEvent;
import client.read.event.single_user.course.course_only.forum.SingleUserCourseOnlyForumEvent;
import client.read.event.single_user.course.course_only.system.SingleUserCourseOnlySystemEvent;
import client.read.event.single_user.course.course_only.user_viewed_course_report.UserViewedCourseReportEvent;

public abstract class SingleUserCourseOnlyEvent extends SingleUserCourseEvent {
    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final int courseID = Integer.parseInt(matcher.group(2));
            return new DescriptionData(userID, courseID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        Event event = SingleUserCourseOnlyForumEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = SingleUserCourseOnlySystemEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        return UserViewedCourseReportEvent.fromData(component, eventName, description);
    }

    public SingleUserCourseOnlyEvent(String component, String eventName, int userID, int courseID) {
        super(component, eventName, userID, courseID);
    }
}