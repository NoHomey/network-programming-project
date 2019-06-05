package client.read.event.single_user.course.section_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class CourseSectionCreatedEvent extends CourseSectionActionEvent {
    private static final String action = "created";
    private static final Pattern pattern = CourseSectionActionEvent.courseSectionActionPattern(action);
    
    public static final String eventNameValue = CourseSectionActionEvent.courseSectionEventName(action);

    public static CourseSectionCreatedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final CourseSectionActionEvent.DescriptionData data = CourseSectionActionEvent.fromDescription(pattern, description);
        return new CourseSectionCreatedEvent(data.userID, data.sectionNumber, data.courseID); 
    }

    public CourseSectionCreatedEvent(int userID, int sectionNumber, int courseId) {
        super(eventNameValue, userID, sectionNumber, courseId);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForCourseSectionActionDescription(action);
    }
}