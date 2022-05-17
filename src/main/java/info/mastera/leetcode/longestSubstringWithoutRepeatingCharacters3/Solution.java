package info.mastera.leetcode.longestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> previousLetterPosition = new HashMap<>();
        int maxLength = 0;
        int startSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            if (previousLetterPosition.containsKey(s.charAt(i))) {
                int previousPosition = previousLetterPosition.get(s.charAt(i));
                if (previousPosition < startSubstring) {
                    maxLength = Math.max(maxLength, i - startSubstring + 1);
                } else {
                    maxLength = Math.max(maxLength, i - startSubstring);
                    startSubstring = previousLetterPosition.get(s.charAt(i)) + 1;
                }
            } else {
                maxLength = Math.max(maxLength, i - startSubstring + 1);
            }
            previousLetterPosition.put(s.charAt(i), i);
        }
        return maxLength;
    }
}
