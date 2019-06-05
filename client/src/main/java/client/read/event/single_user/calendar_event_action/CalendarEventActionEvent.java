package client.read.event.single_user.calendar_event_action;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.SingleUserEvent;

public abstract class CalendarEventActionEvent extends SingleUserEvent {
    protected static class DescriptionData extends SingleUserEvent.DescriptionData {;
        public final String event;
        public final int eventID;

        public DescriptionData(int userID, String event, int eventID) {
            super(userID);
            this.event = event;
            this.eventID = eventID;
        }
    }

    public static final String componentValue = "System";

    protected static String calendarEventEventName(String action) {
        return "Calendar event " + action;
    }

    protected static Pattern calendarEventActionPattern(String action) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action + " the event '((?:\\p{L}+\\s?)+)' with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final String event = matcher.group(2);
            final int eventID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(userID, event, eventID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(CalendarEventCreatedEvent.eventNameValue.equals(eventName)) {
                return CalendarEventCreatedEvent.fromDescription(description);
            }
            if(CalendarEventDeletedEvent.eventNameValue.equals(eventName)) {
                return CalendarEventDeletedEvent.fromDescription(description);
            }
            if(CalendarEventUpdatedEvent.eventNameValue.equals(eventName)) {
                return CalendarEventUpdatedEvent.fromDescription(description);
            }
            if(CalendarEventViewedEvent.eventNameValue.equals(eventName)) {
                return CalendarEventViewedEvent.fromDescription(description);
            }
        }
        return null;
    }

    protected final String event;
    protected final int eventID;

    public CalendarEventActionEvent(String eventName, int userID, String event, int eventID) {
        super(componentValue, eventName, userID);
        this.event = event;
        this.eventID = eventID;
    }

    protected final String valueForCalendarEventActionDescription(String action) {
        return "The user with id '" + userID + "' " + action + " the event '" + event + "' with id '" + eventID  + "'.";
    }

    @Override
    public final Integer valueForEventID() {
        return eventID;
    }

    @Override
    public final String valueForEvent() {
        return event;
    }
}