package client.read.tool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ListEventTypes {
    public static void main(String[] args) {
        HashMap<EventInfo, String> eventTypes = new HashMap<EventInfo, String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            try {
                bufferedReader.readLine();
                String line = bufferedReader.readLine();
                while(line != null) {
                    final String[] data = line.split("\t");
                    final String context = data[1].split(":")[0];
                    final String component = data[2];
                    final String eventName = data[3];
                    final EventInfo eventInfo = new EventInfo(context, component, eventName);
                    if(!eventTypes.containsKey(eventInfo)) {
                        String pattern = data[4];
                        eventTypes.put(eventInfo, pattern);
                        System.out.print(context);
                        System.out.print(",");
                        System.out.print(component);
                        System.out.print(",");
                        System.out.print(eventName);
                        System.out.print(",");
                        System.out.println(pattern);
                    }
                    line = bufferedReader.readLine();
                }
            } catch (IOException exception) {
                System.out.println("could not read a line");
            }
        } catch(FileNotFoundException exception) {
            System.out.println("file not found");
        } catch(IOException exception) {
            System.out.println("IOException");
        }
    }
}

class EventInfo {
    public final String context;
    public final String component;
    public final String eventName;

    public EventInfo(String context, String component, String eventName) {
        this.context = context;
        this.component = component;
        this.eventName = eventName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof EventInfo)) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        EventInfo other = (EventInfo) obj;
        return (this.context.equals(other.context))
            && (this.component.equals(other.component))
            && (this.eventName.equals(other.eventName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, component, eventName);
    }
}