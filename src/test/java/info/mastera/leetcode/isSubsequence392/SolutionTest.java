package info.mastera.leetcode.isSubsequence392;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest(name = "\"{0}\" subsequence of \"{1}\" → {2}")
    @CsvSource({
            "abc, ahbgdc, true",
            "axc, ahbgdc, false",
            "'', ahbgdc, true",
            "'', '', true",
            "abc, ab, false",
            "aaaaaa, bbaaaa, false",
            "ssssss, sssssss, true",            
    })
    void isSubsequence(String s, String t, boolean expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.isSubsequence(s, t));
        assertEquals(expected, solution.isSubsequenceWithIndexMap(s, t));
    }
}
