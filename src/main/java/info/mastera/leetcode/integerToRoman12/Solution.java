package info.mastera.leetcode.integerToRoman12;

/**
 * 12. Integer to Roman
 * Medium
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * <p>
 * Example 2:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 3:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
public class Solution {

    final static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public String intToRoman1(int num) {
        StringBuilder result = new StringBuilder();
        int thousands = num / 1000;
        if (num >= 1000) {
            result.append("M".repeat(thousands));
        }
        int hundreds = (num - thousands * 1000) / 100;
        if (hundreds > 0) {
            if (hundreds <= 3) {
                result.append("C".repeat(hundreds));
            } else if (hundreds == 4) {
                result.append("CD");
            } else if (hundreds == 5) {
                result.append("D");
            } else if (hundreds <= 8) {
                result.append("D").append("C".repeat(hundreds - 5));
            } else {
                result.append("CM");
            }
        }
        int tens = (num - thousands * 1000 - hundreds * 100) / 10;
        if (tens > 0) {
            if (tens <= 3) {
                result.append("X".repeat(tens));
            } else if (tens == 4) {
                result.append("XL");
            } else if (tens == 5) {
                result.append("L");
            } else if (tens <= 8) {
                result.append("L").append("X".repeat(tens - 5));
            } else {
                result.append("XC");
            }
        }
        int ones = num - thousands * 1000 - hundreds * 100 - tens * 10;
        if (ones > 0) {
            if (ones <= 3) {
                result.append("I".repeat(ones));
            } else if (ones == 4) {
                result.append("IV");
            } else if (ones == 5) {
                result.append("V");
            } else if (ones <= 8) {
                result.append("V").append("I".repeat(ones - 5));
            } else {
                result.append("IX");
            }
        }
        return result.toString();
    }
}
