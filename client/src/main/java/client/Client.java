package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import client.consume.Column;
import client.consume.ValuesMapper;
import client.consume.filter.condition.Condition;
import client.consume.values_map.ReverseValuesMap;
import client.read.date_time.DateTime.DateTimeParseException;
import client.read.event.DescriptionMatchFailException;
import client.read.event_context.EventContext.EventContextParseException;

public class Client implements Closeable {
    private static final String host = "127.0.0.1";
    private static final int port = 9087;

    private static <V> void sendValue(BufferedWriter writer, V value) throws IOException {
        writer.write(value.toString());
    }

    private static void sendChar(BufferedWriter writer, char c) throws IOException {
        sendValue(writer, c);
    }

    private static void sendMappedValues(BufferedWriter writer, int[] mappedValues) throws IOException {
        if(mappedValues.length > 0) {
            final int separated = mappedValues.length - 1;
            for(int i = 0; i < separated; ++i) {
                sendValue(writer, mappedValues[i]);
                sendChar(writer, ' ');
            }
            sendValue(writer, mappedValues[separated]);
            writer.newLine();
        }
    }

    private static void writeHeader(BufferedWriter writer, Column[] columns) throws IOException, IllegalArgumentException {
        for(Column column : columns) {
            writer.write(Column.columnName(column));
            writer.write('\t');
        }
        writer.write("Support");
        writer.write('\t');
        writer.write("Support %");
        writer.newLine();
    }

    private final Socket socket;
    private int counter;

    private void readAndSendData(ValuesMapper reader, BufferedWriter writer)
                throws IOException, DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        int[] mapped = reader.readMapped();
        while(mapped != null) { 
            ++counter;
            sendMappedValues(writer, mapped);  
            mapped = reader.readMapped();
        }
        writer.flush();
    }

    private void storeData(BufferedWriter writer, Object[] objects, int support) throws IOException {
        for(Object obj : objects) {
            if(obj == null) {
                writer.write(' ');
            } else {
                writer.write(obj.toString());
            }
            writer.write('\t');
        }
        writer.write(Integer.toString(support));
        writer.write('\t');
        writer.write(Float.toString(Float.valueOf(support) / counter));
        writer.newLine();
    }

    private void storeLine(BufferedWriter writer, String line, ReverseValuesMap reverseMap) throws IOException {
        final String[] data = line.split("\\s+#SUP: ", 2);
        final String[] stringIndexes = data[0].split(" ");
        final int[] indexes = new int[stringIndexes.length];
        final int support = Integer.parseInt(data[1]);
        for(int i = 0; i < stringIndexes.length; ++i) {
            indexes[i] = Integer.parseInt(stringIndexes[i]);
        }
        final Object[] result = reverseMap.valuesFromIndexes(indexes);
        storeData(writer, result, support);
    }

    private void receiveData(BufferedReader reader, BufferedWriter writer, ReverseValuesMap reverseMap) throws IOException {
        String line = reader.readLine();
        while(line != null) {
            storeLine(writer, line, reverseMap);
            line = reader.readLine();
        }
        writer.flush();
    }

    public Client() throws UnknownHostException, IOException {
        socket = new Socket(host, port);
        counter = 0;
    }

    public ReverseValuesMap sendData(String filePath, double minSupportPercentage, Condition condition, Column[] columns)
                            throws IOException, FileNotFoundException, IllegalArgumentException,
                            DateTimeParseException, EventContextParseException, DescriptionMatchFailException {
        final ValuesMapper reader = new ValuesMapper(filePath, condition, columns);
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        sendValue(writer, minSupportPercentage);
        writer.newLine();
        readAndSendData(reader, writer);
        reader.close();
        socket.shutdownOutput();
        return reader.reverseValuesMap();
    }

    public void receiveResult(String outputFile, ReverseValuesMap reverseMap) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writeHeader(writer, reverseMap.columns);
        receiveData(reader, writer, reverseMap);
        writer.close();
        socket.shutdownInput();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}