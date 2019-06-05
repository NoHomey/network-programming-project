package client.read.event.item_id;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class ItemIDEventTest {
    @Test
    public void testFromDataForItemCreatedEvent() {
        try {
            Event event = ItemIDEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertTrue(event instanceof ItemCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForItemDeleteEvent() {
        try {
            Event event = ItemIDEvent.fromData("Recycle bin", "Item deleted", "Item with ID 13 deleted.");
            assertTrue(event instanceof ItemDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = ItemIDEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = ItemIDEvent.fromData("System", "Role unassigned", "The user with id '109' unassigned the role with id '5' from the user with id '4238'.");
            assertNull(event);
            event = ItemIDEvent.fromData("System", "Role unassigned", null);
            assertNull(event);
            event = ItemIDEvent.fromData("System", null, "The user with id '109' unassigned the role with id '5' from the user with id '4238'.");
            assertNull(event);
            event = ItemIDEvent.fromData(null, "Role unassigned", "The user with id '109' unassigned the role with id '5' from the user with id '4238'.");
            assertNull(event);
            event = ItemIDEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}