package client.read;

import client.read.date_time.DateTime;
import client.read.date_time.DateTimeValues;
import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.EventValues;
import client.read.event_context.EventContext;
import client.read.event_context.EventContextValues;
import client.read.event_context.EventContext.EventContextParseException;

public class EventData implements DateTimeValues, EventContextValues, EventValues {
    private final DateTime dateTime;
    private final EventContext eventContext;
    private final Event event;
    private final String origin;
    private final String ipAddress;

    public static EventData fromData(String dateTimeText, String eventContextText, String component, String eventName, String description, String origin, String ip)
                                    throws DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        final DateTime dateTime = new DateTime(DateTime.fromText(dateTimeText));
        final EventContext eventContext = EventContext.fromContext(eventContextText);
        final Event event = Event.fromData(component, eventName, description);
        return new EventData(dateTime, eventContext, event, origin, ip);
    }

    public EventData(DateTime dateTime, EventContext eventContext, Event event, String origin, String ipAddress) {
        this.dateTime = dateTime;
        this.eventContext = eventContext;
        this.event = event;
        this.origin = origin;
        this.ipAddress = ipAddress;
    }

    @Override
    public int valueForDay() {
        return dateTime.valueForDay();
    }

    @Override
    public int valueForMonth() {
        return dateTime.valueForMonth();
    }

    @Override
    public int valueForYear() {
        return dateTime.valueForYear();
    }

    @Override
    public int valueForHour() {
        return dateTime.valueForHour();
    }

    @Override
    public int valueForMinutes() {
        return dateTime.valueForMinutes();
    }

    @Override
    public String valueForDate() {
        return dateTime.valueForDate();
    }

    @Override
    public String valueForTime() {
        return dateTime.valueForTime();
    }

    @Override
    public String valueForDateTime() {
        return dateTime.valueForDateTime();
    }

    @Override
    public String valueForEventContext() {
        return eventContext.valueForEventContext();
    }

    @Override
    public String valueForEventContextKind() {
        return eventContext.valueForEventContextKind();
    }

    @Override
    public String valueForResourceName() {
        return eventContext.valueForResourceName();
    }

    @Override
    public String valueForComponent() {
        return event.valueForComponent();
    }

    @Override
    public String valueForEventName() {
        return event.valueForEventName();
    }

    @Override
    public String valueForDescription() {
        return event.valueForDescription();
    }

    @Override
    public Integer valueForEventUserID() {
        return event.valueForEventUserID();
    }

    @Override
    public Integer valueForAffectedUserID() {
        return event.valueForAffectedUserID();
    }

    @Override
    public Integer valueForCourseID() {
        return event.valueForCourseID();
    }

    @Override
    public Integer valueForCourseModuleID() {
        return event.valueForCourseModuleID();
    }

    @Override
    public Integer valueForDiscussionID() {
        return event.valueForDiscussionID();
    }

    @Override
    public Integer valueForRoleID() {
        return event.valueForRoleID();
    }

    @Override
    public Integer valueForItemID() {
        return event.valueForItemID();
    }

    @Override
    public Integer valueForEnrolmentID() {
        return event.valueForEnrolmentID();
    }

    @Override
    public Integer valueForEventID() {
        return event.valueForEventID();
    }

    @Override
    public Integer valueForPostID() {
        return event.valueForPostID();
    }

    @Override
    public Integer valueForSectionNumber() {
        return event.valueForSectionNumber();
    }

    @Override
    public String valueForActivity() {
        return event.valueForActivity();
    }

    @Override
    public String valueForEnrolmentMethod() {
        return event.valueForEnrolmentMethod();
    }

    @Override
    public String valueForEvent() {
        return event.valueForEvent();
    }

    @Override
    public String valueForViewingMode() {
        return event.valueForViewingMode();
    }

    @Override
    public String valueForModule() {
        return event.valueForModule();
    }

    public String valueForOrigin() {
        return origin;
    }

    public String valueForIPAddress() {
        return ipAddress;
    }
}