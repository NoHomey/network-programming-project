package client.read.event.single_user.course;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.course_only.forum.CourseForumSearchedEvent;
import client.read.event.single_user.course.course_only.forum.ForumInstanceListViewedEvent;
import client.read.event.single_user.course.course_only.system.CourseUserListViewedEvent;
import client.read.event.single_user.course.course_only.system.CourseViewedEvent;
import client.read.event.single_user.course.course_only.user_viewed_course_report.ActivityReportViewedEvent;
import client.read.event.single_user.course.course_only.user_viewed_course_report.LiveLogReportViewedEvent;
import client.read.event.single_user.course.course_only.user_viewed_course_report.LogReportViewedEvent;
import client.read.event.single_user.course.course_only.user_viewed_course_report.RecentActivityReportViewedEvent;
import client.read.event.single_user.course.section_action.CourseSectionCreatedEvent;
import client.read.event.single_user.course.section_action.CourseSectionDeletedEvent;
import client.read.event.single_user.course.section_action.CourseSectionUpdatedEvent;

public class SingleUserCourseEventTest {
    @Test
    public void testFromDataForCourseForumSearchedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("Forum", "Course searched", "The user with id '6629' has searched the course with id '49' for forum posts containing \"\".");
            assertTrue(event instanceof CourseForumSearchedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForForumInstanceListViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("Forum", "Course module instance list viewed", "The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.");
            assertTrue(event instanceof ForumInstanceListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseUserListViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "User list viewed", "The user with id '7183' viewed the list of users in the course with id '49'.");
            assertTrue(event instanceof CourseUserListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "Course viewed", "The user with id '2' viewed the course with id '49'.");
            assertTrue(event instanceof CourseViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForActivityReportViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("Activity report", "Activity report viewed", "The user with id '2' viewed the outline activity report for the course with id '49'.");
            assertTrue(event instanceof ActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLiveLogReportViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("Live logs", "Live log report viewed", "The user with id '2' viewed the live log report for the course with id '49'.");
            assertTrue(event instanceof LiveLogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLogReportViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("Logs", "Log report viewed", "The user with id '2' viewed the log report for the course with id '49'.");
            assertTrue(event instanceof LogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRecentActivityReportViewedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "Recent activity viewed", "The user with id '7135' viewed the recent activity report in the course with id '49'.");
            assertTrue(event instanceof RecentActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionCreatedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "Course section created", "The user with id '2' created section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionDeletedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "Course section deleted", "The user with id '2' deleted section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionUpdatedEvent() {
        try {
            Event event = SingleUserCourseEvent.fromData("System", "Course section updated", "The user with id '2' updated section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = SingleUserCourseEvent.fromData("Forum", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertNull(event);
            event = SingleUserCourseEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = SingleUserCourseEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserCourseEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}