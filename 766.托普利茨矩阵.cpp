/*
 * @lc app=leetcode.cn id=766 lang=cpp
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution
{
public:
    bool check(vector<vector<int>>  matrix, int expectValue, int row, int col)
    {
        if (row >= matrix.size() || col >= matrix[0].size())
        {
            return true;
        }
        if (matrix[row][col] != expectValue)
        {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
    bool isToeplitzMatrix(vector<vector<int>> &matrix)
    {
        for (int i = 0; i < matrix[0].size(); i++)
        {
            if (!check(matrix, matrix[0][i], 0, i))
            {
                return false;
            }
        }
        for (int i = 0; i < matrix.size(); i++)
        {
            if (!check(matrix, matrix[i][0], i, 0))
            {
                return false;
            }
        }
        return true;
    }
};
// @lc code=end
