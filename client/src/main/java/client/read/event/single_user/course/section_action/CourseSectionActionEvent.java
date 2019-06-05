package client.read.event.single_user.course.section_action;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course.SingleUserCourseEvent;

public abstract class CourseSectionActionEvent extends SingleUserCourseEvent {
    protected static class DescriptionData extends SingleUserCourseEvent.DescriptionData {
        public final int sectionNumber;

        public DescriptionData(int userID, int sectionNumber, int courseID) {
            super(userID, courseID);
            this.sectionNumber = sectionNumber;
        }
    }
    
    public static final String componentValue = "System";

    protected static String courseSectionEventName(String action) {
        return "Course section " + action;
    }

    protected static Pattern courseSectionActionPattern(String action) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action + " section number '(0|[123456789]\\d*)' for the course with id '(0|[123456789]\\d*)'\\z");
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()){
            final int userID = Integer.parseInt(matcher.group(1));
            final int sectionNumber = Integer.parseInt(matcher.group(2));
            final int courseID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(userID, sectionNumber, courseID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(CourseSectionCreatedEvent.eventNameValue.equals(eventName)) {
                return CourseSectionCreatedEvent.fromDescription(description);
            }
            if(CourseSectionDeletedEvent.eventNameValue.equals(eventName)) {
                return CourseSectionDeletedEvent.fromDescription(description);
            }
            if(CourseSectionUpdatedEvent.eventNameValue.equals(eventName)) {
                return CourseSectionUpdatedEvent.fromDescription(description);
            }
        }
        return null;
    }

    protected final int sectionNumber;

    public CourseSectionActionEvent(String eventName, int userID, int sectionNumber, int courseID) {
        super(componentValue, eventName, userID, courseID);
        this.sectionNumber = sectionNumber;
    }

    protected final String valueForCourseSectionActionDescription(String action) {
        return "The user with id '" + userID + "' " + action + " section number '" + sectionNumber + "' for the course with id '" + courseID + "'";
    }

    @Override
    public final Integer valueForSectionNumber() {
        return sectionNumber;
    }
}