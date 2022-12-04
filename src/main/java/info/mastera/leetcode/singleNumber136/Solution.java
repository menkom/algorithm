package info.mastera.leetcode.singleNumber136;

import java.util.HashSet;

/**
 * 136. Single Number
 * Easy
 * 12.3K
 * 463
 * Companies
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class Solution {

    public int singleNumber1(int[] nums) {
        var repeats = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (repeats.contains(nums[i])) {
                repeats.remove(nums[i]);
            } else {
                repeats.add(nums[i]);
            }
        }
        return repeats.iterator().next();
    }

    //fastest (XOR = Exclusive OR = Addition modulo 2)
    // https://en.wikipedia.org/wiki/Exclusive_or
    // 0ˆ0=0
    // aˆa=0
    // aˆbˆa=b
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
