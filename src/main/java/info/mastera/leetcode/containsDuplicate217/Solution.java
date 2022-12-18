package info.mastera.leetcode.containsDuplicate217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 217. Contains Duplicate
 * Easy
 * 7.6K
 * 1.1K
 * Companies
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Solution {

    public boolean containsDuplicate1(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        Set<Integer> found = new HashSet<>();
        for (int num : nums) {
            if (found.contains(num)) {
                return true;
            } else {
                found.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }
}
