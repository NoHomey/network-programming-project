package client.read.event.two_users.course;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.course.enrolment_action.UserEnrolledInCourseEvent;
import client.read.event.two_users.course.enrolment_action.UserUnenrolledFromCourseEvent;

public class TwoUsersCourseEventTest {
    @Test
    public void testFromDataForCourseUserReportViewedEvent() {
        try {
            Event event = TwoUsersCourseEvent.fromData("System", "Course user report viewed", "The user with id '6729' viewed the user report for the course with id '49' for user with id '6729'.");
            assertTrue(event instanceof CourseUserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserProfileViewedEvent() {
        try {
            Event event = TwoUsersCourseEvent.fromData("System", "User profile viewed", "The user with id '7224' viewed the profile for the user with id '2436' in the course with id '49'.");
            assertTrue(event instanceof UserProfileViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserReportViewedEvent() {
        try {
            Event event = TwoUsersCourseEvent.fromData("Forum", "User report viewed", "The user with id '4773' has viewed the user report for the user with id '4734' in the course with id '49' with viewing mode 'discussions'.");
            assertTrue(event instanceof UserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserEnrolledInCourseEvent() {
        try {
            Event event = TwoUsersCourseEvent.fromData("System", "User enrolled in course", "The user with id '109' enrolled the user with id '6507' using the enrolment method 'cohort' in the course with id '49'.");
            assertTrue(event instanceof UserEnrolledInCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserUnenrolledFromCourseEvent() {
        try {
            Event event = TwoUsersCourseEvent.fromData("System", "User unenrolled from course", "The user with id '109' unenrolled the user with id '6507' using the enrolment method 'cohort' from the course with id '49'.");
            assertTrue(event instanceof UserUnenrolledFromCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = TwoUsersCourseEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = TwoUsersCourseEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersCourseEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = TwoUsersCourseEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersCourseEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersCourseEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}