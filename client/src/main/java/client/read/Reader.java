package client.read;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event_context.EventContext.EventContextParseException;

public class Reader implements Closeable {
    private final BufferedReader bufferedReader;

    public Reader(String file) throws IOException, FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.readLine();
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }

    public EventData read() throws IOException, DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        final String line = bufferedReader.readLine();
        if(line != null) {
            final String[] data = line.split("\t");
            final String dateTime = data[0];
            final String eventContext = data[1];
            final String component = data[2];
            final String eventName = data[3];
            final String description = data[4];
            final String origin = data[5];
            final String ip = data.length == 7 ? data[6] : null;
            return EventData.fromData(dateTime, eventContext, component, eventName, description, origin, ip);
        }
        return null;
    }
}