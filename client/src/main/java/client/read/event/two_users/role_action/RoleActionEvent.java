package client.read.event.two_users.role_action;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;
import client.read.event.two_users.TwoUsersEvent;

public abstract  class RoleActionEvent extends TwoUsersEvent {
    protected static class DescriptionData extends TwoUsersEvent.DescriptionData {
        public final int roleID;

        public DescriptionData(int eventUserID, int roleID, int affectedUserID) {
            super(eventUserID, affectedUserID);
            this.roleID = roleID;
        }
    }

    protected static String roleActionEventName(String action) {
        return "Role " + action;
    }

    protected static Pattern roleActionEventPattern(String action, String preposition) {
        return Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' " + action +  " the role with id '(0|[123456789]\\d*)' " + preposition + " the user with id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    }

    protected static DescriptionData fromDescription(Pattern pattern, String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int eventUserID = Integer.parseInt(matcher.group(1));
            final int roleID = Integer.parseInt(matcher.group(2));
            final int affectedUserID = Integer.parseInt(matcher.group(3));
            return new DescriptionData(eventUserID, roleID, affectedUserID);
        } else throw new DescriptionMatchFailException(description);
    }

    public static final String componentValue = "System";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(RoleAssignedEvent.eventNameValue.equals(eventName)) {
                return RoleAssignedEvent.fromDescription(description);
            }
            if(RoleUnassignedEvent.eventNameValue.equals(eventName)) {
                return RoleUnassignedEvent.fromDescription(description);
            }
        }
        return null;
    }

    protected final int roleID;

    public RoleActionEvent(String eventName, int eventUserID, int roleID, int affectedUserID) {
        super(componentValue, eventName, eventUserID, affectedUserID);
        this.roleID = roleID;
    }

    protected final String valueForRoleActionDescription(String action, String preposition) {
        return "The user with id '" + eventUserID + "' " + action + " the role with id '" + roleID + "' " + preposition + " the user with id '" + affectedUserID  + "'.";
    }

    @Override
    public final Integer valueForRoleID() {
        return roleID;
    }
}