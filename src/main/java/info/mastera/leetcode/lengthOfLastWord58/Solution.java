package info.mastera.leetcode.lengthOfLastWord58;

/**
 * 58. Length of Last Word
 * Easy
 * Topics
 * Companies
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int tempLength = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                if (tempLength != 0) {
                    return tempLength;
                }
            } else {
                tempLength++;
            }
        }
        return tempLength;
    }

    public int lengthOfLastWord2(String s) {
        int lastLength = 0;
        int tempLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (tempLength != 0) {
                    lastLength = tempLength;
                    tempLength = 0;
                }
            } else {
                tempLength++;
            }
        }
        return tempLength == 0 ? lastLength : tempLength;
    }

    public int lengthOfLastWord1(String s) {
        String withoutSpaces = s.trim().replaceAll(" +", " ");
        String[] words = withoutSpaces.split(" ");
        return words[words.length - 1].length();
    }
}
