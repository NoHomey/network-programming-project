package client.consume;

import client.consume.extract.ExtractActivity;
import client.consume.extract.ExtractAffectedUserID;
import client.consume.extract.ExtractComponent;
import client.consume.extract.ExtractCourseID;
import client.consume.extract.ExtractCourseModuleID;
import client.consume.extract.ExtractDate;
import client.consume.extract.ExtractDateTime;
import client.consume.extract.ExtractDay;
import client.consume.extract.ExtractDescription;
import client.consume.extract.ExtractDiscussionID;
import client.consume.extract.ExtractEnrolmentID;
import client.consume.extract.ExtractEnrolmentMethod;
import client.consume.extract.ExtractEvent;
import client.consume.extract.ExtractEventContext;
import client.consume.extract.ExtractEventContextKind;
import client.consume.extract.ExtractEventID;
import client.consume.extract.ExtractEventName;
import client.consume.extract.ExtractEventUserID;
import client.consume.extract.ExtractHour;
import client.consume.extract.ExtractIPAddress;
import client.consume.extract.ExtractItemID;
import client.consume.extract.ExtractMinutes;
import client.consume.extract.ExtractModule;
import client.consume.extract.ExtractMonth;
import client.consume.extract.ExtractOrigin;
import client.consume.extract.ExtractPostID;
import client.consume.extract.ExtractResourceName;
import client.consume.extract.ExtractRoleID;
import client.consume.extract.ExtractSectionNumber;
import client.consume.extract.ExtractTime;
import client.consume.extract.ExtractViewingMode;
import client.consume.extract.ExtractYear;
import client.consume.value_map.ValueStore;
import client.consume.value_map.TypedValueStore;

public enum Column {
    ACTIVITY,
    AFFECTED_USER_ID,
    COMPONENT,
    COURSE_ID,
    COURSE_MODULE_ID,
    DATE,
    DATE_TIME,
    DAY,
    DESCRIPTION,
    DISCUSSION_ID,
    ENROLMENT_ID,
    ENROLMENT_METHOD,
    EVENT,
    EVENT_CONTEXT,
    EVENT_CONTEXT_KIND,
    EVENT_ID,
    EVENT_NAME,
    EVENT_USER_ID,
    IP_ADDRESS,
    HOUR,
    ITEM_ID,
    MINUTES,
    MODULE,
    MONTH,
    ORIGIN,
    POST_ID,
    RESOURCE_NAME,
    ROLE_ID,
    SECTION_NUMBER,
    TIME,
    VIEWING_MODE,
    YEAR;

    private static final String UNKNOWN_ENUM_VALUE_FOR_COLUMN = "Unknown enum value for Column";
    private static final String YEAR_STRING = "Year";
    private static final String VIEWING_MODE_STRING = "Viewing mode";
    private static final String TIME_STRING = "Time";
    private static final String SECTION_NUMBER_STRING = "Section number";
    private static final String ROLE_ID_STRING = "Role ID";
    private static final String RESOURCE_NAME_STRING = "Resource name";
    private static final String POST_ID_STRING = "Post ID";
    private static final String ORIGIN_STRING = "Origin";
    private static final String MONTH_STRING = "Month";
    private static final String MODULE_STRING = "Module";
    private static final String MINUTES_STRING = "Minutes";
    private static final String ITEM_ID_STRING = "Item ID";
    private static final String IP_ADDRESS_STRING = "IP address";
    private static final String HOUR_STRING = "Hour";
    private static final String EVENT_USER_ID_STRING = "Event user ID";
    private static final String EVENT_NAME_STRING = "Event name";
    private static final String EVENT_ID_STRING = "Event ID";
    private static final String EVENT_CONTEXT_KIND_STRING = "Event context kind";
    private static final String EVENT_CONTEXT_STRING = "Event context";
    private static final String EVENT_STRING = "Event";
    private static final String ENROLMENT_METHOD_STRING = "Enrolment method";
    private static final String ENROLMENT_ID_STRING = "Enrolment ID";
    private static final String DISCUSSION_ID_STRING = "Discussion ID";
    private static final String DESCRIPTION_STRING = "Description";
    private static final String DAY_STRING = "Day";
    private static final String DATE_AND_TIME = "Date and Time";
    private static final String DATE_STRING = "Date";
    private static final String COURSE_MODULE_ID_STRING = "Course module ID";
    private static final String COURSE_ID_STRING = "Course ID";
    private static final String AFFECTED_USER_ID_STRING = "Affected user ID";
    private static final String COMPONENT_STRING = "Component";
    private static final String ACTIVITY_STRING = "Activity";

