package info.mastera.leetcode.longestCommonPrefix14;

/**
 * 14. Longest Common Prefix
 * Easy
 * 12.7K
 * 3.8K
 * Companies
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class Solution {

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        var prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            var str = strs[i];
            int prefixLength = 0;
            for (int j = 0; j < Math.min(str.length(), prefix.length()); j++) {
                if (prefix.charAt(j) == str.charAt(j)) {
                    prefixLength++;
                } else {
                    break;
                }
            }
            if (prefixLength == 0) {
                return "";
            } else {
                prefix = str.substring(0, prefixLength);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2Slow(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        var prefix = strs[0];
        for (String str : strs) {
            int prefixLength = 0;
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) == str.charAt(j)) {
                    prefixLength++;
                } else {
                    break;
                }
            }
            if (prefixLength == 0) {
                return "";
            } else {
                prefix = str.substring(0, prefixLength);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3Fastest(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        var prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            var str = strs[i];
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int length = strs[0].length();
        for (int index = 0; index < length; index++) {
            char ch = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length() || ch != strs[j].charAt(index)) {
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }

    public String longestCommonPrefixTheWorth(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = "";
        int length = strs[0].length();
        for (int index = 0; index < length; index++) {
            char ch = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length() || ch != strs[j].charAt(index)) {
                    return result;
                }
            }
            result += ch;
        }
        return result;
    }
}
