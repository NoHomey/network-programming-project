package client.read.event.single_user;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.calendar_event_action.CalendarEventActionEvent;
import client.read.event.single_user.course.SingleUserCourseEvent;
import client.read.event.single_user.course_module.SingleUserCourseModuleEvent;
import client.read.event.single_user.enrolment_instance_action.EnrolmentInstanceActionEvent;
import client.read.event.single_user.gradebook_report_viewed.GradebookReportViewedEvent;

public abstract class SingleUserEvent extends Event {
    protected static class DescriptionData {
        public final int userID;

        public DescriptionData(int userID) {
            this.userID = userID;
        }
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        Event event = CalendarEventActionEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = SingleUserCourseEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = SingleUserCourseModuleEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = EnrolmentInstanceActionEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        return GradebookReportViewedEvent.fromData(component, eventName, description);
    }

    protected final int userID;

    public SingleUserEvent(String component, String eventName, int userID) {
        super(component, eventName);
        this.userID = userID;
    }
    
    @Override
    public final Integer valueForEventUserID() {
        return userID;
    }
}