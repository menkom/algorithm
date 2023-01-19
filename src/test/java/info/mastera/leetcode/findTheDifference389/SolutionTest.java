package info.mastera.leetcode.findTheDifference389;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertEquals('t', new Solution().findTheDifference("", "t"));
        Assertions.assertEquals('t', new Solution().findTheDifference("abc", "tabc"));
        Assertions.assertEquals('t', new Solution().findTheDifference("abc", "atbc"));
        Assertions.assertEquals('t', new Solution().findTheDifference("abc", "ctab"));
    }
}