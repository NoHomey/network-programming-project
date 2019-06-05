package client.consume;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import client.consume.filter.FilterReader;
import client.consume.filter.condition.Condition;
import client.consume.values_map.ReverseValuesMap;
import client.consume.values_map.ValuesMap;
import client.read.EventData;
import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event_context.EventContext.EventContextParseException;

public class ValuesMapper implements Closeable {
    private final ValuesMap map;
    private final FilterReader reader;

    public final Column[] columns;

    public ValuesMapper(String filePath, Condition condition, Column[] columns)
            throws IOException, FileNotFoundException, IllegalArgumentException,
            DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        try(final ValuesMapCreator mapCreator = new ValuesMapCreator(filePath, condition, columns)) {
            map = mapCreator.createValuesMap();
        }
        reader = new FilterReader(filePath, condition);
        this.columns = columns;
    }

    public int[] readMapped() throws IOException, DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        final EventData eventData = reader.read();
        if(eventData != null) {
            return map.mapValues(eventData);
        }
        return null;
    }

    public ReverseValuesMap reverseValuesMap() {
        final ReverseValuesMap reverse = map.reverseValuesMap(columns);
        map.clear();
        return reverse;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

}