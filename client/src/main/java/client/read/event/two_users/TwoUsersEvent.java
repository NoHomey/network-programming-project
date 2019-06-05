package client.read.event.two_users;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.course.TwoUsersCourseEvent;
import client.read.event.two_users.role_action.RoleActionEvent;

public abstract class TwoUsersEvent extends Event {
    protected static class DescriptionData {
        public final int eventUserID;
        public final int affectedUserID;

        public DescriptionData(int eventUserID, int affectedUserID) {
            this.eventUserID = eventUserID;
            this.affectedUserID = affectedUserID;
        }
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        final Event event = TwoUsersCourseEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        } else {
            return RoleActionEvent.fromData(component, eventName, description);
        }
    }

    protected final int eventUserID;
    protected final int affectedUserID;

    public TwoUsersEvent(String component, String eventName, int eventUserID, int affectedUserID) {
        super(component, eventName);
        this.eventUserID = eventUserID;
        this.affectedUserID = affectedUserID;
    }
    
    @Override
    public final Integer valueForEventUserID() {
        return eventUserID;
    }

    @Override
    public final Integer valueForAffectedUserID() {
        return affectedUserID;
    }
}