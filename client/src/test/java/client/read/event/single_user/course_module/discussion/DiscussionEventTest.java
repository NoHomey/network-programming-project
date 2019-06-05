package client.read.event.single_user.course_module.discussion;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionCreatedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionDeletedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionUpdatedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionViewedEvent;

public class DiscussionEventTest {
    @Test
    public void testFromDataForSomeContentHasBeenPostedEvent() {
        try {
            Event event = DiscussionEvent.fromData("Forum", "Some content has been posted.", "The user with id '2436' has posted content in the forum post with id '250' in the discussion '209' located in the forum with course module id '81'.");
            assertTrue(event instanceof SomeContentHasBeenPostedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionCreatedEvent() {
        try {
            Event event = DiscussionEvent.fromData("Forum", "Discussion created", "The user with id '2436' has created the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionDeletedEvent() {
        try {
            Event event = DiscussionEvent.fromData("Forum", "Discussion deleted", "The user with id '2436' has deleted the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionUpdatedEvent() {
        try {
            Event event = DiscussionEvent.fromData("Forum", "Discussion updated", "The user with id '2436' has updated the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionViewedEvent() {
        try {
            Event event = DiscussionEvent.fromData("Forum", "Discussion viewed", "The user with id '2436' has viewed the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = DiscussionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = DiscussionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = DiscussionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = DiscussionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = DiscussionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = DiscussionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}