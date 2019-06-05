package client.read.event.single_user.course_module.discussion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class SomeContentHasBeenPostedEvent extends DiscussionEvent {
    private static final Pattern pattern = Pattern.compile("\\AThe user with id '(0|[123456789]\\d*)' has posted content in the forum post with id '(0|[123456789]\\d*)' in the discussion '(0|[123456789]\\d*)' located in the forum with course module id '(0|[123456789]\\d*)'\\Q.\\E\\z");
    
    public static final String eventNameValue = "Some content has been posted.";

    public static SomeContentHasBeenPostedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int userID = Integer.parseInt(matcher.group(1));
            final int postID = Integer.parseInt(matcher.group(2));
            final int discussionID = Integer.parseInt(matcher.group(3));
            final int courseModuleID = Integer.parseInt(matcher.group(4));
            return new SomeContentHasBeenPostedEvent(userID, postID, discussionID, courseModuleID);
        } else throw new DescriptionMatchFailException(description);
    }

    private final int postID;

    public SomeContentHasBeenPostedEvent(int userID, int postID, int discussionID, int courseModuleID) {
        super(eventNameValue, userID, discussionID, courseModuleID);
        this.postID = postID;
    }

    @Override
    public final String valueForDescription() {
        return "The user with id '" + userID + "' has posted content in the forum post with id '" + postID + "' in the discussion '" + discussionID + "' located in the forum with course module id '" + courseModuleID + "'.";
    }
    
    @Override
    public final Integer valueForPostID() {
        return postID;
    }
}