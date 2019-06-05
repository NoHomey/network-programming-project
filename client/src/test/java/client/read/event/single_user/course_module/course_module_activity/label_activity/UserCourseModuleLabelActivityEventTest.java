package client.read.event.single_user.course_module.course_module_activity.label_activity;

import client.read.event.Event;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModuleLabelActivityEventTest {
    @Test
    public void testFromDataForUserCourseModuleLabelCreatedEvent() {
        try {
            Event event = UserCourseModuleLabelActivityEvent.fromData("System", "Course module created", "The user with id '2' created the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelDeletedEvent() {
        try {
            Event event = UserCourseModuleLabelActivityEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelUpdatedEvent() {
        try {
            Event event = UserCourseModuleLabelActivityEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelViewedEvent() {
        try {
            Event event = UserCourseModuleLabelActivityEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModuleLabelActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModuleLabelActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleLabelActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModuleLabelActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleLabelActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleLabelActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}