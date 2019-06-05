package client.consume.values_map;

import client.consume.value_map.ValueMap;
import client.consume.value_map.ValueStore;
import client.read.EventData;

public class ValuesStore {
    private final ValueStore[] stores;

    public ValuesStore(ValueStore[] stores) {
        this.stores = stores;
    }

    public void storeValues(EventData eventData) {
        for(ValueStore store : stores) {
            store.storeValue(eventData);
        }
    }

    public ValuesMap valuesMap() {
        int startIndex = Integer.MIN_VALUE;
        final ValueMap[] maps = new ValueMap[stores.length];
        for(int i = 0; i < stores.length; ++i) {
            maps[i] = stores[i].valueMap(startIndex);
            startIndex += maps[i].size();
        }
        return new ValuesMap(maps);
    }
}