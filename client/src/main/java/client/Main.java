package client;

import client.consume.filter.condition.Condition;
import client.consume.filter.condition.True;
import client.consume.values_map.ReverseValuesMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import client.consume.Column;

public class Main {
    public static Column[] readColumns() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Column> list = new ArrayList<Column>();
        String line = reader.readLine();
        while(line != null) {
            list.add(Column.columnEnum(line));
            line = reader.readLine();
        }
        Column[] columns = new Column[list.size()];
        return list.toArray(columns);
    }

    public static void main(String[] args) {
        final Condition filter = True.condition;
        System.out.println("Enter characteristics (columns) you are interested in:");
        try(final Client client = new Client()) {
            final Column[] columns = readColumns();
            final String inputFilePath = args[0];
            final double minSupp = Double.parseDouble(args[1]);
            final String outputFilePath = args[2];
            final ReverseValuesMap reverseMap = client.sendData(inputFilePath, minSupp, filter, columns);
            client.receiveResult(outputFilePath, reverseMap);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
