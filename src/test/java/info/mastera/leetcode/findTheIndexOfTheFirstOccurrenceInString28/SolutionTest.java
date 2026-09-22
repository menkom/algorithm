package info.mastera.leetcode.findTheIndexOfTheFirstOccurrenceInString28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    static Stream<Arguments> occurrences() {
        return Stream.of(
                arguments("sadbutsad", "sad", 0),
                arguments("leetcode", "leeto", -1),
                arguments("hello", "ll", 2),
                arguments("abc", "c", 2),
                arguments("abc", "abc", 0),
                arguments("short", "longer", -1),
                arguments("a", "a", 0),
                arguments("a", "b", -1),
                arguments("mississippi", "issip", 4),
                arguments("ababcaababcaabc", "ababcaabc", 6),
                arguments("aa", "bb", -1),
                arguments("aaaab", "aab", 2),
                arguments("abababab", "abab", 0),
                arguments("aaaa", "aa", 0));
    }

    @ParameterizedTest(name = "\"{1}\" in \"{0}\" returns {2}")
    @MethodSource("occurrences")
    void returnsIndexOfFirstOccurrence(String haystack, String needle, int expectedIndex) {
        assertEquals(expectedIndex, new Solution().strStr(haystack, needle));
    }

    @ParameterizedTest(name = "\"{1}\" in \"{0}\" returns {2}")
    @MethodSource("occurrences")
    void kmpVariantReturnsIndexOfFirstOccurrence(String haystack, String needle, int expectedIndex) {
        assertEquals(expectedIndex, new Solution().strStr0(haystack, needle));
    }

    @Test
    void handlesMaximumLengthWithLongPrefixFallback() {
        String haystack = "a".repeat(9_999) + "b";
        String needle = "a".repeat(9_998) + "b";
        Solution solution = new Solution();

        assertEquals(1, solution.strStr(haystack, needle));
        assertEquals(1, solution.strStr0(haystack, needle));
    }
}
