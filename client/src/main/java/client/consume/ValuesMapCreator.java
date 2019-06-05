package client.consume;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import client.consume.filter.FilterReader;
import client.consume.filter.condition.Condition;
import client.consume.value_map.ValueStore;
import client.consume.values_map.ValuesMap;
import client.consume.values_map.ValuesStore;
import client.read.EventData;
import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event_context.EventContext.EventContextParseException;

public class ValuesMapCreator implements Closeable {
    private final FilterReader reader;
    private final ValuesStore store;

    public ValuesMapCreator(String filePath, Condition condition, Column[] columns) throws IOException, FileNotFoundException, IllegalArgumentException {
        reader = new FilterReader(filePath, condition);
        final ValueStore[] stores = new ValueStore[columns.length];
        for(int i = 0; i < columns.length; ++i) {
            stores[i] = Column.fromColumn(columns[i]);
        }
        store = new ValuesStore(stores);
    }

    public ValuesMap createValuesMap() throws IOException, DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        EventData eventData = reader.read();
        while(eventData != null) {
            store.storeValues(eventData);
            eventData = reader.read();
        }
        return store.valuesMap();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}