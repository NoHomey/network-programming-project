package client.consume.value_map;

import client.read.EventData;

public interface ValueStore {
    public void storeValue(EventData eventData);

    public ValueMap valueMap(int start);
}