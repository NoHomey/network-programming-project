package client.read.date_time;

import org.junit.Before;
import org.junit.Test;

import client.read.date_time.DateTime.DateTimeParseException;

import static org.junit.Assert.*;

public class DateTimeTest {
    DateTime dateTime;

    @Before
    public void initialize() {
        try {
            dateTime = new DateTime(DateTime.fromText("6/5/19, 23:30"));
        } catch(DateTimeParseException e) {
            dateTime = null;
        }
    }

    @Test
    public void testValueForDay() {
        assertEquals(6, dateTime.valueForDay());
    }
    
    @Test
    public void testValueForMonth() {
        assertEquals(5, dateTime.valueForMonth());
    }

    @Test
    public void testValueForYear() {
        assertEquals(19, dateTime.valueForYear());
    }

    @Test
    public void testValueForHour() {
        assertEquals(23, dateTime.valueForHour());
    }

    @Test
    public void testValueForMinutes() {
        assertEquals(30, dateTime.valueForMinutes());
    }

    @Test
    public void testValueForDate() {
        assertEquals("6/5/19", dateTime.valueForDate());
    }

    @Test
    public void testValueForTime() {
        assertEquals("23:30", dateTime.valueForTime());
    }

    @Test
    public void testValueForDateTime() {
        assertEquals("6/5/19, 23:30", dateTime.valueForDateTime());
    }
}