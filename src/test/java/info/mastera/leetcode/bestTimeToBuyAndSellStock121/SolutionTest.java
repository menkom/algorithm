package info.mastera.leetcode.bestTimeToBuyAndSellStock121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(5, new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assertions.assertEquals(5, new Solution().maxProfit(new int[]{7, 2, 5, 1, 3, 6}));
        Assertions.assertEquals(0, new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assertions.assertEquals(7, new Solution().maxProfit(new int[]{5, 9, 4, 6, 1, 8}));
        Assertions.assertEquals(8, new Solution().maxProfit(new int[]{1, 8, 4, 6, 2, 9}));
    }
}