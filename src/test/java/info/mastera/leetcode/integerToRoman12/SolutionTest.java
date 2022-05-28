package info.mastera.leetcode.integerToRoman12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals("II", new Solution().intToRoman(2));
        Assertions.assertEquals("III", new Solution().intToRoman(3));
        Assertions.assertEquals("IV", new Solution().intToRoman(4));
        Assertions.assertEquals("V", new Solution().intToRoman(5));
        Assertions.assertEquals("XII", new Solution().intToRoman(12));
        Assertions.assertEquals("XXVII", new Solution().intToRoman(27));
        Assertions.assertEquals("LVIII", new Solution().intToRoman(58));
        Assertions.assertEquals("MCMXCIV", new Solution().intToRoman(1994));
    }
}