package info.mastera.leetcode.transposeMatrix867;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[][]{new int[]{1, 4, 7}, new int[]{2, 5, 8}, new int[]{3, 6, 9}}, new Solution().transpose(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
        Assertions.assertArrayEquals(new int[][]{new int[]{1, 4}, new int[]{2, 5}, new int[]{3, 6}}, new Solution().transpose(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}));
    }
}