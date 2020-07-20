/*
 * @lc app=leetcode.cn id=435 lang=cpp
 *
 * [435] 无重叠区间
 */

// @lc code=start
#include<algorithm>
class Solution
{
public:
    static bool cmp(vector<int> &a , vector<int> &b)
    {
        return a[1]<b[1];
    }
    int eraseOverlapIntervals(vector<vector<int>> &intervals)
    {
        if (intervals.size() == 0)
        {
            return 0;
        }
        sort(intervals.begin(),intervals.end(),cmp);
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.size(); i++)
        {
            if (intervals[i][0] < end)
            {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.size() - cnt;
    }
};
// @lc code=end
