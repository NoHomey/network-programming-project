package client.consume.filter.condition;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrTest extends LogicalTest {
    @Test
    public void testFalseOrFalseIsFalse() {
        final Or or = new Or(LogicalTest.FalseCondition.condition, LogicalTest.FalseCondition.condition);
        assertFalse(or.isTrue(null));
    }
    
    @Test
    public void testFalseOrTrueIsTrue() {
        final Or or = new Or(LogicalTest.FalseCondition.condition, LogicalTest.TrueCondition.condition);
        assertTrue(or.isTrue(null));
    }

    @Test
    public void testTrueOrFalseIsTrue() {
        final Or or = new Or(LogicalTest.TrueCondition.condition, LogicalTest.FalseCondition.condition);
        assertTrue(or.isTrue(null));
    }

    @Test
    public void testTrueOrTrueIsTrue() {
        final Or or = new Or(LogicalTest.TrueCondition.condition, LogicalTest.TrueCondition.condition);
        assertTrue(or.isTrue(null));
    }
}