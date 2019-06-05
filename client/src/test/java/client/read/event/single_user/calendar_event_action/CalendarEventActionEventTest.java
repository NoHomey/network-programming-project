package client.read.event.single_user.calendar_event_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class CalendarEventActionEventTest {
    @Test
    public void testFromDataForCalendarEventCreatedEvent() {
        try {
            Event event = CalendarEventActionEvent.fromData("System", "Calendar event created", "The user with id '2436' created the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventDeletedEvent() {
        try {
            Event event = CalendarEventActionEvent.fromData("System", "Calendar event deleted", "The user with id '2436' deleted the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventUpdatedEvent() {
        try {
            Event event = CalendarEventActionEvent.fromData("System", "Calendar event updated", "The user with id '2436' updated the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventViewedEvent() {
        try {
            Event event = CalendarEventActionEvent.fromData("System", "Calendar event viewed", "The user with id '2436' viewed the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = CalendarEventActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = CalendarEventActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = CalendarEventActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = CalendarEventActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = CalendarEventActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = CalendarEventActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}