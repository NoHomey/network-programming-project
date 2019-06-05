package client.consume.filter.condition.value;

import client.consume.extract.Extractor;

public final class InRange extends ValueCondition<Integer> {
    private final int minValue;
    private final int maxValue;

    public InRange(Extractor<Integer> extractor, int minValue, int maxValue) {
        super(extractor);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    protected final boolean check(Integer value) {
        if(value != null) {
            final int v = value.intValue();
            int left = minValue;
            int right = maxValue;
            while(left <= right) {
                final int mid = left + (right - left) / 2;
                if(mid == v) {
                    return true;
                } else {
                    if(v > mid) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}