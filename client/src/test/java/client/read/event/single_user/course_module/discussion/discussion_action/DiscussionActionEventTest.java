package client.read.event.single_user.course_module.discussion.discussion_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class DiscussionActionEventTest {
    @Test
    public void testFromDataForDiscussionCreatedEvent() {
        try {
            Event event = DiscussionActionEvent.fromData("Forum", "Discussion created", "The user with id '2436' has created the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionDeletedEvent() {
        try {
            Event event = DiscussionActionEvent.fromData("Forum", "Discussion deleted", "The user with id '2436' has deleted the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionUpdatedEvent() {
        try {
            Event event = DiscussionActionEvent.fromData("Forum", "Discussion updated", "The user with id '2436' has updated the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionViewedEvent() {
        try {
            Event event = DiscussionActionEvent.fromData("Forum", "Discussion viewed", "The user with id '2436' has viewed the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = DiscussionActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = DiscussionActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = DiscussionActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = DiscussionActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = DiscussionActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = DiscussionActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}