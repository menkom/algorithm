package info.mastera.leetcode.runningSumOf1dArray1480;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 3, 6, 10}, new Solution().runningSum(new int[]{1, 2, 3, 4}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new Solution().runningSum(new int[]{1, 1, 1, 1, 1}));
        Assertions.assertArrayEquals(new int[]{3, 4, 6, 16, 17}, new Solution().runningSum(new int[]{3, 1, 2, 10, 1}));
    }
}