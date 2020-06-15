/*
 * @lc app=leetcode.cn id=413 lang=cpp
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution
{
public:
    int numberOfArithmeticSlices(vector<int> &A)
    {
        if (A.size() == 0)
        {
            return 0;
        }
        int n = A.size();
        vector<int> dp(n,0);
        for (int i = 2; i < n; i++)
        {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
            {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp)
        {
            total += cnt;
        }
        return total;
    }
};
// @lc code=end
