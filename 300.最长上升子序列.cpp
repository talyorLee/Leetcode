/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution
{
public:
    int binarySearch(vector<int> vec, int val)
    {
        if (vec.size() == 0)
        {
            return -1;
        }

        int low = 0;
        int high = vec.size() - 1;
       
        while (low <= high)
        {
            int mid = low + ((high - low) >> 1);
            int mid = low + (high - low) >> 1;
        
            //cout << mid  << endl;
            if (vec[mid] >= val)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        if (high == vec.size() - 1)
        {
            return -1;
        }
        return high + 1;
    }
    int lengthOfLIS(vector<int> &nums)
    {
        //method 1
        vector<int> res;
        for (int i = 0; i < nums.size(); i++)
        {
            int pos = binarySearch(res, nums[i]);
            if (pos == -1)
            {
                res.push_back(nums[i]);
            }
            else
            {
                res[pos] = nums[i];
            }
        }
        return res.size();

        //method2
        // if (nums.size() == 0)
        // {
        //     return 0;
        // }

        // vector<int> res(nums.size(), 1);
        // for (size_t i = 1; i < nums.size(); i++)
        // {
        //     for (size_t j = 0; j < i; j++)
        //     {
        //         if (nums[j] < nums[i])
        //         {
        //             res[i] = max(res[i], res[j] + 1);
        //         }
        //     }
        // }
        // return *max_element(res.begin(), res.end());
    }
};
// @lc code=end
