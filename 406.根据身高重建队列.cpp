/*
 * @lc app=leetcode.cn id=406 lang=cpp
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution
{
public:
    static bool cmp(vector<int> a, vector<int> b)
    {
        if (a[0] == b[0])
        {
            return a[1] < b[1];
        }
        else
        {
            return a[0] > b[0];
        }
        
    }
    vector<vector<int>> reconstructQueue(vector<vector<int>> &people)
    {
        if (people.size() == 0 || people[0].size() == 0)
        {
            return {};
        }
        sort(people.begin(), people.end(), cmp);

        
        vector<vector<int>> res;
        for (auto p : people)
        {
            res.insert(res.begin() + p[1],p);
            //cout << p[0] << " " << p[1] << endl;
        }
        return res;
    }
};
// @lc code=end
