package client.read.event.item_id;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.read.event.DescriptionMatchFailException;

public final class ItemCreatedEvent extends ItemIDEvent {
    private static final Pattern pattern = Pattern.compile("\\AItem created with ID (0|[123456789]\\d*)\\Q.\\E\\z");
    
    public static final String eventNameValue = "Item created";

    public static ItemCreatedEvent fromDescription(String description) throws DescriptionMatchFailException {
        final Matcher matcher = pattern.matcher(description);
        if(matcher.matches()) {
            final int itemID = Integer.parseInt(matcher.group(1));
            return new ItemCreatedEvent(itemID);
        } else throw new DescriptionMatchFailException(description);
    }

    public ItemCreatedEvent(int itemID) {
        super(eventNameValue, itemID);
    }

    @Override
    public final String valueForDescription() {
        return "Item created with ID " + itemID + ".";
    }
}