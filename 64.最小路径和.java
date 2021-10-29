/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        int result = 0;
        // remember update result
        for (int i = 0; i < m; i++) {
            paths[i][0] = result + grid[i][0];
            result = paths[i][0];
        }
        result = 0;
        for (int i = 0; i < n; i++) {
            paths[0][i] = result + grid[0][i];
            result = paths[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = Math.min(paths[i - 1][j], paths[i][j - 1]) + grid[i][j];
            }
        }
        return paths[m - 1][n - 1];
    }
}
// @lc code=end
