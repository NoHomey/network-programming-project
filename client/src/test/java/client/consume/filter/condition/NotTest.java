package client.consume.filter.condition;

import org.junit.Test;
import static org.junit.Assert.*;

public class NotTest extends LogicalTest {
    @Test
    public void testNotFalseIsTrue() {
        final Not not = new Not(LogicalTest.FalseCondition.condition);
        assertTrue(not.isTrue(null));
    }
    
    @Test
    public void testNotTrueIsFalse() {
        final Not not = new Not(LogicalTest.TrueCondition.condition);
        assertFalse(not.isTrue(null));
    }
}