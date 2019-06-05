package client.consume.extract;

import client.read.EventData;

public final class ExtractCourseID extends Extractor<Integer> {
    private static final ExtractCourseID instance = new ExtractCourseID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractCourseID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForCourseID();
    }
}