package client.read.event.single_user.gradebook_report_viewed;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class GradebookReportViewedEventTest {
    @Test
    public void testFromDataForGradeOverviewReportViewedEvent() {
        try {
            Event event = GradebookReportViewedEvent.fromData("Overview report", "Grade overview report viewed", "The user with id '6626' viewed the overview report in the gradebook.");
            assertTrue(event instanceof GradeOverviewReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForGraderReportViewedEvent() {
        try {
            Event event = GradebookReportViewedEvent.fromData("Grader report", "Grader report viewed", "The user with id '2436' viewed the grader report in the gradebook.");
            assertTrue(event instanceof GraderReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForGradeUserReportViewedEvent() {
        try {
            Event event = GradebookReportViewedEvent.fromData("User report", "Grade user report viewed", "The user with id '7149' viewed the user report in the gradebook.");
            assertTrue(event instanceof GradeUserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = GradebookReportViewedEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = GradebookReportViewedEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = GradebookReportViewedEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = GradebookReportViewedEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = GradebookReportViewedEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = GradebookReportViewedEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}