/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {
                // if nums[0] less than target,it means 0-mid is in the first array;
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    // if nums[0] greater than target , it means target appears in the second sorted
                    // array (mid+1,r]
                    // if target > nums[mid] , it means target in the first array(mid+1,r]
                    l = mid + 1;
                }
            } else {
                // it means the pos mid is in the second array.
                // if target <= nums[end] and nums[mid] < target , target in the second array
                // (mid+1,nums.length)
                // if target <= nums[end] and nums[mid] > target , target in the second array
                // (l,mid-1]

                // if target > nums[end], target in the first array (l,mid-1]

                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

}
// @lc code=end
