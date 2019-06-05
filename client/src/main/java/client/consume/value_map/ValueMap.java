package client.consume.value_map;

import client.read.EventData;

public interface ValueMap {
    public Integer mapValue(EventData eventData);

    public int size();

    public void clear();

    public ReverseValueMap reverseValueMap();
}