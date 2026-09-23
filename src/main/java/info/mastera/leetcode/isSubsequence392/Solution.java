package info.mastera.leetcode.isSubsequence392;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 
Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int matched = 0;
        for (int j = 0; j < t.length() && matched < s.length(); j++) {
            if (s.charAt(matched) == t.charAt(j)) {
                matched++;
            }
        }
        return matched == s.length();
    }

    public boolean isSubsequenceWithIndexMap(String s, String t) {
        Map<Character, List<Integer>> indicesByChar = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            indicesByChar.computeIfAbsent(c, ignored -> new ArrayList<>()).add(i);
        }

        int lastMatchedIndex = -1;
        Map<Character, Integer> scanFrom = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> indices = indicesByChar.get(c);
            if (indices == null) {
                return false;
            }
            int k = scanFrom.getOrDefault(c, 0);
            while (k < indices.size() && indices.get(k) <= lastMatchedIndex) {
                k++;
            }
            if (k >= indices.size()) {
                return false;
            }
            lastMatchedIndex = indices.get(k);
            scanFrom.put(c, k + 1);
        }
        return true;
    }
}