    public static Column[] allColumns() {
        return values();
    }

    public static ValueStore fromColumn(Column column) throws IllegalArgumentException {
        switch (column) {
        case ACTIVITY:
            return activity();
        case AFFECTED_USER_ID:
            return affectedUserID();
        case COMPONENT:
            return component();
        case COURSE_ID:
            return courseID();
        case COURSE_MODULE_ID:
            return courseModuleID();
        case DATE:
            return date();
        case DATE_TIME:
            return dateTime();
        case DAY:
            return day();
        case DESCRIPTION:
            return description();
        case DISCUSSION_ID:
            return discussionID();
        case ENROLMENT_ID:
            return enrolmentID();
        case ENROLMENT_METHOD:
            return enrolmentMethod();
        case EVENT:
            return event();
        case EVENT_CONTEXT:
            return eventContext();
        case EVENT_CONTEXT_KIND:
            return eventContextKind();
        case EVENT_ID:
            return eventID();
        case EVENT_NAME:
            return eventName();
        case EVENT_USER_ID:
            return eventUserID();
        case HOUR:
            return hour();
        case IP_ADDRESS:
            return ipAddress();
        case ITEM_ID:
            return itemID();
        case MINUTES:
            return minutes();
        case MODULE:
            return module();
        case MONTH:
            return month();
        case ORIGIN:
            return origin();
        case POST_ID:
            return postID();
        case RESOURCE_NAME:
            return resourceName();
        case ROLE_ID:
            return roleID();
        case SECTION_NUMBER:
            return sectionNumber();
        case TIME:
            return time();
        case VIEWING_MODE:
            return viewingMode();
        case YEAR:
            return year();
        default:
            throw new IllegalArgumentException(UNKNOWN_ENUM_VALUE_FOR_COLUMN);
        }
    }

    public static String columnName(Column column) throws IllegalArgumentException {
        switch (column) {
        case ACTIVITY:
            return ACTIVITY_STRING;
        case AFFECTED_USER_ID:
            return AFFECTED_USER_ID_STRING;
        case COMPONENT:
            return COMPONENT_STRING;
        case COURSE_ID:
            return COURSE_ID_STRING;
        case COURSE_MODULE_ID:
            return COURSE_MODULE_ID_STRING;
        case DATE:
            return DATE_STRING;
        case DATE_TIME:
            return DATE_AND_TIME;
        case DAY:
            return DAY_STRING;
        case DESCRIPTION:
            return DESCRIPTION_STRING;
        case DISCUSSION_ID:
            return DISCUSSION_ID_STRING;
        case ENROLMENT_ID:
            return ENROLMENT_ID_STRING;
        case ENROLMENT_METHOD:
            return ENROLMENT_METHOD_STRING;
        case EVENT:
            return EVENT_STRING;
        case EVENT_CONTEXT:
            return EVENT_CONTEXT_STRING;
        case EVENT_CONTEXT_KIND:
            return EVENT_CONTEXT_KIND_STRING;
        case EVENT_ID:
            return EVENT_ID_STRING;
        case EVENT_NAME:
            return EVENT_NAME_STRING;
        case EVENT_USER_ID:
            return EVENT_USER_ID_STRING;
        case HOUR:
            return HOUR_STRING;
        case IP_ADDRESS:
            return IP_ADDRESS_STRING;
        case ITEM_ID:
            return ITEM_ID_STRING;
        case MINUTES:
            return MINUTES_STRING;
        case MODULE:
            return MODULE_STRING;
        case MONTH:
            return MONTH_STRING;
        case ORIGIN:
            return ORIGIN_STRING;
        case POST_ID:
            return POST_ID_STRING;
        case RESOURCE_NAME:
            return RESOURCE_NAME_STRING;
        case ROLE_ID:
            return ROLE_ID_STRING;
        case SECTION_NUMBER:
            return SECTION_NUMBER_STRING;
        case TIME:
            return TIME_STRING;
        case VIEWING_MODE:
            return VIEWING_MODE_STRING;
        case YEAR:
            return YEAR_STRING;
        default:
            throw new IllegalArgumentException(UNKNOWN_ENUM_VALUE_FOR_COLUMN);
        }
    }

