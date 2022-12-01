package info.mastera.leetcode.determineIfStringHalvesAreAlike1704;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 1704. Determine if String Halves Are Alike
 * Easy
 * 835
 * 55
 * Companies
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 * <p>
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 * <p>
 * Return true if a and b are alike. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 * <p>
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 */
public class Solution {

    public boolean halvesAreAlike1(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        var middle = s.length() / 2;
        int a = 0;
        int b = 0;
        for (int i = 0; i < middle; i++) {
            if (vowels.contains(s.charAt(i))) {
                a++;
            }
            if (vowels.contains(s.charAt(s.length() - i - 1))) {
                b++;
            }
        }
        return a == b;
    }

    public boolean halvesAreAlike(String s) {
        var pattern = Pattern.compile("[aeiouAEIOU]");
        var middle = s.length() / 2;
        var a = s.substring(0, middle);
        var aMatcher = pattern.matcher(a);
        var aCount = 0;
        var b = s.substring(middle);
        var bMatcher = pattern.matcher(b);
        var bCount = 0;
        while (aMatcher.find()) {
            aCount++;
        }
        while (bMatcher.find()) {
            bCount++;
        }
        return aCount == bCount;
    }
}
