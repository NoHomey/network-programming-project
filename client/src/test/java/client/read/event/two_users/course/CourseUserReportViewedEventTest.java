package client.read.event.two_users.course;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class CourseUserReportViewedEventTest {
    CourseUserReportViewedEvent event;

    @Before
    public void initialize() {
        event = new CourseUserReportViewedEvent(6729, 49, 6729);
    }

    @Test
    public void testFromDescription() {
        try {
            CourseUserReportViewedEvent event = CourseUserReportViewedEvent.fromDescription("The user with id '6729' viewed the user report for the course with id '49' for user with id '6729'.");
            assertEquals("The user with id '6729' viewed the user report for the course with id '49' for user with id '6729'.", event.valueForDescription());
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
        assertEquals("Course user report viewed", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '6729' viewed the user report for the course with id '49' for user with id '6729'.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(6729), event.valueForEventUserID());
    }

    @Test
    public void testValueForAffectedUserID() {
        assertEquals(Integer.valueOf(6729), event.valueForAffectedUserID());
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
