package info.mastera.leetcode.triangle120;

import java.util.*;

/**
 * 120. Triangle
 * Medium
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * <p>
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j - 1 < 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i - 1).size()) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + triangle.get(i).get(j));
                }
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        List<List<Integer>> values = new ArrayList<>();
        values.add(List.of(triangle.get(0).get(0)));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j - 1 < 0) {
                    row.add(values.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i - 1).size()) {
                    row.add(values.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    row.add(Math.min(values.get(i - 1).get(j - 1), values.get(i - 1).get(j)) + triangle.get(i).get(j));
                }
            }
            values.add(row);
        }
        return Collections.min(values.get(values.size() - 1));
    }
}
