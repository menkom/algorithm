package info.mastera.leetcode.PermutationsII47;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(Solution.permuteUnique(new int[]{1, 1, 2}), List.of(List.of(2, 1, 1), List.of(1, 2, 1), List.of(1, 1, 2)));
        Assertions.assertEquals(Solution.permuteUnique(new int[]{1, 2, 3}), List.of(List.of(3, 2, 1), List.of(2, 3, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 1, 3), List.of(1, 2, 3)));
    }
}