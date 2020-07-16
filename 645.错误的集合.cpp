/*
 * @lc app=leetcode.cn id=645 lang=cpp
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution
{
public:
    vector<int> findErrorNums(vector<int> &nums)
    {
        for (size_t i = 0; i < nums.size(); i++)
        {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1])
            {
                swap(nums[i], nums[nums[i] - 1]);
            }
        }
        vector<int> res;
        for (size_t i = 0; i < nums.size(); i++)
        {
            if (nums[i] != i + 1)
            {
                res.push_back(nums[i]);
                res.push_back(i + 1);
            }
        }
        return res;
    }
};
// @lc code=end
