package client.read.event.two_users.role_action;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class RoleUnassignedEventTest {
    RoleUnassignedEvent event;

    @Before
    public void initialize() {
        event = new RoleUnassignedEvent(109, 5, 6507);
    }

    @Test
    public void testFromDescription() {
        try {
            RoleUnassignedEvent event = RoleUnassignedEvent.fromDescription("The user with id '109' unassigned the role with id '5' from the user with id '6507'.");
            assertEquals("The user with id '109' unassigned the role with id '5' from the user with id '6507'.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("System", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("Role unassigned", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '109' unassigned the role with id '5' from the user with id '6507'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(109), event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertEquals(Integer.valueOf(6507), event.valueForAffectedUserID());
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
        assertEquals(Integer.valueOf(5), event.valueForRoleID());
    }

    @Test
    public void testValueForItemID() {
        assertNull(event.valueForItemID());
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