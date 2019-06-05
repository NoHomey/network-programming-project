package client.read.event.single_user.calendar_event_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CalendarEventViewedEvent extends CalendarEventActionEvent {
    private static final String action = "viewed";
    private static final Pattern pattern = CalendarEventActionEvent.calendarEventActionPattern(action);
    
    public static final String eventNameValue = CalendarEventActionEvent.calendarEventEventName(action);

    public static CalendarEventViewedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final CalendarEventActionEvent.DescriptionData data = CalendarEventActionEvent.fromDescription(pattern, description);
        return new CalendarEventViewedEvent(data.userID, data.event, data.eventID);
    }

    public CalendarEventViewedEvent(int userID, String event, int eventID) {
        super(eventNameValue, userID, event, eventID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForCalendarEventActionDescription(action);
    }
}