package info.mastera.leetcode.intersectionOfTwoArrays349;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{2}, new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertArrayEquals(new int[]{4, 9}, new Solution().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}