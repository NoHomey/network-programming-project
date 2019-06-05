package client.read.event.single_user.course.course_only.system;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.course_only.SingleUserCourseOnlyEvent;

public abstract class SingleUserCourseOnlySystemEvent extends SingleUserCourseOnlyEvent {
    public static final String componentValue = "System";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(CourseUserListViewedEvent.eventNameValue.equals(eventName)) {
                return CourseUserListViewedEvent.fromDescription(description);
            }
            if(CourseViewedEvent.eventNameValue.equals(eventName)) {
                return CourseViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    public SingleUserCourseOnlySystemEvent(String eventName, int userID, int courseID) {
        super(componentValue, eventName, userID, courseID);
    }
}