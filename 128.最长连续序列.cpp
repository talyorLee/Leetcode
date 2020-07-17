/*
 * @lc app=leetcode.cn id=128 lang=cpp
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.size() == 0)
        {
            return 0;
        }
        if (nums.size() == 1)
        {
            return 1;
        }
        map<int, int> m_map;
        for (size_t i = 0; i < nums.size(); i++)
        {
            m_map[nums[i]]++;
        }
        int max_length = 0;
        int lastnum,curnum,lastfr,curfr;
        auto it = m_map.begin();
        lastnum = it->first;
        int length = 1;
        it++;
        while(it!=m_map.end()){
           
            curnum = it->first;
            //cout << lastnum << " " << curnum << endl;
            if(curnum-1==lastnum){
                length += 1;
            }
            else
            {
                max_length = max(max_length,length);
                length = 1;
            }
            lastnum = curnum;
            it++;
            //cout << length << endl;
        }
        return max(max_length,length);
    }
};
// @lc code=end

