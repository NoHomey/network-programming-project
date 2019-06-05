package client.read.event.single_user.course.course_only.system;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class SingleUserCourseOnlySystemEventTest {
    @Test
    public void testFromDataForCourseUserListViewedEvent() {
        try {
            Event event = SingleUserCourseOnlySystemEvent.fromData("System", "User list viewed", "The user with id '7183' viewed the list of users in the course with id '49'.");
            assertTrue(event instanceof CourseUserListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseViewedEvent() {
        try {
            Event event = SingleUserCourseOnlySystemEvent.fromData("System", "Course viewed", "The user with id '2' viewed the course with id '49'.");
            assertTrue(event instanceof CourseViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = SingleUserCourseOnlySystemEvent.fromData("System", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertNull(event);
            event = SingleUserCourseOnlySystemEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlySystemEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = SingleUserCourseOnlySystemEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlySystemEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlySystemEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}