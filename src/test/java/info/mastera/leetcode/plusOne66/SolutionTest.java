package info.mastera.leetcode.plusOne66;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{2}, new Solution().plusOne(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{9}, new Solution().plusOne(new int[]{8}));
        Assertions.assertArrayEquals(new int[]{1, 0}, new Solution().plusOne(new int[]{9}));
        Assertions.assertArrayEquals(new int[]{1, 2, 4}, new Solution().plusOne(new int[]{1, 2, 3}));
        Assertions.assertArrayEquals(new int[]{4, 3, 2, 2}, new Solution().plusOne(new int[]{4, 3, 2, 1}));
    }
}