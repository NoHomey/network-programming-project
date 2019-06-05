package client.consume.filter.condition;

import org.junit.Test;
import static org.junit.Assert.*;

public class AndTest extends LogicalTest {
    @Test
    public void testFalseAndFalseIsFalse() {
        final And and = new And(LogicalTest.FalseCondition.condition, LogicalTest.FalseCondition.condition);
        assertFalse(and.isTrue(null));
    }
    
    @Test
    public void testFalseAndTrueIsFalse() {
        final And and = new And(LogicalTest.FalseCondition.condition, LogicalTest.TrueCondition.condition);
        assertFalse(and.isTrue(null));
    }

    @Test
    public void testTrueAndFalseIsFalse() {
        final And and = new And(LogicalTest.TrueCondition.condition, LogicalTest.FalseCondition.condition);
        assertFalse(and.isTrue(null));
    }

    @Test
    public void testTrueAndTrueIsTrue() {
        final And and = new And(LogicalTest.TrueCondition.condition, LogicalTest.TrueCondition.condition);
        assertTrue(and.isTrue(null));
    }
}