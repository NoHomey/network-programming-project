package client.read.event.single_user.course_module.course_module_activity.forum_activity;

import client.read.event.Event;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModuleForumActivityEventTest {
    @Test
    public void testFromDataForUserCourseModuleForumCreatedEvent() {
        try {
            Event event = UserCourseModuleForumActivityEvent.fromData("Forum", "Course module created", "The user with id '2' created the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumDeletedEvent() {
        try {
            Event event = UserCourseModuleForumActivityEvent.fromData("Forum", "Course module deleted", "The user with id '2' deleted the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumUpdatedEvent() {
        try {
            Event event = UserCourseModuleForumActivityEvent.fromData("Forum", "Course module updated", "The user with id '2' updated the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumViewedEvent() {
        try {
            Event event = UserCourseModuleForumActivityEvent.fromData("Forum", "Course module viewed", "The user with id '2' viewed the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModuleForumActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModuleForumActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleForumActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModuleForumActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleForumActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleForumActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}