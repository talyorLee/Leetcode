/*
 * @lc app=leetcode.cn id=260 lang=cpp
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution
{
public:
    vector<int> singleNumber(vector<int> &nums)
    {
        int r = 0, n = nums.size(), i = 0, last = 0;
        vector<int> ret(2, 0);

        for (i = 0; i < n; ++i)
            r ^= nums[i];

        last = r & (-r);
        for (i = 0; i < n; ++i)
        {
            if ((last & nums[i]) != 0)
                ret[0] ^= nums[i];
            else
                ret[1] ^= nums[i];
        }

        return ret;
    }
};
// @lc code=end
