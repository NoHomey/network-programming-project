package client.read.event.item_id;

import client.read.event.DescriptionMatchFailException;
import client.read.event.Event;

public abstract class ItemIDEvent extends Event {
    public static final String componentValue = "Recycle bin";

    public static Event fromData(String component, String eventName, String description) throws DescriptionMatchFailException {
        if(componentValue.equals(component)) {
            if(ItemCreatedEvent.eventNameValue.equals(eventName)) {
                return ItemCreatedEvent.fromDescription(description);
            }
            if(ItemDeletedEvent.eventNameValue.equals(eventName)) {
                return ItemDeletedEvent.fromDescription(description);
            }
        }
        return null;
    }

    protected final int itemID;

    public ItemIDEvent(String eventName, int itemID) {
        super(componentValue, eventName);
        this.itemID = itemID;
    }

    @Override
    public final Integer valueForItemID() {
        return itemID;
    }
}