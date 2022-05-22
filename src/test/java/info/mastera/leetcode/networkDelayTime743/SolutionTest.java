package info.mastera.leetcode.networkDelayTime743;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2), 2);
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 2}, {2, 3, 1}, {3, 4, 1}}, 4, 2), 2);

        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 4, 4}, {2, 5, 5}, {3, 5, 3}}, 5, 1), 5);

        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1), 1);
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2), -1);
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 1}}, 2, 2), 1);
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 1}}, 2, 1), -1);

        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {2, 4, 3}, {3, 4, 1}}, 4, 2), 2);
        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 2}, {2, 4, 3}, {3, 4, 1}}, 4, 2), 3);

        Assertions.assertEquals(new Solution().networkDelayTime(new int[][]{{2, 1, 2}, {2, 3, 1}, {3, 4, 1}}, 4, 2), 2);
    }
}