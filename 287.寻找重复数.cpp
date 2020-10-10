/*
 * @lc app=leetcode.cn id=287 lang=cpp
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution
{
public:
    int findDuplicate(vector<int> &nums)
    {
        int l = 1, h = nums.size() - 1;
        while (l < h)
        {
            int mid = l + ((h - l) >> 1);
            int cnt = 0;
            for (int i = 0; i < nums.size(); i++)
            {
                if (nums[i] <= mid)
                    cnt++;
            }
            if (cnt > mid)
                h = mid ;
            else
                l = mid + 1;

        }
        return l;
    }
};
// @lc code=end
