/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 */

// @lc code=start
/**
 * // This is MountainArray's API interface. // You should not implement it, or
 * speculate about its implementation interface MountainArray { public int
 * get(int index) {} public int length() {} }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        // find peek by binarySearch
        int peakIndex = findMountainTop(mountainArr, 0, len - 1);
        if (mountainArr.get(peakIndex) == target) {
            return peakIndex;
        }

        // find target in asc array
        int res = findAscendArray(mountainArr, 0, peakIndex - 1, target);
        if (res != -1) {
            return res;
        }
        // find target in desc array
        return findDescendArray(mountainArr, peakIndex + 1, len - 1, target);
    }

    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 下一轮搜索区间 [mid + 1,right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    private int findAscendArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                // 下一轮搜索区间 [mid+1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }

        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    private int findDescendArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间[left, mid]
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }
}
// @lc code=end
