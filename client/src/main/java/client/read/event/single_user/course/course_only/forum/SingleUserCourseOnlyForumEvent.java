package client.read.event.single_user.course.course_only.forum;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.course_only.SingleUserCourseOnlyEvent;

public abstract class SingleUserCourseOnlyForumEvent extends SingleUserCourseOnlyEvent {
    public static final String componentValue = "Forum";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(CourseForumSearchedEvent.eventNameValue.equals(eventName)) {
                return CourseForumSearchedEvent.fromDescription(description);
            }
            if(ForumInstanceListViewedEvent.eventNameValue.equals(eventName)) {
                return ForumInstanceListViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public SingleUserCourseOnlyForumEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID);
    }
}