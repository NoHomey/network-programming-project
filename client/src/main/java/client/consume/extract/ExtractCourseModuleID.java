package client.consume.extract;

import client.read.EventData;

public final class ExtractCourseModuleID extends Extractor<Integer> {
    private static final ExtractCourseModuleID instance = new ExtractCourseModuleID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractCourseModuleID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForCourseModuleID();
    }
}