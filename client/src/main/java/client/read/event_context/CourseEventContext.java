package client.read.event_context;

public final class CourseEventContext extends EventContextWithResourceName {
    public static final String kindValue = "Course";

    public CourseEventContext(String courseName) {
        super(kindValue, courseName);
    }
}