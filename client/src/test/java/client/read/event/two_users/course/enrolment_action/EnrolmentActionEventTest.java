package client.read.event.two_users.course.enrolment_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class EnrolmentActionEventTest {
    @Test
    public void testFromDataForUserEnrolledInCourseEvent() {
        try {
            Event event = EnrolmentActionEvent.fromData("System", "User enrolled in course", "The user with id '109' enrolled the user with id '6507' using the enrolment method 'cohort' in the course with id '49'.");
            assertTrue(event instanceof UserEnrolledInCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserUnenrolledFromCourseEventt() {
        try {
            Event event = EnrolmentActionEvent.fromData("System", "User unenrolled from course", "The user with id '109' unenrolled the user with id '6507' using the enrolment method 'cohort' from the course with id '49'.");
            assertTrue(event instanceof UserUnenrolledFromCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = EnrolmentActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = EnrolmentActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = EnrolmentActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}