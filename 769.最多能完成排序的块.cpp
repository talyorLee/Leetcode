/*
 * @lc app=leetcode.cn id=769 lang=cpp
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution
{
public:
    int maxChunksToSorted(vector<int> &arr)
    {
        if (arr.size() == 0)
            return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.size(); i++)
        {
            right = max(right, arr[i]);
            if (right == i)
                ret++;
        }
        return ret;
    }
};
// @lc code=end
