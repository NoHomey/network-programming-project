package client.read.event.two_users.role_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class RoleActionEventTest {
    @Test
    public void testFromDataForRoleAssignedEvent() {
        try {
            Event event = RoleActionEvent.fromData("System", "Role assigned", "The user with id '109' assigned the role with id '5' to the user with id '6507'.");
            assertTrue(event instanceof RoleAssignedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRoleUnassignedEvent() {
        try {
            Event event = RoleActionEvent.fromData("System", "Role unassigned", "The user with id '109' unassigned the role with id '5' from the user with id '6507'.");
            assertTrue(event instanceof RoleUnassignedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = RoleActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = RoleActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = RoleActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = RoleActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = RoleActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = RoleActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}