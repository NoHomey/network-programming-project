package client.read.event.single_user;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.calendar_event_action.CalendarEventCreatedEvent;
import client.read.event.single_user.calendar_event_action.CalendarEventDeletedEvent;
import client.read.event.single_user.calendar_event_action.CalendarEventUpdatedEvent;
import client.read.event.single_user.calendar_event_action.CalendarEventViewedEvent;
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
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageViewedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemCreatedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemDeletedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemUpdatedEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemViewedEvent;
import client.read.event.single_user.course_module.discussion.SomeContentHasBeenPostedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionCreatedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionDeletedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionUpdatedEvent;
import client.read.event.single_user.course_module.discussion.discussion_action.DiscussionViewedEvent;
import client.read.event.single_user.enrolment_instance_action.EnrolmentInstanceCreatedEvent;
import client.read.event.single_user.enrolment_instance_action.EnrolmentInstanceDeletedEvent;
import client.read.event.single_user.gradebook_report_viewed.GradeOverviewReportViewedEvent;
import client.read.event.single_user.gradebook_report_viewed.GradeUserReportViewedEvent;
import client.read.event.single_user.gradebook_report_viewed.GraderReportViewedEvent;

public class SingleUserEventTest {
    @Test
    public void testFromDataForCalendarEventCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Calendar event created", "The user with id '2436' created the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Calendar event deleted", "The user with id '2436' deleted the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Calendar event updated", "The user with id '2436' updated the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCalendarEventViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Calendar event viewed", "The user with id '2436' viewed the event 'Предаване на курсови работи по Програмни езици' with id '1379'.");
            assertTrue(event instanceof CalendarEventViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseForumSearchedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course searched", "The user with id '6629' has searched the course with id '49' for forum posts containing \"\".");
            assertTrue(event instanceof CourseForumSearchedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForForumInstanceListViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course module instance list viewed", "The user with id '4773' viewed the instance list for the module 'forum' in the course with id '49'.");
            assertTrue(event instanceof ForumInstanceListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseUserListViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "User list viewed", "The user with id '7183' viewed the list of users in the course with id '49'.");
            assertTrue(event instanceof CourseUserListViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course viewed", "The user with id '2' viewed the course with id '49'.");
            assertTrue(event instanceof CourseViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForActivityReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Activity report", "Activity report viewed", "The user with id '2' viewed the outline activity report for the course with id '49'.");
            assertTrue(event instanceof ActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLiveLogReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Live logs", "Live log report viewed", "The user with id '2' viewed the live log report for the course with id '49'.");
            assertTrue(event instanceof LiveLogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForLogReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Logs", "Log report viewed", "The user with id '2' viewed the log report for the course with id '49'.");
            assertTrue(event instanceof LogReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForRecentActivityReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Recent activity viewed", "The user with id '7135' viewed the recent activity report in the course with id '49'.");
            assertTrue(event instanceof RecentActivityReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course section created", "The user with id '2' created section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course section deleted", "The user with id '2' deleted section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course section updated", "The user with id '2' updated section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("File", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("File", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("File", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleFileViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("File", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleFileViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course module created", "The user with id '2' created the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course module deleted", "The user with id '2' deleted the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course module updated", "The user with id '2' updated the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleForumViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Course module viewed", "The user with id '2' viewed the 'forum' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleForumViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module created", "The user with id '2' created the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleLabelViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'label' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleLabelViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Page", "Course module created", "The user with id '2' created the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Page", "Course module deleted", "The user with id '2' deleted the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Page", "Course module updated", "The user with id '2' updated the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModulePageViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Page", "Course module viewed", "The user with id '2' viewed the 'page' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModulePageViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module created", "The user with id '2' created the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module deleted", "The user with id '2' deleted the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module updated", "The user with id '2' updated the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForUserCourseModuleSystemViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Course module viewed", "The user with id '2' viewed the 'resource' activity with course module id '4369'.");
            assertTrue(event instanceof UserCourseModuleSystemViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForSomeContentHasBeenPostedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Some content has been posted.", "The user with id '2436' has posted content in the forum post with id '250' in the discussion '209' located in the forum with course module id '81'.");
            assertTrue(event instanceof SomeContentHasBeenPostedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Discussion created", "The user with id '2436' has created the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Discussion deleted", "The user with id '2436' has deleted the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionUpdatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Discussion updated", "The user with id '2436' has updated the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForDiscussionViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Discussion viewed", "The user with id '2436' has viewed the discussion with id '209' in the forum with course module id '81'.");
            assertTrue(event instanceof DiscussionViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForEnrolmentInstanceCreatedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertTrue(event instanceof EnrolmentInstanceCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForEnrolmentInstanceDeletedEvent() {
        try {
            Event event = SingleUserEvent.fromData("System", "Grouping deleted", "The user with id '2' deleted the instance of enrolment method 'cohort' with id '1201'.");
            assertTrue(event instanceof EnrolmentInstanceDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForGradeOverviewReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Overview report", "Grade overview report viewed", "The user with id '6626' viewed the overview report in the gradebook.");
            assertTrue(event instanceof GradeOverviewReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForGraderReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("Grader report", "Grader report viewed", "The user with id '2436' viewed the grader report in the gradebook.");
            assertTrue(event instanceof GraderReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForGradeUserReportViewedEvent() {
        try {
            Event event = SingleUserEvent.fromData("User report", "Grade user report viewed", "The user with id '7149' viewed the user report in the gradebook.");
            assertTrue(event instanceof GradeUserReportViewedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = SingleUserEvent.fromData("Forum", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertNull(event);
            event = SingleUserEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = SingleUserEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = SingleUserEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = SingleUserEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}