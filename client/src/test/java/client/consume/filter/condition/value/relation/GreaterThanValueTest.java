package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class GreaterThanValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new GreaterThanValue<Integer>(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenNullIsFalse() {
        final GreaterThanValue<Integer> c1 = new GreaterThanValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final GreaterThanValue<String> c2 = new GreaterThanValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenGreaterIsTrue() {
        final GreaterThanValue<Integer> c1 = new GreaterThanValue<Integer>(new ValueTest.IntegerExtractor(11), 10);
        assertTrue(c1.isTrue(null));
        final GreaterThanValue<Integer> c2 = new GreaterThanValue<Integer>(new ValueTest.IntegerExtractor(100), 10);
        assertTrue(c2.isTrue(null));

        final GreaterThanValue<String> c3 = new GreaterThanValue<String>(new ValueTest.StringExtractor("abf"), "abd");
        assertTrue(c3.isTrue(null));
        final GreaterThanValue<String> c4 = new GreaterThanValue<String>(new ValueTest.StringExtractor("bb"), "abd");
        assertTrue(c4.isTrue(null));
    }

    @Test
    public void testIsTrueWhenLessOrEqualIsFalse() {
        final GreaterThanValue<Integer> c1 = new GreaterThanValue<Integer>(new ValueTest.IntegerExtractor(9), 10);
        assertFalse(c1.isTrue(null));
        final GreaterThanValue<Integer> c2 = new GreaterThanValue<Integer>(new ValueTest.IntegerExtractor(10), 10);
        assertFalse(c2.isTrue(null));

        final GreaterThanValue<String> c3 = new GreaterThanValue<String>(new ValueTest.StringExtractor("abd"), "abd");
        assertFalse(c3.isTrue(null));
        final GreaterThanValue<String> c4 = new GreaterThanValue<String>(new ValueTest.StringExtractor("aa"), "abd");
        assertFalse(c4.isTrue(null));
    }
}