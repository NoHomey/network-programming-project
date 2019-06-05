package client.read.event.single_user.course_module.course_module_activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.single_user.course_module.SingleUserCourseModuleEvent;
import client.read.event.single_user.course_module.course_module_activity.file_activity.UserCourseModuleFileActivityEvent;
import client.read.event.single_user.course_module.course_module_activity.forum_activity.UserCourseModuleForumActivityEvent;
import client.read.event.single_user.course_module.course_module_activity.label_activity.UserCourseModuleLabelActivityEvent;
import client.read.event.single_user.course_module.course_module_activity.page_activity.UserCourseModulePageActivityEvent;
import client.read.event.single_user.course_module.course_module_activity.system_activity.UserCourseModuleSystemActivityEvent;

public abstract class UserCourseModuleActivityEvent extends SingleUserCourseModuleEvent {
    protected static String courseModuleEventName(String action) {
        return "Course module " + action;
    }

    protected static Pattern userCourseModuleActivityPattern(String action, String activity) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action + " the '" + activity + "' activity with course module id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final int courseModuleID = Integer.parseInt(matcher.group(2));
            return new DescriptionData(userID, courseModuleID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        Event event = UserCourseModuleFileActivityEvent.fromData(component, eventName, description);
        if(component == null || eventName == null || description == null) {
            return null;
        }
        if(event != null) {
            return event;
        }
        event = UserCourseModulePageActivityEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        event = UserCourseModuleForumActivityEvent.fromData(component, eventName, description);
        if(event != null) {
            return event;
        }
        if(description.contains("'label'")) {
            return UserCourseModuleLabelActivityEvent.fromData(component, eventName, description);
        }
        return UserCourseModuleSystemActivityEvent.fromData(component, eventName, description);
    }

    private final String activity;

    public UserCourseModuleActivityEvent(String component, String eventName, int userID, int courseModuleID, String activity) {
        super(component, eventName, userID, courseModuleID);
        this.activity = activity;
    }

    protected final String valueForUserCourseModuleActivityDescription(String action) {
        return "The user with id '" + userID + "' " + action + " the '" + activity + "' activity with course module id '" + courseModuleID + "'.";
    }

    @Override
    public final String valueForActivity() {
        return activity;
    }
}