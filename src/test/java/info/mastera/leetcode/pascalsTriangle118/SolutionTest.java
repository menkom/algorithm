package info.mastera.leetcode.pascalsTriangle118;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(List.of(List.of(1)), new Solution().generate(1));
        Assertions.assertEquals(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1)),
                new Solution().generate(5));
    }

    @Test
    public void testII() {
        Assertions.assertEquals(List.of(1), new Solution().generateII(0));
        Assertions.assertEquals(List.of(1, 3, 3, 1), new Solution().generateII(3));
        Assertions.assertEquals(List.of(1, 4, 6, 4, 1), new Solution().generateII(4));
        Assertions.assertEquals(List.of(1,30,435,4060,27405,142506,593775,2035800,5852925,14307150,30045015,54627300,86493225,119759850,145422675,155117520,145422675,119759850,86493225,54627300,30045015,14307150,5852925,2035800,593775,142506,27405,4060,435,30,1),
                new Solution().generateII(30));
    }
}