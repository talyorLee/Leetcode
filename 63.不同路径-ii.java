/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 当一个点被阻塞，那么需要经过该点才能到的点则无法到达
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                flag = false;
            }

            if (flag == false)
                paths[i][0] = 0;
            else
                paths[i][0] = 1;
        }
        flag = true;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                flag = false;
            }

            if (flag == false)
                paths[0][i] = 0;
            else
                paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i - 1][j] + paths[i][j - 1];

            }
        }
        return paths[m - 1][n - 1];
    }
}
// @lc code=end
