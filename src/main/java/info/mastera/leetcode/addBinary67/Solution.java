package info.mastera.leetcode.addBinary67;

/**
 * 67. Add Binary
 * Easy
 * Topics
 * Companies
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int extra = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || extra != 0) {
            int temp = 0;
            if (i >= 0) {
                temp += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                temp += b.charAt(j) - '0';
                j--;
            }
            if (extra == 1) {
                temp++;
            }
            result.append(temp % 2);
            extra = (temp / 2);
        }
        return result.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }

        final int max = Math.max(a.length(), b.length()) - 1;
        int i = 0;

        StringBuilder result = new StringBuilder();
        char extra = '0';
        while (i <= max) {
            if (i < a.length() && i < b.length()) {
                String temp = add(a.charAt(a.length() - 1 - i), b.charAt(b.length() - 1 - i), extra);
                result.append(temp.charAt(temp.length() - 1));
                extra = temp.length() == 1 ? '0' : '1';
            } else {
                if (i < a.length()) {
                    String temp = add(a.charAt(a.length() - 1 - i), extra);
                    result.append(temp.charAt(temp.length() - 1));
                    extra = temp.length() == 1 ? '0' : '1';
                } else {
                    String temp = add(b.charAt(b.length() - 1 - i), extra);
                    result.append(temp.charAt(temp.length() - 1));
                    extra = temp.length() == 1 ? '0' : '1';
                }
            }
            i++;
        }
        if (extra == '1') {
            result.append("1");
        }

        return result.toString();
    }

    public String addBinary1(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }

        final int max = Math.max(a.length(), b.length()) - 1;
        int i = 0;

        StringBuilder result = new StringBuilder();
        char extra = '0';
        while (i <= max) {
            if (i < a.length() && i < b.length()) {
                String temp = add(a.charAt(a.length() - 1 - i), b.charAt(b.length() - 1 - i), extra);
                result.insert(0, temp.charAt(temp.length() - 1));
                extra = temp.length() == 1 ? '0' : '1';
            } else {
                if (i < a.length()) {
                    String temp = add(a.charAt(a.length() - 1 - i), extra);
                    result.insert(0, temp.charAt(temp.length() - 1));
                    extra = temp.length() == 1 ? '0' : '1';
                } else {
                    String temp = add(b.charAt(b.length() - 1 - i), extra);
                    result.insert(0, temp.charAt(temp.length() - 1));
                    extra = temp.length() == 1 ? '0' : '1';
                }
            }
            i++;
        }
        if (extra == '1') {
            result.insert(0, "1");
        }

        return result.toString();
    }

    private String add(char a, char b, char c) {
        if (a == '0') {
            return add(b, c);
        }
        if (b == '0') {
            return add(a, c);
        }
        if (c == '0') {
            return add(a, b);
        }
        return "11";
    }

    private String add(char a, char b) {
        if (a == '0') {
            return String.valueOf(b);
        }
        if (b == '0') {
            return String.valueOf(a);
        }
        return "10";
    }
}
