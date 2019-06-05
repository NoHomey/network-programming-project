package client.read.event.single_user.course_module;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.SingleUserEvent;
import client.read.event.single_user.course_module.course_module_activity.UserCourseModuleActivityEvent;
import client.read.event.single_user.course_module.discussion.DiscussionEvent;

public abstract class SingleUserCourseModuleEvent extends SingleUserEvent {
    protected static class DescriptionData extends SingleUserEvent.DescriptionData {
        public final int courseModuleID;

        public DescriptionData(int userID, int courseModuleID) {
            super(userID);
            this.courseModuleID = courseModuleID;
        }
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        Event event = UserCourseModuleActivityEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        return DiscussionEvent.fromData(component, eventName, description);
    }

    protected final int courseModuleID;

    public SingleUserCourseModuleEvent(String component, String eventName, int userID, int courseModuleID) {
        super(component, eventName, userID);
        this.courseModuleID = courseModuleID;
    }
    
    @Override
    public final Integer valueForCourseModuleID() {
        return courseModuleID;
    }
}