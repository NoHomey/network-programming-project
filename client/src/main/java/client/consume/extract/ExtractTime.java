package client.consume.extract;

import client.read.EventData;

public final class ExtractTime extends Extractor<String> {
    private static final ExtractTime instance = new ExtractTime();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractTime() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForTime();
    }
}