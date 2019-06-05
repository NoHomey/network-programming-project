package client.read.event.single_user.course_module.course_module_activity.page_activity;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class UserCourseModulePageUpdatedEventTest {
    UserCourseModulePageUpdatedEvent event;

    @Before
    public void initialize() {
        event = new UserCourseModulePageUpdatedEvent(2, 4369);
    }

    @Test
    public void testFromDescription() {
        try {
            UserCourseModulePageUpdatedEvent event = UserCourseModulePageUpdatedEvent.fromDescription("The user with id '2' updated the 'page' activity with course module id '4369'.");
            assertEquals("The user with id '2' updated the 'page' activity with course module id '4369'.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("Page", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("Course module updated", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '2' updated the 'page' activity with course module id '4369'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(2), event.valueForEventUserID());
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
        assertEquals(Integer.valueOf(4369), event.valueForCourseModuleID());
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
        assertEquals("page", event.valueForActivity());
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
