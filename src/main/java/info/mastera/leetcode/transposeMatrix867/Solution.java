package info.mastera.leetcode.transposeMatrix867;

/**
 * 867. Transpose Matrix
 * Easy
 * <p>
 * Given a 2D integer array matrix, return the transpose of matrix.
 * <p>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */
public class Solution {

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                result[y][x] = matrix[x][y];
            }
        }
        return result;
    }
}
