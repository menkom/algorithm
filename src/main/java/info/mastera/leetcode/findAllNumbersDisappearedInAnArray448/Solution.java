package info.mastera.leetcode.findAllNumbersDisappearedInAnArray448;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 * 7.8K
 * 419
 * Companies
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class Solution {

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> answer = new ArrayList<>(IntStream.range(1, nums.length + 1).boxed().toList());
        for (int i = 0; i < nums.length; i++) {
            if (answer.get(nums[i] - 1) != null) {
                answer.set(nums[i] - 1, null);
            }
        }
        return answer.stream().filter(Objects::nonNull).toList();
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        Integer[] found = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            found[nums[i] - 1] = nums[i] - 1;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < found.length; i++) {
            if (found[i] == null) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int[] found = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            found[nums[i] - 1] = 1;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < found.length; i++) {
            if (found[i] == 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] found = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            found[nums[i] - 1] = 1;
        }
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < found.length; i++) {
            if (found[i] == 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}
