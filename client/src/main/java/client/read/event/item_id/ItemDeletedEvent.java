package client.read.event.item_id;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class ItemDeletedEvent extends ItemIDEvent {
    private static final Pattern pattern = Pattern.compile("\\AItem with ID (0|[123456789]\\d*) deleted\\Q.\\E\\z");

    public static final String eventNameValue = "Item deleted";

    public static ItemDeletedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int itemID = Integer.parseInt(matcher.group(1));
            return new ItemDeletedEvent(itemID);
        }
        throw new DescriptionMatchFailException(description);
    }

    public ItemDeletedEvent(int itemID) {
        super(eventNameValue, itemID);
    }

    @Override
    public final String valueForDescription() {
        return "Item with ID " + itemID + " deleted.";
    }
}