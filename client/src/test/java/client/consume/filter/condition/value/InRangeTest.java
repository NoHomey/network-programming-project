package client.consume.filter.condition.value;

import org.junit.Test;
import static org.junit.Assert.*;

public class InRangeTest extends ValueTest {
    @Test
    public void testIsTrueWhenValueIsNullIsFalse() {
        final InRange c = new InRange(ValueTest.NullExtractor.integerExtractor, 2, 4);
        assertFalse(c.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsInRangeIsTrue() {
        final InRange c1 = new InRange(new ValueTest.IntegerExtractor(2), 2, 5);
        assertTrue(c1.isTrue(null));
        final InRange c2 = new InRange(new ValueTest.IntegerExtractor(3), 2, 5);
        assertTrue(c2.isTrue(null));
        final InRange c3 = new InRange(new ValueTest.IntegerExtractor(4), 2, 5);
        assertTrue(c3.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsNotInRangeIsFalse() {
        final InRange c1 = new InRange(new ValueTest.IntegerExtractor(1), 2, 5);
        assertFalse(c1.isTrue(null));
        final InRange c2 = new InRange(new ValueTest.IntegerExtractor(6), 2, 5);
        assertFalse(c2.isTrue(null));
        final InRange c3 = new InRange(new ValueTest.IntegerExtractor(1120), 2, 5);
        assertFalse(c3.isTrue(null));
    }
}