package client.read.event.single_user.course.section_action;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class CourseSectionUpdatedEventTest {
    CourseSectionUpdatedEvent event;

    @Before
    public void initialize() {
        event = new CourseSectionUpdatedEvent(2, 0, 49);
    }

    @Test
    public void testFromDescription() {
        try {
            CourseSectionUpdatedEvent event = CourseSectionUpdatedEvent.fromDescription("The user with id '2' updated section number '0' for the course with id '49'");
            assertEquals("The user with id '2' updated section number '0' for the course with id '49'", event.valueForDescription());
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
        assertEquals("Course section updated", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '2' updated section number '0' for the course with id '49'", event.valueForDescription());
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
        assertEquals(Integer.valueOf(49), event.valueForCourseID());
    }

    @Test
    public void testValueForCourseModuleID() {
        assertNull(event.valueForCourseModuleID());
    }

    @Test
    public void testValueForDescriptionID() {
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
        assertEquals(Integer.valueOf(0), event.valueForSectionNumber());
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
