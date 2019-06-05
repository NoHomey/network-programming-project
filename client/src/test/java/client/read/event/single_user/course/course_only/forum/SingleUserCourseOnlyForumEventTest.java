package client.read.event.single_user.course.course_only.forum;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class SingleUserCourseOnlyForumEventTest {
    @Test
    public void testFromDataForCourseForumSearchedEvent() {
        try {
            Event event = SingleUserCourseOnlyForumEvent.fromData("Forum", "Course searched", "The user with id '6629' has searched the course with id '49' for forum posts containing \"\".");
            assertTrue(event instanceof CourseForumSearchedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForForumInstanceListViewedEvent() {
        try {
            Event event = SingleUserCourseOnlyForumEvent.fromData("Forum", "Course module instance list viewed", "The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.");
            assertTrue(event instanceof ForumInstanceListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = SingleUserCourseOnlyForumEvent.fromData("Forum", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertNull(event);
            event = SingleUserCourseOnlyForumEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlyForumEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = SingleUserCourseOnlyForumEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlyForumEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseOnlyForumEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}