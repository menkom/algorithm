package info.mastera.leetcode.PermutationsII47;

import java.util.*;

/**
 * 47. Permutations II
 * Medium
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 8
 *     -10 <= nums[i] <= 10
 */
public class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return permutation(nums);
    }

    private static List<List<Integer>> permutation(int... nums) {
        if (nums.length == 1) {
            return List.of(new ArrayList<>(List.of(nums[0])));
        } else {
            List<List<Integer>> result = new ArrayList<>();
            Set<Integer> usedValues = new HashSet<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (!usedValues.contains(nums[i])) {
                    usedValues.add(nums[i]);
                    int[] subNums = Arrays.copyOf(Arrays.copyOfRange(nums, 0, i), nums.length-1);
                    System.arraycopy(Arrays.copyOfRange(nums, i+1, nums.length), 0, subNums, i, nums.length - i - 1);
                    List<List<Integer>> subResult = permutation(subNums);
                    for (List<Integer> sub : subResult) {
                        sub.add(nums[i]);
                    }
                    result.addAll(subResult);
                }
            }
            return result;
        }
    }
}
