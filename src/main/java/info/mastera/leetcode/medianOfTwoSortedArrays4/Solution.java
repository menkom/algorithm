package info.mastera.leetcode.medianOfTwoSortedArrays4;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        int middle1 = (nums1.length + nums2.length) / 2;
        int middle2 = -1;
        // is even
        if ((nums1.length + nums2.length & 1) == 0) {
            middle2 = middle1 + 1;
        }
        //it is not necessary to merge whole arrays but till median only. This is the key
        int[] merged = new int[middle2 == -1 ? middle1 + 1 : middle2];
        while (i1 + i2 < merged.length) {
            if (i2 == nums2.length || i1 < nums1.length && nums1[i1] < nums2[i2]) {
                merged[i1 + i2] = nums1[i1];
                i1++;
            } else {
                merged[i1 + i2] = nums2[i2];
                i2++;
            }
        }
        if (middle2 == -1) {
            return merged[merged.length - 1];
        }
        return (double) (merged[merged.length - 2] + merged[merged.length - 1]) / 2;
    }
}
