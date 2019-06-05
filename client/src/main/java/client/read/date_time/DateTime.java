package client.read.date_time;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTime implements DateTimeValues {
    public static class DateTimeParseException extends Exception {
        private static final long serialVersionUID = 6938756366601620815L;

        public DateTimeParseException(String text) {
            super("Text: " + text + " does not represent a valid date time information.");
        }
    }
    
    private static final Pattern pattern = Pattern.compile("\\A((?:[123456789])|(?:[12]\\d)|(?:30)|(?:31))/((?:0?[123456789])|(?:10)|(?:11)|(?:12))/(\\d\\d), ((?:[01]\\d)|(?:20)|(?:21)|(?:22)|(?:23)):([012345]\\d)\\z");

    private final LocalDateTime localDateTime;

    public static LocalDateTime fromText(String text) throws DateTimeParseException {
        Matcher matcher = pattern.matcher(text);
        if(matcher.matches()) {
            final int day = Integer.parseInt(matcher.group(1));
            final int month = Integer.parseInt(matcher.group(2));
            final int year = Integer.parseInt(matcher.group(3));
            final int hour = Integer.parseInt(matcher.group(4));
            final int minutes = Integer.parseInt(matcher.group(5));
            return LocalDateTime.of(year, month, day, hour, minutes);
        } else throw new DateTimeParseException(text);
    }

    public DateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public int valueForDay() {
        return localDateTime.getDayOfMonth();
    }

    @Override
    public int valueForMonth() {
        return localDateTime.getMonthValue();
    }

    @Override
    public int valueForYear() {
        return localDateTime.getYear();
    }

    @Override
    public int valueForHour() {
        return localDateTime.getHour();
    }

    @Override
    public int valueForMinutes() {
        return localDateTime.getMinute();
    }

    @Override
    public String valueForDate() {
        return valueForDay() + "/" + valueForMonth() + "/" + valueForYear();
    }

    @Override
    public String valueForTime() {
        final int hour = valueForHour();
        final int minutes = valueForMinutes();
        return (hour < 10 ? "0" : "") + valueForHour() + ":" +  (minutes < 10 ? "0" : "") + valueForMinutes();
    }

    @Override
    public String valueForDateTime() {
        return valueForDate() + ", " + valueForTime();
    }
}