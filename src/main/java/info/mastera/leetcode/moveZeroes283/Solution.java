package info.mastera.leetcode.moveZeroes283;

/**
 * 283. Move Zeroes
 * Easy
 * 12.2K
 * 303
 * Companies
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if(nums.length<2){
            return;
        }
        int shiftIndexToInsert = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                shiftIndexToInsert++;
            } else {
                nums[i - shiftIndexToInsert] = nums[i];
            }
        }
        for (int i = nums.length - shiftIndexToInsert; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
