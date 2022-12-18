package info.mastera.leetcode.majorityElement169;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Easy
 * 13K
 * 420
 * Companies
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Solution {

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> found = new HashMap<>();
        int middle = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (found.containsKey(nums[i])) {
                Integer value = found.get(nums[i]);
                if (value + 1 > middle) {
                    return nums[i];
                } else {
                    found.put(nums[i], value + 1);
                }
            } else {
                found.put(nums[i], 1);
            }
        }
        return 1;
    }

    public int majorityElement(int[] nums) {
        int count = 0, result = nums[0];
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (num != result) {
                count--;
            } else {
                count++;
            }
        }
        return result;
    }
}
