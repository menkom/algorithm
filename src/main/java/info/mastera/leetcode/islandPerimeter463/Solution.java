package info.mastera.leetcode.islandPerimeter463;

/**
 * 463. Island Perimeter
 * Easy
 * 5.3K
 * 261
 * Companies
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 */
public class Solution {

    static class Island {

        final int[][] grid;

        public Island(int[][] grid) {
            this.grid = grid;
        }

        public int getPerimeter() {
            int value = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    value += getPerimeter(i, j);
                }
            }
            return value;
        }

        private int getPerimeter(int row, int col) {
            if (grid[row][col] == 0) {
                return 0;
            }
            int value = 4;
            if (row > 0 && grid[row - 1][col] == 1) {
                value -= 2;
            }
            if (col > 0 && grid[row][col - 1] == 1) {
                value -= 2;
            }
            return value;
        }

        private int getPerimeter1(int row, int col) {
            int value = 0;
            if (row == 0) {
                value++;
            } else {
                if (grid[row - 1][col] == 0) {
                    value++;
                }
            }

            if (col == 0) {
                value++;
            } else {
                if (grid[row][col - 1] == 0) {
                    value++;
                }
            }

            if (row == grid.length - 1) {
                value++;
            } else {
                if (grid[row + 1][col] == 0) {
                    value++;
                }
            }

            if (col == grid[row].length - 1) {
                value++;
            } else {
                if (grid[row][col + 1] == 0) {
                    value++;
                }
            }
            return value;
        }
    }

    public int islandPerimeter1(int[][] grid) {
        return new Island(grid).getPerimeter();
    }

    public int islandPerimeter(int[][] grid) {
        int value = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    value += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        value -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        value -= 2;
                    }
                }
            }
        }
        return value;
    }
}
