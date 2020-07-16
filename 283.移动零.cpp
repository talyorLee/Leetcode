/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        int idx = 0;
        for (int num : nums)
        {
            if (num != 0)
            {
                nums[idx++] = num;
            }
        }
        while (idx < nums.size())
        {
            nums[idx++] = 0;
        }
    }
};
// @lc code=end
