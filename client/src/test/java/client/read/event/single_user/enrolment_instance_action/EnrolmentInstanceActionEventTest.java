package client.read.event.single_user.enrolment_instance_action;

import org.junit.Test;
import static org.junit.Assert.*;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public class EnrolmentInstanceActionEventTest {
    @Test
    public void testFromDataForEnrolmentInstanceCreatedEvent() {
        try {
            Event event = EnrolmentInstanceActionEvent.fromData("System", "Enrolment instance created", "The user with id '2' created the instance of enrolment method 'cohort' with id '1201'.");
            assertTrue(event instanceof EnrolmentInstanceCreatedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataForEnrolmentInstanceDeletedEvent() {
        try {
            Event event = EnrolmentInstanceActionEvent.fromData("System", "Grouping deleted", "The user with id '2' deleted the instance of enrolment method 'cohort' with id '1201'.");
            assertTrue(event instanceof EnrolmentInstanceDeletedEvent);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFromDataReturnsNull() {
        try {
            Event event = EnrolmentInstanceActionEvent.fromData("System", "Course viewed", "The user with id '4411' viewed the course with id '49'.");
            assertNull(event);
            event = EnrolmentInstanceActionEvent.fromData("Recycle bin", "Item created", "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentInstanceActionEvent.fromData("Recycle bin", "Item created", null);
            assertNull(event);
            event = EnrolmentInstanceActionEvent.fromData("Recycle bin", null, "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentInstanceActionEvent.fromData(null, "Item created", "Item created with ID 13.");
            assertNull(event);
            event = EnrolmentInstanceActionEvent.fromData(null, null, null);
            assertNull(event);
        } catch(DescriptionMatchFailException e) {
            fail(e.getMessage());
        }
    }
}