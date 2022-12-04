package info.mastera.leetcode.pascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Easy
 * 8.6K
 * 283
 * Companies
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            result.add(generate(result.get(i - 1)));
        }
        return result;
    }

    public List<Integer> generateII2(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            result.add(generate(result.get(i - 1)));
        }
        return result.get(rowIndex);
    }

    // each item can be calculated using previous C[k,i] = C[k,i-1]*(k-i+1)/i
    public List<Integer> generateII(int rowIndex) {
        List<Integer> result = new ArrayList<>(5);
        result.add(1);
        for (int i = 1; i < rowIndex; i++) {
            result.add((int) ((long /*multiply can get outside int range*/) result.get(i - 1) * (rowIndex - i + 1) / i));
        }
        if (rowIndex > 0) {
            result.add(1);
        }
        return result;
    }

    List<Integer> generate(List<Integer> source) {
        List<Integer> result = new ArrayList<>(source.size() + 1);
        result.add(1);
        for (int i = 1; i < source.size(); i++) {
            result.add(source.get(i - 1) + source.get(i));
        }
        result.add(1);
        return result;
    }
}
