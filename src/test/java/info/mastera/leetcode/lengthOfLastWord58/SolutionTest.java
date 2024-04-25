package info.mastera.leetcode.lengthOfLastWord58;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        final Solution solution = new Solution();
        Assertions.assertEquals(5, solution.lengthOfLastWord("Hello World"));
        Assertions.assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "));
        Assertions.assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"));
        Assertions.assertEquals(1, solution.lengthOfLastWord("a"));
        Assertions.assertEquals(3, solution.lengthOfLastWord("Today is a nice day"));
    }
}