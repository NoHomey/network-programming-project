package client.consume.filter.condition;

import client.read.EventData;

public abstract class LogicalTest {
    protected static final class TrueCondition extends Condition {
        public static TrueCondition condition = new TrueCondition();

        @Override
        public final boolean isTrue(EventData eventData) {
            return true;
        }
    }

    protected static final class FalseCondition extends Condition {
        public static FalseCondition condition = new FalseCondition();

        @Override
        public final boolean isTrue(EventData eventData) {
            return false;
        }
    }
}