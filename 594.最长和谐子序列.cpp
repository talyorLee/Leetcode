/*
 * @lc app=leetcode.cn id=594 lang=cpp
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution
{
public:
    int findLHS(vector<int> &nums)
    {
        if (nums.size() < 2)
        {
            return 0;
        }
        map<int, int> m_map;
        for (size_t i = 0; i < nums.size(); i++)
        {
            m_map[nums[i]]++;
        }
        if (m_map.size() == 1)
        {
            return 0;
        }

        int max_length = 0;
        int lastnum,curnum,lastfr,curfr;
        auto it = m_map.begin();
        lastfr = it->second;
        lastnum = it->first;
        it++;
        while(it!=m_map.end()){
            curnum = it->first;
            curfr = it->second;
            if(curnum-1==lastnum){
                max_length = max(max_length,(curfr+lastfr));
            }
            lastnum = curnum;
            lastfr = curfr;
            it++;
        }
        return max_length;
    }
};
// @lc code=end
