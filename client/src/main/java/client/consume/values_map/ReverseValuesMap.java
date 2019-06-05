package client.consume.values_map;

import client.consume.value_map.ValueMap;
import client.consume.Column;
import client.consume.value_map.ReverseValueMap;

public class ReverseValuesMap {
    private final ReverseValueMap[] reverseValueMaps;
    
    public final Column[] columns;

    public ReverseValuesMap(ValueMap[] valueMaps, Column[] columns) {
        reverseValueMaps = new ReverseValueMap[valueMaps.length];
        for(int i = 0; i < valueMaps.length; ++i) {
            reverseValueMaps[i] = valueMaps[i].reverseValueMap();
        }
        this.columns = columns;
    }

    public Object[] valuesFromIndexes(int[] indexes) {
        final Object[] result = new Object[reverseValueMaps.length];
        int j = 0;
        int startIndex = Integer.MIN_VALUE;
        for(int i = 0; i < reverseValueMaps.length; ++i) {
            final int index = indexes[j];
            final int endIndex = startIndex + reverseValueMaps[i].size();
            if((index >= startIndex) && (index < endIndex)) {
                final Object value = reverseValueMaps[i].valueFromIndex(index);
                result[i] = value;
                if(value != null) {
                    ++j;
                }
                if(j == indexes.length) {
                    for(int k = i + 1; k < reverseValueMaps.length; ++k) {
                        result[k] = null;
                    }
                    break;
                }
            } else {
                result[i] = null;
            }
            startIndex = endIndex;
        }
        return result;
    }
}