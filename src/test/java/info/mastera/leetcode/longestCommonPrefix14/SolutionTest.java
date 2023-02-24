package info.mastera.leetcode.longestCommonPrefix14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals("ab", new Solution().longestCommonPrefix(new String[]{"ab"}));
        Assertions.assertEquals("", new Solution().longestCommonPrefix(new String[]{""}));
        Assertions.assertEquals("fl", new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assertions.assertEquals("", new Solution().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        Assertions.assertEquals("d", new Solution().longestCommonPrefix(new String[]{"d", "dr", "dc"}));
    }
}