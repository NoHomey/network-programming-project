package client.read.event.single_user.course_module.course_module_activity.file_activity;

import client.read.event.Event;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModuleFileActivityEventTest {
    @Test
    public void testFromDataForUserCourseModuleFileCreatedEvent() {
        try {
            Event event = UserCourseModuleFileActivityEvent.fromData("File", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileDeletedEvent() {
        try {
            Event event = UserCourseModuleFileActivityEvent.fromData("File", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileUpdatedEvent() {
        try {
            Event event = UserCourseModuleFileActivityEvent.fromData("File", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileViewedEvent() {
        try {
            Event event = UserCourseModuleFileActivityEvent.fromData("File", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModuleFileActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModuleFileActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleFileActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModuleFileActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleFileActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleFileActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}