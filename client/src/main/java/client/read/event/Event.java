package client.read.event;

import client.read.event.item_id.ItemIDEvent;
import client.read.event.single_user.SingleUserEvent;
import client.read.event.two_users.TwoUsersEvent;

public abstract class Event implements EventValues {
    private final String component;
    private final String eventName;

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        Event event = ItemIDEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = SingleUserEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        return TwoUsersEvent.fromData(component, eventName, description);
    }

    public Event(String component, String eventName) {
        this.component = component;
        this.eventName = eventName;
    }

    @Override
    public final String valueForComponent() {
        return component;
    }

    @Override
    public final String valueForEventName() {
        return eventName;
    }

    @Override
    public abstract String valueForDescription();

    @Override
    public Integer valueForEventUserID() {
        return null;
    }

    @Override
    public Integer valueForAffectedUserID() {
        return null;
    }

    @Override
    public Integer valueForCourseID() {
        return null;
    }

    @Override
    public Integer valueForCourseModuleID() {
        return null;
    }

    @Override
    public Integer valueForDiscussionID() {
        return null;
    }

    @Override
    public Integer valueForRoleID() {
        return null;
    }

    @Override
    public Integer valueForItemID() {
        return null;
    }

    @Override
    public Integer valueForEnrolmentID() {
        return null;
    }

    @Override
    public Integer valueForEventID() {
        return null;
    }

    @Override
    public Integer valueForPostID() {
        return null;
    }

    @Override
    public Integer valueForSectionNumber() {
        return null;
    }

    @Override
    public String valueForActivity() {
        return null;
    }

    @Override
    public String valueForEnrolmentMethod() {
        return null;
    }

    @Override
    public String valueForEvent() {
        return null;
    }

    @Override
    public String valueForViewingMode() {
        return null;
    }

    @Override
    public String valueForModule() {
        return null;
    }
}