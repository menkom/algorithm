package info.mastera.leetcode.islandPerimeter463;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertEquals(16, new Solution().islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        Assertions.assertEquals(4, new Solution().islandPerimeter(new int[][]{{1}}));
        Assertions.assertEquals(4, new Solution().islandPerimeter(new int[][]{{1, 0}}));
    }
}