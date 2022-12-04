package info.mastera.leetcode.singleNumber136;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(1, new Solution().singleNumber(new int[]{2,2,1}));
        Assertions.assertEquals(4, new Solution().singleNumber(new int[]{4,1,2,1,2}));
        Assertions.assertEquals(1, new Solution().singleNumber(new int[]{1}));
    }
}