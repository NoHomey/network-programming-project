package client.read.event.two_users;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.course.CourseUserReportViewedEvent;
import client.read.event.two_users.course.UserProfileViewedEvent;
import client.read.event.two_users.course.UserReportViewedEvent;
import client.read.event.two_users.course.enrolment_action.UserEnrolledInCourseEvent;
import client.read.event.two_users.course.enrolment_action.UserUnenrolledFromCourseEvent;
import client.read.event.two_users.role_action.RoleAssignedEvent;
import client.read.event.two_users.role_action.RoleUnassignedEvent;

public class TwoUsersEventTest {
    @Test
    public void testFromDataForCourseUserReportViewedEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "Course user report viewed", "The user with id '6729' viewed the user report for the course with id '49' for user with id '6729'.");
            assertTrue(event instanceof CourseUserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserProfileViewedEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "User profile viewed", "The user with id '7224' viewed the profile for the user with id '2436' in the course with id '49'.");
            assertTrue(event instanceof UserProfileViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserReportViewedEvent() {
        try {
            Event event = TwoUsersEvent.fromData("Forum", "User report viewed", "The user with id '4773' has viewed the user report for the user with id '4734' in the course with id '49' with viewing mode 'discussions'.");
            assertTrue(event instanceof UserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserEnrolledInCourseEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "User enrolled in course", "The user with id '109' enrolled the user with id '6507' using the enrolment method 'cohort' in the course with id '49'.");
            assertTrue(event instanceof UserEnrolledInCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserUnenrolledFromCourseEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "User unenrolled from course", "The user with id '109' unenrolled the user with id '6507' using the enrolment method 'cohort' from the course with id '49'.");
            assertTrue(event instanceof UserUnenrolledFromCourseEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRoleAssignedEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "Role assigned", "The user with id '109' assigned the role with id '5' to the user with id '6507'.");
            assertTrue(event instanceof RoleAssignedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRoleUnassignedEvent() {
        try {
            Event event = TwoUsersEvent.fromData("System", "Role unassigned", "The user with id '109' unassigned the role with id '5' from the user with id '6507'.");
            assertTrue(event instanceof RoleUnassignedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = TwoUsersEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = TwoUsersEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = TwoUsersEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = TwoUsersEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}