package client.consume.extract;

import client.read.EventData;

public final class ExtractIPAddress extends Extractor<String> {
    private static final ExtractIPAddress instance = new ExtractIPAddress();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractIPAddress() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForIPAddress();
    }
}