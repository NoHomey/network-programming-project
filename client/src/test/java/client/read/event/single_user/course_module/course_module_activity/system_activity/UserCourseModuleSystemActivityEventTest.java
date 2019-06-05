package client.read.event.single_user.course_module.course_module_activity.system_activity;

import client.read.event.Event;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModuleSystemActivityEventTest {
    @Test
    public void testFromDataForUserCourseModuleSystemCreatedEvent() {
        try {
            Event event = UserCourseModuleSystemActivityEvent.fromData("System", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemDeletedEvent() {
        try {
            Event event = UserCourseModuleSystemActivityEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemUpdatedEvent() {
        try {
            Event event = UserCourseModuleSystemActivityEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemViewedEvent() {
        try {
            Event event = UserCourseModuleSystemActivityEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModuleSystemActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModuleSystemActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleSystemActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModuleSystemActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleSystemActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleSystemActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}