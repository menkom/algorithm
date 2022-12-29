package info.mastera.leetcode.findAllNumbersDisappearedInAnArray448;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertEquals(List.of(5, 6), new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        Assertions.assertEquals(List.of(2), new Solution().findDisappearedNumbers(new int[]{1, 1}));
    }
}