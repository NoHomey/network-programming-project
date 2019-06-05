package client.read.event.single_user.course_module.discussion;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class SomeContentHasBeenPostedEventTest {
    SomeContentHasBeenPostedEvent event;

    @Before
    public void initialize() {
        event = new SomeContentHasBeenPostedEvent(2436, 250, 209, 81);
    }

    @Test
    public void testFromDescription() {
        try {
            SomeContentHasBeenPostedEvent event = SomeContentHasBeenPostedEvent.fromDescription("The user with id '2436' has posted content in the forum post with id '250' in the discussion '209' located in the forum with course module id '81'.");
            assertEquals("The user with id '2436' has posted content in the forum post with id '250' in the discussion '209' located in the forum with course module id '81'.", event.valueForDescription());
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
        assertEquals("Some content has been posted.", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '2436' has posted content in the forum post with id '250' in the discussion '209' located in the forum with course module id '81'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(2436), event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertNull(event.valueForAffectedUserID());
    }

    @Test
    public void testValueForCourseID() {
        assertNull(event.valueForCourseID());
    }

    @Test
    public void testValueForCourseModuleID() {
        assertEquals(Integer.valueOf(81), event.valueForCourseModuleID());
    }

    @Test
    public void testValueForDiscussionID() {
        assertEquals(Integer.valueOf(209), event.valueForDiscussionID());
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
        assertEquals(Integer.valueOf(250), event.valueForPostID());
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
        assertNull(event.valueForModule());
    }
}
