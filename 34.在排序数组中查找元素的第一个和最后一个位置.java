/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {

        return searchRangeByBinarySearch(nums, target);
    }

    public int[] searchRangeByWhile(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int fromIndex = -1;
        int endIndex = -1;
        if (nums.length == 0)
            return new int[] { -1, -1 };

        while (low < nums.length && nums[low] < target) {
            low++;
        }
        while (high >= 0 && nums[high] > target) {
            high--;
        }

        if (low < nums.length && nums[low] == target)
            fromIndex = low;
        if (high >= 0 && nums[high] == target)
            endIndex = high;
        return new int[] { fromIndex, endIndex };
    }

    public int[] searchRangeByBinarySearch(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;

    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

}
// @lc code=end
