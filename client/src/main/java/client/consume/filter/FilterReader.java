package client.consume.filter;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import client.consume.filter.condition.Condition;
import client.read.EventData;
import client.read.Reader;
import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event_context.EventContext.EventContextParseException;

public class FilterReader extends Reader implements Closeable {
    private final Condition condition;
    
    public FilterReader(String file, Condition condition) throws IOException, FileNotFoundException {
        super(file);
        this.condition = condition;
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    public EventData read() throws IOException, DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        EventData eventData = super.read();
        while((eventData != null) && (!condition.isTrue(eventData))) {
            eventData = super.read();
        }
        return eventData;
    }
}