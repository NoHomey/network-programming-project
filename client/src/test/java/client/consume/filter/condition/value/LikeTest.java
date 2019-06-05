package client.consume.filter.condition.value;

import org.junit.Test;
import static org.junit.Assert.*;

public class LikeTest extends ValueTest {
    @Test
    public void testWhenRegexIsNullThrows() {
        try {
            Like.fromIntegerExtractor(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            new Like(ValueTest.NullExtractor.stringExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenValueIsNullIsFalse() {
        final Like c1 = Like.fromIntegerExtractor(ValueTest.NullExtractor.integerExtractor, "12");
        assertFalse(c1.isTrue(null));
        final Like c2 = new Like(ValueTest.NullExtractor.stringExtractor, "absc");
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsLikeIsTrue() {
        final Like c1 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(2), "2\\d?");
        assertTrue(c1.isTrue(null));
        final Like c2 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(21), "2\\d?");
        assertTrue(c2.isTrue(null));
        final Like c3 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(20), "2\\d?");
        assertTrue(c3.isTrue(null));

        final Like c4 = new Like(new ValueTest.StringExtractor("abc"), "ab.?");
        assertTrue(c4.isTrue(null));
        final Like c5 = new Like(new ValueTest.StringExtractor("ab"), "ab.?");
        assertTrue(c5.isTrue(null));
        final Like c6 = new Like(new ValueTest.StringExtractor("abz"), "ab.?");
        assertTrue(c6.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsNotLikeIsFalse() {
        final Like c1 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(3), "2\\d?");
        assertFalse(c1.isTrue(null));
        final Like c2 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(210), "2\\d?");
        assertFalse(c2.isTrue(null));
        final Like c3 = Like.fromIntegerExtractor(new ValueTest.IntegerExtractor(30), "2\\d?");
        assertFalse(c3.isTrue(null));

        final Like c4 = new Like(new ValueTest.StringExtractor("adc"), "ab.?");
        assertFalse(c4.isTrue(null));
        final Like c5 = new Like(new ValueTest.StringExtractor("aa"), "ab.?");
        assertFalse(c5.isTrue(null));
        final Like c6 = new Like(new ValueTest.StringExtractor("abcd"), "ab.?");
        assertFalse(c6.isTrue(null));
    }
}