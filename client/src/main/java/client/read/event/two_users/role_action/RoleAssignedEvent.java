package client.read.event.two_users.role_action;

import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class RoleAssignedEvent extends RoleActionEvent {
    private static final String action = "assigned";
    private static final String preposition = "to";
    private static final Pattern pattern = RoleActionEvent.roleActionEventPattern(action, preposition);
    
    public static final String eventNameValue = RoleActionEvent.roleActionEventName(action);

    public static RoleAssignedEvent fromDescription(String description) throws DescriptionMatchFailException {
        RoleActionEvent.DescriptionData data = RoleActionEvent.fromDescription(pattern, description);
        return new RoleAssignedEvent(data.eventUserID, data.roleID, data.affectedUserID);
    }

    public RoleAssignedEvent(int eventUserID, int roleID, int affectedUserID) {
        super(eventNameValue, eventUserID, roleID, affectedUserID);
    }

    @Override
    public final String valueForDescription() {
        return super.valueForRoleActionDescription(action, preposition);
    }
}