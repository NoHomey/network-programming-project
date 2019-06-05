package client.read.event.two_users.course;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class UserProfileViewedEventTest {
    UserProfileViewedEvent event;

    @Before
    public void initialize() {
        event = new UserProfileViewedEvent(7224, 2436, 49);
    }

    @Test
    public void testFromDescription() {
        try {
            UserProfileViewedEvent event = UserProfileViewedEvent.fromDescription("The user with id '7224' viewed the profile for the user with id '2436' in the course with id '49'.");
            assertEquals("The user with id '7224' viewed the profile for the user with id '2436' in the course with id '49'.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("System", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("User profile viewed", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '7224' viewed the profile for the user with id '2436' in the course with id '49'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(7224), event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertEquals(Integer.valueOf(2436), event.valueForAffectedUserID());
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
        assertNull(event.valueForModule());
    }
}
