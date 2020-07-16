/*
 * @lc app=leetcode.cn id=667 lang=cpp
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution
{
public:
    vector<int> constructArray(int n, int k)
    {
        vector<int> ret(n, 1);
        ret[0] = 1;
        for (int i = 1; i <= k; i++)
        {
            if (i % 2 == 0)
            {
                ret[i] = ret[i - 2] + 1;
            }
            else
            {
                if (i == 1)
                {
                    ret[i] = k + 1;
                }
                else
                {
                    ret[i] = ret[i-2] - 1; 
                }
            }
        }
        for (int i = k + 1; i < n; i++)
        {
            ret[i] = i + 1;
        }
        return ret;
    }
};
// @lc code=end
