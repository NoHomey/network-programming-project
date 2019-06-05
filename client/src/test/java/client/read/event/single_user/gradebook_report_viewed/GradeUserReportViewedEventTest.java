package client.read.event.single_user.gradebook_report_viewed;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;

public class GradeUserReportViewedEventTest {
    GradeUserReportViewedEvent event;

    @Before
    public void initialize() {
        event = new GradeUserReportViewedEvent(7149);
    }

    @Test
    public void testFromDescription() {
        try {
            GradeUserReportViewedEvent event = GradeUserReportViewedEvent.fromDescription("The user with id '7149' viewed the user report in the gradebook.");
            assertEquals("The user with id '7149' viewed the user report in the gradebook.", event.valueForDescription());
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testValueForComponent() {
        assertEquals("User report", event.valueForComponent());
    }

    @Test
    public void testValueForEventName() {
        assertEquals("Grade user report viewed", event.valueForEventName());
    }

    @Test
    public void testValueForDescription() {
        assertEquals("The user with id '7149' viewed the user report in the gradebook.", event.valueForDescription());
    }

    @Test
    public void testValueForEventUserID() {
        assertEquals(Integer.valueOf(7149), event.valueForEventUserID());
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
