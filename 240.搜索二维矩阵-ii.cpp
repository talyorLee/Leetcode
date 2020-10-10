/*
 * @lc app=leetcode.cn id=240 lang=cpp
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        if (matrix.size() == 0)
        {
            return false;
        }

        int row = matrix.size();
        int col = matrix[0].size();
        int m = row - 1;
        int n = 0;
        while (m >= 0 && n < col)
        {
            if (matrix[m][n] == target)
            {
                return true;
            }
            else if (matrix[m][n] < target)
            {
                n++;
            }
            else
            {
                m--;
            }
        }
        return false;
    }
};
// @lc code=end
