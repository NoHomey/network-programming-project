package client.read.event.single_user.course;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.SingleUserEvent;
import client.read.event.single_user.course.course_only.SingleUserCourseOnlyEvent;
import client.read.event.single_user.course.section_action.CourseSectionActionEvent;

public abstract class SingleUserCourseEvent extends SingleUserEvent {
    protected static class DescriptionData extends SingleUserEvent.DescriptionData {
        public final int courseID;

        public DescriptionData(int userID, int courseID) {
            super(userID);
            this.courseID = courseID;
        }
    }

    protected final int courseID;

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        final Event event = SingleUserCourseOnlyEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        return CourseSectionActionEvent.fromData(component, eventName, description);
    }

    public SingleUserCourseEvent(String component, String eventName, int userID, int courseID) {
        super(component, eventName, userID);
        this.courseID = courseID;
    }
    
    @Override
    public final Integer valueForCourseID() {
        return courseID;
    }
}