    public static Column columnEnum(String columnString) throws IllegalArgumentException {
        for(Column column : Column.values()) {
            if(columnName(column).equals(columnString)) {
                return column;
            }
        }
        throw new IllegalArgumentException(UNKNOWN_ENUM_VALUE_FOR_COLUMN);
    }

    public static ValueStore activity() {
        return new TypedValueStore<String>(ExtractActivity.extractor());
    }
    
    public static ValueStore affectedUserID() {
        return new TypedValueStore<Integer>(ExtractAffectedUserID.extractor());
    }

    public static ValueStore component() {
        return new TypedValueStore<String>(ExtractComponent.extractor());
    }

    public static ValueStore courseID() {
        return new TypedValueStore<Integer>(ExtractCourseID.extractor());
    }

    public static ValueStore courseModuleID() {
        return new TypedValueStore<Integer>(ExtractCourseModuleID.extractor());
    }

    public static ValueStore date() {
        return new TypedValueStore<String>(ExtractDate.extractor());
    }

    public static ValueStore dateTime() {
        return new TypedValueStore<String>(ExtractDateTime.extractor());
    }

    public static ValueStore day() {
        return new TypedValueStore<Integer>(ExtractDay.extractor());
    }

    public static ValueStore description() {
        return new TypedValueStore<String>(ExtractDescription.extractor());
    }

    public static ValueStore discussionID() {
        return new TypedValueStore<Integer>(ExtractDiscussionID.extractor());
    }

    public static ValueStore enrolmentID() {
        return new TypedValueStore<Integer>(ExtractEnrolmentID.extractor());
    }

    public static ValueStore enrolmentMethod() {
        return new TypedValueStore<String>(ExtractEnrolmentMethod.extractor());
    }

    public static ValueStore event() {
        return new TypedValueStore<String>(ExtractEvent.extractor());
    }

    public static ValueStore eventContext() {
        return new TypedValueStore<String>(ExtractEventContext.extractor());
    }

    public static ValueStore eventContextKind() {
        return new TypedValueStore<String>(ExtractEventContextKind.extractor());
    }

    public static ValueStore eventID() {
        return new TypedValueStore<Integer>(ExtractEventID.extractor());
    }

    public static ValueStore eventName() {
        return new TypedValueStore<String>(ExtractEventName.extractor());
    }

    public static ValueStore eventUserID() {
        return new TypedValueStore<Integer>(ExtractEventUserID.extractor());
    }

    public static ValueStore hour() {
        return new TypedValueStore<Integer>(ExtractHour.extractor());
    }

    public static ValueStore ipAddress() {
        return new TypedValueStore<String>(ExtractIPAddress.extractor());
    }

    public static ValueStore itemID() {
        return new TypedValueStore<Integer>(ExtractItemID.extractor());
    }

    public static ValueStore minutes() {
        return new TypedValueStore<Integer>(ExtractMinutes.extractor());
    }

    public static ValueStore module() {
        return new TypedValueStore<String>(ExtractModule.extractor());
    }

    public static ValueStore month() {
        return new TypedValueStore<Integer>(ExtractMonth.extractor());
    }

    public static ValueStore origin() {
        return new TypedValueStore<String>(ExtractOrigin.extractor());
    }

    public static ValueStore postID() {
        return new TypedValueStore<Integer>(ExtractPostID.extractor());
    }

    public static ValueStore resourceName() {
        return new TypedValueStore<String>(ExtractResourceName.extractor());
    }

    public static ValueStore roleID() {
        return new TypedValueStore<Integer>(ExtractRoleID.extractor());
    }

    public static ValueStore sectionNumber() {
        return new TypedValueStore<Integer>(ExtractSectionNumber.extractor());
    }

    public static ValueStore time() {
        return new TypedValueStore<String>(ExtractTime.extractor());
    }

    public static ValueStore viewingMode() {
        return new TypedValueStore<String>(ExtractViewingMode.extractor());
    }

    public static ValueStore year() {
        return new TypedValueStore<Integer>(ExtractYear.extractor());
    }
}
