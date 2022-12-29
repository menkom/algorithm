package info.mastera.leetcode.intersectionOfTwoArrays349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays
 * Easy
 * 4.1K
 * 2.1K
 * Companies
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> source1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();
        for (int value : nums2) {
            //noinspection RedundantCollectionOperation
            if (source1.contains(value) && !result.contains(value)) {
                result.add(value);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
