package client.consume.extract;

import client.read.EventData;

public final class ExtractEnrolmentMethod extends Extractor<String> {
    private static final ExtractEnrolmentMethod instance = new ExtractEnrolmentMethod();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractEnrolmentMethod() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForEnrolmentMethod();
    }
}