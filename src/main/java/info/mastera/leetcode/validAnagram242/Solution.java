package info.mastera.leetcode.validAnagram242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * Easy
 * 8K
 * 256
 * Companies
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * <p>
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class Solution {

    static class Anagram {
        private final Map<Character, Integer> content = new HashMap<>();

        public Anagram(String source) {
            for (int i = 0; i < source.length(); i++) {
                var letter = source.charAt(i);
                content.put(letter, content.getOrDefault(letter, 0) + 1);
            }
        }

        private boolean count(char letter) {
            var count = content.get(letter);
            if (count == null || count < 1) {
                return false;
            } else {
                content.put(letter, count - 1);
            }
            return true;
        }

        public boolean isAnagram(String word) {
            for (int i = 0; i < word.length(); i++) {
                if (!count(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return new Anagram(s).isAnagram(t);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var source = s.toCharArray();
        Arrays.sort(source);
        var target = t.toCharArray();
        Arrays.sort(target);
        return new String(source).equals(new String(target));
    }

    public boolean isAnagramBest(String s, String t) {
        var source = s.toCharArray();
        Arrays.sort(source);
        var target = t.toCharArray();
        Arrays.sort(target);
        return Arrays.equals(source, target);
    }

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int n : arr) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
