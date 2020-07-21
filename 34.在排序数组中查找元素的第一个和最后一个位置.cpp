/*
 * @lc app=leetcode.cn id=34 lang=cpp
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution
{
public:
    int findFirst(vector<int> &nums, int target)
    {
        int l = 0, h = nums.size(); // 注意 h 的初始值
        while (l < h)
        {
            int m = l + (h - l) / 2;
            if (nums[m] >= target)
            {
                h = m;
            }
            else
            {
                l = m + 1;
            }
        }
        return l;
    }
    vector<int> searchRange(vector<int> &nums, int target)
    {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.size() || nums[first] != target)
        {
            return {-1, -1};
        }
        else
        {
            return {first, last};
        }
    }
};
// @lc code=end
