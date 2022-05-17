package info.mastera.leetcode.countSortedVowelStrings1641;

import info.mastera.leetcode.countSortedVowelStrings1641.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test1641CountVowelStrings() {
        Assertions.assertEquals(Solution.countVowelStrings(1),5);
        Assertions.assertEquals(Solution.countVowelStrings(2),15);
        Assertions.assertEquals(Solution.countVowelStrings(33),66045);
    }
}