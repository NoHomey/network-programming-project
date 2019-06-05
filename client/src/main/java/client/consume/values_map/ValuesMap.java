package client.consume.values_map;

import client.consume.Column;
import client.consume.value_map.ValueMap;
import client.read.EventData;

public class ValuesMap {
    private final ValueMap[] maps;

    public ValuesMap(ValueMap[] maps) {
        this.maps = maps;
    }

    public int[] mapValues(EventData eventData) {
        int notNullCount = 0;
        for(ValueMap map : maps) {
            if(map.mapValue(eventData) != null) {
                ++notNullCount;
            }
        }
        final int[] result = new int[notNullCount];
        int i = 0;
        for(ValueMap map : maps) {
            Integer value = map.mapValue(eventData);
            if(value != null) {
                result[i] = value.intValue();
                ++i;
            }
        }
        return result;
    }

    public void clear() {
        for(ValueMap map : maps) {
            map.clear();
        }
    }

    public ReverseValuesMap reverseValuesMap(Column[] columns) {
        return new ReverseValuesMap(maps, columns);
    }
}