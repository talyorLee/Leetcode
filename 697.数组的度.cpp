/*
 * @lc app=leetcode.cn id=697 lang=cpp
 *
 * [697] 数组的度
 */

// @lc code=start
#include <map>
#include <vector>
#include <set>
using namespace std;
class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        map<int,pair<int,int>> m_map;
        map<int,int> m_map2;
        for (size_t i = 0; i < nums.size(); i++)
        {
            if (m_map.find(nums[i]) == m_map.end())
            {
                m_map2[nums[i]] = 1;
                m_map[nums[i]] = make_pair(i,i);
            }
            else
            {
                m_map2[nums[i]] = m_map2[nums[i]] + 1;
                m_map[nums[i]].second=i;
            }
        }
        
        int degree = 1;
        int length = 1;
        for (auto i : m_map2)
        {
            if (i.second >degree)
            {
                degree = i.second;
                length = m_map[i.first].second-m_map[i.first].first+1; 
            }
            else if (i.second == degree)
            {
                length = min(length,m_map[i.first].second-m_map[i.first].first+1) ; 

            }    
        }
        return length;
        
        
    }
};
// @lc code=end

