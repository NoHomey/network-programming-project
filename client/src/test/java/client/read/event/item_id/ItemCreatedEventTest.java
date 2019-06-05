package client.read.event.item_id;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class ItemCreatedEventTest {
    ItemCreatedEvent event;

    @Before
    public void initialize() {
        event = new ItemCreatedEvent(13);
    }

    @Test
    public void testFromDescription() {
        try {
            ItemCreatedEvent event = ItemCreatedEvent.fromDescription("Item created with ID 13.");
            assertEquals("Item created with ID 13.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("Recycle bin", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("Item created", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("Item created with ID 13.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertNull(event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertNull(event.valueForAffectedUserID());
    }

    @Test
    public void testValueForCourseID() {
        assertNull(event.valueForCourseID());
    }

    @Test
    public void testValueForCourseModuleID() {
        assertNull(event.valueForCourseModuleID());
    }

    @Test
    public void testValueForDiscussionID() {
        assertNull(event.valueForDiscussionID());
    }

    @Test
    public void testValueForRoleID() {
        assertNull(event.valueForRoleID());
    }

    @Test
    public void testValueForItemID() {
        assertEquals(Integer.valueOf(13), event.valueForItemID());
    }

    @Test
    public void testValueForEnrolmentID() {
        assertNull(event.valueForEnrolmentID());
    }

    @Test
    public void testValueForEventID() {
        assertNull(event.valueForEventID());
    }

    @Test
    public void testValueForPostID() {
        assertNull(event.valueForPostID());
    }

    @Test
    public void testValueForSectionNumber() {
        assertNull(event.valueForSectionNumber());
    }

    @Test
    public void testValueForActivity() {
        assertNull(event.valueForActivity());
    }

    @Test
    public void testValueForEnrolmentMethod() {
        assertNull(event.valueForEnrolmentMethod());
    }

    @Test
    public void testValueForEvent() {
        assertNull(event.valueForEvent());
    }

    @Test
    public void testValueForViewingMode() {
        assertNull(event.valueForViewingMode());
    }

    @Test
    public void testValueForModule()  {
        assertNull(event.valueForModule());
    }
}
