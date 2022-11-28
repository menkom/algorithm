package info.mastera.leetcode.plusOne66;

import java.util.Arrays;

/**
 * 66. Plus One
 * Easy
 * 5.9K
 * 4.6K
 * Companies
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Example 3:
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            digits[i] = digits[i] + 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] result = Arrays.copyOf(digits, digits.length+1);
                    result[0] = 1;
                    return result;
                }
            } else {
                return digits;
            }
            i--;
        }
        return digits;
    }
}
