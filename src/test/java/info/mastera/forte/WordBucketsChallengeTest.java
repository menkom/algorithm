package info.mastera.forte;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Write a function that divides a phrase into word buckets with each bucket containing N or fewer characters.
 * - Each bucket must include full words.
 * - Spaces count as one character.
 * - Trim beginning and end spaces for each word bucket (see bucketize4 test).
 * - If buckets are too small to hold a single word, throw a runtime exception (see bucketize5 test).
 */
class WordBucketsChallengeTest {

    private static final List<String> MANY_WORDS = Collections.nCopies(1_000_000, "ab");
    private static final String LONG_PHRASE = String.join(" ", MANY_WORDS);

    private final WordBucketsChallenge challenge = new WordBucketsChallenge();

    @Test
    void bucketize1() {
        String input = "she sells sea shells by the sea";
        List<String> result = challenge.bucketize(input, 10);
        assertEquals(List.of("she sells", "sea shells", "by the sea"), result);
    }

    @Test
    void bucketize2() {
        String input = "the mouse jumped over the cheese";
        List<String> result = challenge.bucketize(input, 7);
        assertEquals(List.of("the", "mouse", "jumped", "over", "the", "cheese"), result);
    }

    @Test
    void bucketize3() {
        String input = "fairy dust coated the air";
        List<String> result = challenge.bucketize(input, 20);
        assertEquals(List.of("fairy dust coated", "the air"), result);
    }

    @Test
    void bucketize4() {
        String input = "a b c d e";
        List<String> result = challenge.bucketize(input, 2);
        assertEquals(List.of("a", "b", "c", "d", "e"), result);
    }

    @Test
    void bucketize5() {
        String input = "assertThrows returns the exception";
        Exception exception = assertThrows(RuntimeException.class, () -> challenge.bucketize(input, 2));
        assertEquals("maxSize too small", exception.getMessage());
    }

    static Stream<Arguments> edgeCases() {
        return Stream.of(
                arguments("  she sells  ", 9, List.of("she sells")),
                arguments("she  sells", 10, List.of("she  sells")),
                arguments("she  sells", 9, List.of("she", "sells")),
                arguments("hello", 5, List.of("hello")),
                arguments("ab cd ef", 5, List.of("ab cd", "ef")),
                arguments("fairy dust coated the air", 100, List.of("fairy dust coated the air")),
                arguments("she sells", Integer.MAX_VALUE, List.of("she sells")),
                arguments("a", 1, List.of("a")),
                arguments("", 5, List.of()),
                arguments("   ", 5, List.of()));
    }

    @ParameterizedTest(name = "\"{0}\" with maxSize {1} → {2}")
    @MethodSource("edgeCases")
    void bucketizeEdgeCases(String input, int maxSize, List<String> expected) {
        assertEquals(expected, challenge.bucketize(input, maxSize));
    }

    @ParameterizedTest(name = "\"{0}\" with maxSize {1} → maxSize too small")
    @CsvSource({
            "ok toolong ok, 3",
            "ok ok toolong, 3",
            "a, 0",
            "a, -1",
            "'', 0",
    })
    void rejectsMaxSizeTooSmall(String input, int maxSize) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> challenge.bucketize(input, maxSize));
        assertEquals("maxSize too small", exception.getMessage());
    }

    @Test
    void rejectsNullInput() {
        assertThrows(NullPointerException.class, () -> challenge.bucketize(null, 5));
    }

    @Test
    @Timeout(value = 1, threadMode = SEPARATE_THREAD)
    void putsEveryWordOfLongPhraseIntoOwnBucketInLinearTime() {
        assertEquals(MANY_WORDS, challenge.bucketize(LONG_PHRASE, 2));
    }

    @Test
    @Timeout(value = 1, threadMode = SEPARATE_THREAD)
    void keepsLongPhraseInSingleBucketInLinearTime() {
        assertEquals(List.of(LONG_PHRASE), challenge.bucketize(LONG_PHRASE, Integer.MAX_VALUE));
    }
}
