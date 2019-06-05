package client.read.event.single_user.course.course_only.forum;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class ForumInstanceListViewedEventTest {
    ForumInstanceListViewedEvent event;

    @Before
    public void initialize() {
        event = new ForumInstanceListViewedEvent(4773, 49);
    }

    @Test
    public void testFromDescription() {
        try {
            ForumInstanceListViewedEvent event = ForumInstanceListViewedEvent.fromDescription("The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.");
            assertEquals("The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("Forum", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("Course module instance list viewed", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(4773), event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertNull(event.valueForAffectedUserID());
    }

    @Test
    public void testValueForCourseID() {
        assertEquals(Integer.valueOf(49), event.valueForCourseID());
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
        assertNull(event.valueForRoleID());
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
        assertEquals("forum", event.valueForModule());
    }
}