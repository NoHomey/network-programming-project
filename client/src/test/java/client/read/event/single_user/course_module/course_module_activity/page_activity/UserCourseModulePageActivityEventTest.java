package client.read.event.single_user.course_module.course_module_activity.page_activity;

import client.read.event.Event;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModulePageActivityEventTest {
    @Test
    public void testFromDataForUserCourseModulePageCreatedEvent() {
        try {
            Event event = UserCourseModulePageActivityEvent.fromData("Page", "Course module created", "The user with id '2' created the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageDeletedEvent() {
        try {
            Event event = UserCourseModulePageActivityEvent.fromData("Page", "Course module deleted", "The user with id '2' deleted the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageUpdatedEvent() {
        try {
            Event event = UserCourseModulePageActivityEvent.fromData("Page", "Course module updated", "The user with id '2' updated the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageViewedEvent() {
        try {
            Event event = UserCourseModulePageActivityEvent.fromData("Page", "Course module viewed", "The user with id '2' viewed the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModulePageActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModulePageActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModulePageActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModulePageActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModulePageActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModulePageActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}