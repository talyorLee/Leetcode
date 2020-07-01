/*
 * @lc app=leetcode.cn id=215 lang=cpp
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //method_1
        // nth_element(nums.begin(), nums.begin() + k - 1, nums.end(), greater<int>());
        // return nums[k - 1];
        
        //method_2
        // partial_sort(nums.begin(), nums.begin() + k, nums.end(), greater<int>());
        // return nums[k - 1];

        //method_3  优先队列

        // priority_queue<int, vector<int>, greater<int>> pq;
        // for (int num : nums) {
        //     pq.push(num);
        //     if (pq.size() > k) {
        //         pq.pop();
        //     }
        // }
        // return pq.top();

        //method_4
        // priority_queue<int> pq(nums.begin(), nums.end());
        // for (int i = 0; i < k - 1; i++) {
        //     pq.pop();
        // }
        // return pq.top();


        // method_5
        // multiset<int> mset;
        // for (int num : nums) {
        //     mset.insert(num);
        //     if (mset.size() > k) {
        //         mset.erase(mset.begin());
        //     }
        // }
        // return *mset.begin();

        // method_6

        // multiset<int, greater<int>> mset(nums.begin(), nums.end());
        // for (int i = 0; i < k - 1; i++) {
        //     mset.erase(mset.begin());
        // }
        // return *mset.begin();
        

        //method_7 partition
        int left = 0, right = nums.size() - 1, kth;
        while (true) {
            int idx = partition(nums, left, right);
            if (idx == k - 1) {
                kth = nums[idx];
                break;
            }
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return kth;
    }
private:
    int partition(vector<int>& nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums[l++], nums[r--]);
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums[left], nums[r]);
        return r;
    }

};
// @lc code=end

