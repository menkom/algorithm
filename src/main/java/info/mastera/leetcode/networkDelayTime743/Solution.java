package info.mastera.leetcode.networkDelayTime743;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 743. Network Delay Time
 * Medium
 * <p>
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */
public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adjacencyMatrix = buildAdjacencyMatrix(times, n);
        int[] pathTime = new int[n];
        Arrays.fill(pathTime, Integer.MAX_VALUE);
        pathTime[k - 1] = 0;
        Set<Integer> checked = new HashSet<>(n);

        Integer nextNode = k - 1;
        while (nextNode != null) {
            checked.add(nextNode);
            for (int i = 0; i < n; i++) {
                if (!checked.contains(i) && adjacencyMatrix[nextNode][i] != Integer.MAX_VALUE) {
                    pathTime[i] = Math.min(pathTime[i], pathTime[nextNode] + adjacencyMatrix[nextNode][i]);
                }
            }
            nextNode = findNext(pathTime, checked);
        }
        int delayTime = 0;
        for (Integer time : pathTime) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            } else {
                delayTime = Math.max(time, delayTime);
            }
        }
        return delayTime;
    }

    private int[][] fill(int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int pos = 0; pos < dimension; pos++) {
                matrix[row][pos] = row == pos ? 0 : Integer.MAX_VALUE;
            }
        }
        return matrix;
    }

    private int[][] buildAdjacencyMatrix(int[][] edges, int dimension) {
        int[][] adjacencyMatrix = fill(dimension);

        for (int[] edge : edges) {
            adjacencyMatrix[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        return adjacencyMatrix;
    }

    private Integer findNext(int[] times, Set<Integer> checked) {
        Integer nextNode = null;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (minTime > times[i] && !checked.contains(i)) {
                nextNode = i;
                minTime = times[i];
            }
        }
        return nextNode;
    }
}
