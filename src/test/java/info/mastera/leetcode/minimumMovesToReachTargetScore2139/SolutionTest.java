package info.mastera.leetcode.minimumMovesToReachTargetScore2139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(new Solution().minMoves(5, 0), 4);
        Assertions.assertEquals(new Solution().minMoves(19, 2), 7);
        Assertions.assertEquals(new Solution().minMoves(10, 4), 4);
    }
}