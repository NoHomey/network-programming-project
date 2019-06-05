package client.read.event.single_user.course.course_only.user_viewed_course_report;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class UserViewedCourseReportEventTest {
    @Test
    public void testFromDataForActivityReportViewedEvent() {
        try {
            Event event = UserViewedCourseReportEvent.fromData("Activity report", "Activity report viewed", "The user with id '2' viewed the outline activity report for the course with id '49'.");
            assertTrue(event instanceof ActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLiveLogReportViewedEvent() {
        try {
            Event event = UserViewedCourseReportEvent.fromData("Live logs", "Live log report viewed", "The user with id '2' viewed the live log report for the course with id '49'.");
            assertTrue(event instanceof LiveLogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLogReportViewedEvent() {
        try {
            Event event = UserViewedCourseReportEvent.fromData("Logs", "Log report viewed", "The user with id '2' viewed the log report for the course with id '49'.");
            assertTrue(event instanceof LogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRecentActivityReportViewedEvent() {
        try {
            Event event = UserViewedCourseReportEvent.fromData("System", "Recent activity viewed", "The user with id '7135' viewed the recent activity report in the course with id '49'.");
            assertTrue(event instanceof RecentActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = UserViewedCourseReportEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = UserViewedCourseReportEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserViewedCourseReportEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = UserViewedCourseReportEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = UserViewedCourseReportEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = UserViewedCourseReportEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}