package client.consume.extract;

import client.read.EventData;

public final class ExtractEnrolmentID extends Extractor<Integer> {
    private static final ExtractEnrolmentID instance = new ExtractEnrolmentID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractEnrolmentID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForEnrolmentID();
    }
}