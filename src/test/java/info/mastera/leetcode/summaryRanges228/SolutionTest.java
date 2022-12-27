package info.mastera.leetcode.summaryRanges228;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(List.of(), new Solution().summaryRanges(new int[]{}));
        Assertions.assertEquals(List.of("1"), new Solution().summaryRanges(new int[]{1}));
        Assertions.assertEquals(List.of("0->2", "4->5", "7"), new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        Assertions.assertEquals(List.of("0", "2->4", "6", "8->9"), new Solution().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}