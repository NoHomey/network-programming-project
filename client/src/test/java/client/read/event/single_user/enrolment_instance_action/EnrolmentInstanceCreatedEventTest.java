package client.read.event.single_user.enrolment_instance_action;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class EnrolmentInstanceCreatedEventTest {
    EnrolmentInstanceCreatedEvent event;

    @Before
    public void initialize() {
        event = new EnrolmentInstanceCreatedEvent(2, "cohort", 1201);
    }

    @Test
    public void testFromDescription() {
        try {
            EnrolmentInstanceCreatedEvent event = EnrolmentInstanceCreatedEvent.fromDescription("The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertEquals("The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.", event.valueForDescription());
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
        assertEquals("Enrolment instance created", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.", event.valueForDescription());
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
        assertEquals(Integer.valueOf(1201), event.valueForEnrolmentID());
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
        assertEquals("cohort", event.valueForEnrolmentMethod());
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
