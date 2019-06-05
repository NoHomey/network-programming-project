package client.consume.filter.condition.value;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValueInListTest extends ValueTest {
    @Test
    public void testWhenListIsNullThrows() {
        try {
            new ValueInList<Object>(ValueTest.NullExtractor.extractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            new ValueInList<Integer>(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            new ValueInList<String>(ValueTest.NullExtractor.stringExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testWhenValueInListIsNullThrows() {
        try {
            new ValueInList<Object>(ValueTest.NullExtractor.extractor, new Object[]{null});
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            new ValueInList<Integer>(ValueTest.NullExtractor.integerExtractor, new Integer[]{null});
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            new ValueInList<String>(ValueTest.NullExtractor.stringExtractor, new String[]{null});
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenValueIsNullIsFalse() {
        final ValueInList<Object> c1 = new ValueInList<Object>(ValueTest.NullExtractor.extractor, new Integer[]{2, 5, 7});
        assertFalse(c1.isTrue(null));
        final ValueInList<Integer> c2 = new ValueInList<Integer>(ValueTest.NullExtractor.integerExtractor, new Integer[]{2, 5, 7});
        assertFalse(c2.isTrue(null));
        final ValueInList<String> c3 = new ValueInList<String>(ValueTest.NullExtractor.stringExtractor, new String[]{"absc", "cd", "rmf"});
        assertFalse(c3.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsInListIsTrue() {
        final ValueInList<Integer> c1 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(2), new Integer[]{2, 5, 7});
        assertTrue(c1.isTrue(null));
        final ValueInList<Integer> c2 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(5), new Integer[]{2, 5, 7});
        assertTrue(c2.isTrue(null));
        final ValueInList<Integer> c3 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(7), new Integer[]{2, 5, 7});
        assertTrue(c3.isTrue(null));

        final ValueInList<String> c4 = new ValueInList<String>(new ValueTest.StringExtractor("abc"), new String[]{"bc", "ab", "abc"});
        assertTrue(c4.isTrue(null));
        final ValueInList<String> c5 = new ValueInList<String>(new ValueTest.StringExtractor("bc"), new String[]{"bc", "ab", "abc"});
        assertTrue(c5.isTrue(null));
        final ValueInList<String> c6 = new ValueInList<String>(new ValueTest.StringExtractor("ab"), new String[]{"bc", "ab", "abc"});
        assertTrue(c6.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsNotInListIsFalse() {
        final ValueInList<Integer> c1 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(1), new Integer[]{2, 5, 7});
        assertFalse(c1.isTrue(null));
        final ValueInList<Integer> c2 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(3), new Integer[]{2, 5, 7});
        assertFalse(c2.isTrue(null));
        final ValueInList<Integer> c3 = new ValueInList<Integer>(new ValueTest.IntegerExtractor(1120), new Integer[]{2, 5, 7});
        assertFalse(c3.isTrue(null));

        final ValueInList<String> c4 = new ValueInList<String>(new ValueTest.StringExtractor("abcd"), new String[]{"bc", "ab", "abc"});
        assertFalse(c4.isTrue(null));
        final ValueInList<String> c5 = new ValueInList<String>(new ValueTest.StringExtractor("b"), new String[]{"bc", "ab", "abc"});
        assertFalse(c5.isTrue(null));
        final ValueInList<String> c6 = new ValueInList<String>(new ValueTest.StringExtractor("abd"), new String[]{"bc", "ab", "abc"});
        assertFalse(c6.isTrue(null));
    }
}