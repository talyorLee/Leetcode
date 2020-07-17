/*
 * @lc app=leetcode.cn id=268 lang=cpp
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution
{
public:
    int missingNumber(vector<int> &nums)
    {
        int ret = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.size();
    }
};
// @lc code=end
