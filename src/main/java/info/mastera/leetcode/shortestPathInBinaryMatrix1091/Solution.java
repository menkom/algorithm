package info.mastera.leetcode.shortestPathInBinaryMatrix1091;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 * Medium
 * <p>
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * <p>
 * The length of a clear path is the number of visited cells of this path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        if (grid.length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }

        boolean[][] visited = new boolean[grid.length][grid.length];
        Queue<int[]> currentQueue = new ArrayDeque<>();
        currentQueue.add(new int[]{0, 0});
        visited[0][0] = true;

        int path = 0;
        while (!currentQueue.isEmpty()) {
            path++;
            int currentLevelLength = currentQueue.size();
            for (int i = 0; i < currentLevelLength; i++) {
                var nextCell = currentQueue.poll();

                if (nextCell[0] == grid.length - 1 && nextCell[1] == grid.length - 1) {
                    return path;
                }

                for (int x = nextCell[0] - 1; x <= nextCell[0] + 1; x++) {
                    for (int y = nextCell[1] - 1; y <= nextCell[1] + 1; y++) {
                        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid.length - 1 || grid[x][y] == 1 || visited[x][y] || (x == nextCell[0] && y == nextCell[1])) {
                            continue;
                        }
                        visited[x][y] = true;
                        currentQueue.add(new int[]{x, y});
                    }
                }

            }
        }

        return -1;
    }
}
