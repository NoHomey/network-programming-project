package client.read.event.single_user.course.section_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class CourseSectionActionEventTest {
    @Test
    public void testFromDataForCourseSectionCreatedEvent() {
        try {
            Event event = CourseSectionActionEvent.fromData("System", "Course section created", "The user with id '2' created section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionDeletedEvent() {
        try {
            Event event = CourseSectionActionEvent.fromData("System", "Course section deleted", "The user with id '2' deleted section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForCourseSectionUpdatedEvent() {
        try {
            Event event = CourseSectionActionEvent.fromData("System", "Course section updated", "The user with id '2' updated section number '0' for the course with id '49'");
            assertTrue(event instanceof CourseSectionUpdatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = CourseSectionActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = CourseSectionActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = CourseSectionActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = CourseSectionActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = CourseSectionActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = CourseSectionActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}