package client.read.event.single_user.course_module.course_module_activity;

import client.read.event.Event;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemViewedEvent;
import client.read.event.DescriptionMatchFailException;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCourseModuleActivityEventTest {
    @Test
    public void testFromDataForUserCourseModuleFileCreatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("File", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileDeletedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("File", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileUpdatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("File", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileViewedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("File", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumCreatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Forum", "Course module created", "The user with id '2' created the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumDeletedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Forum", "Course module deleted", "The user with id '2' deleted the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumUpdatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Forum", "Course module updated", "The user with id '2' updated the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumViewedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Forum", "Course module viewed", "The user with id '2' viewed the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelCreatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module created", "The user with id '2' created the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelDeletedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelUpdatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelViewedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageCreatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Page", "Course module created", "The user with id '2' created the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageDeletedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Page", "Course module deleted", "The user with id '2' deleted the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageUpdatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Page", "Course module updated", "The user with id '2' updated the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageViewedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("Page", "Course module viewed", "The user with id '2' viewed the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemCreatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemDeletedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemUpdatedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemViewedEvent() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserCourseModuleActivityEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserCourseModuleActivityEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleActivityEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserCourseModuleActivityEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleActivityEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserCourseModuleActivityEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}