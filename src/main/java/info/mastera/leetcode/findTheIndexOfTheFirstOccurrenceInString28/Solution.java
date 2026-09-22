package info.mastera.leetcode.findTheIndexOfTheFirstOccurrenceInString28;

/**
 *
 28. Find the Index of the First Occurrence in a String
 Easy

 Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "sadbutsad", needle = "sad"
 Output: 0
 Explanation: "sad" occurs at index 0 and 6.
 The first occurrence is at index 0, so we return 0.
 Example 2:

 Input: haystack = "leetcode", needle = "leeto"
 Output: -1
 Explanation: "leeto" did not occur in "leetcode", so we return -1.


 Constraints:

 1 <= haystack.length, needle.length <= 104
 haystack and needle consist of only lowercase English characters.
 */
public class Solution {
    /**
     * Delegates to the JDK intrinsic, which is a naive scan with a vectorised search for the first
     * character: faster than {@link #strStr0} on short inputs, but O(n * m) on repetitive ones.
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * алгоритм Кнута — Морриса — Пратта, поиск подстроки в строке за гарантированные O(n + m).
     * Суть в одной фразе: он никогда не возвращается назад по тексту.
     */
    public int strStr0(String haystack, String needle) {
        int[] prefixLengths = buildPrefixLengths(needle);
        int haystackIndex = 0;
        int needleIndex = 0;

        while (haystackIndex < haystack.length()) {
            if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                haystackIndex++;
                needleIndex++;

                if (needleIndex == needle.length()) {
                    return haystackIndex - needleIndex;
                }
            } else if (needleIndex > 0) {
                needleIndex = prefixLengths[needleIndex - 1];
            } else {
                haystackIndex++;
            }
        }

        return -1;
    }

    private int[] buildPrefixLengths(String pattern) {
        int[] prefixLengths = new int[pattern.length()];
        int prefixLength = 0;
        int patternIndex = 1;

        while (patternIndex < pattern.length()) {
            if (pattern.charAt(patternIndex) == pattern.charAt(prefixLength)) {
                prefixLengths[patternIndex] = prefixLength + 1;
                prefixLength++;
                patternIndex++;
            } else if (prefixLength > 0) {
                prefixLength = prefixLengths[prefixLength - 1];
            } else {
                patternIndex++;
            }
        }

        return prefixLengths;
    }
}
