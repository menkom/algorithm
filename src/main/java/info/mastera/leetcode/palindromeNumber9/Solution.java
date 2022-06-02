package info.mastera.leetcode.palindromeNumber9;

/**
 * 9. Palindrome Number
 * Easy
 * <p>
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int currentValue = x;
        while (currentValue != 0) {
            result = result * 10 + currentValue % 10;
            currentValue = currentValue / 10;
        }
        return x == result;
    }
}
