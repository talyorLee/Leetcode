/*
 * @lc app=leetcode.cn id=452 lang=cpp
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution
{
public:
    int findMinArrowShots(vector<vector<int>> &points)
    {
        if (points.size() == 0)
        {
            return 0;
        }
        sort(points.begin(), points.end(), cmp);
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < points.size(); i++)
        {
            if (points[i][0] <= end)
            {
                continue;
            }
            end = points[i][1];
            cnt++;
        }
        return cnt;
    }
    static bool cmp(vector<int> a, vector<int> b)
    {
        return a[1] < b[1];
    }
   
};
// @lc code=end
