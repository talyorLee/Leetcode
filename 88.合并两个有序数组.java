/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        merge2(nums1, m, nums2, n);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        var length = nums1.length;
        for (int i = 0; i < m; i++) {
            nums1[length - 1 - i] = nums1[m - 1 - i];
        }

        int i = length - m;
        int j = 0;
        int len = nums2.length;
        int k = 0;
        while (i < length && j < len) {
            if (nums1[i] < nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < length) {
            nums1[k++] = nums1[i++];
        }
        while (j < len) {
            nums1[k++] = nums2[j++];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int r1 = m - 1;
        int r2 = n - 1;
        for (int k = len - 1; k >= 0; k--) {
            // 题中，m+n>=1 故 r1 r2不可能同时为-1
            if (r1 == -1) {
                nums1[k] = nums2[r2--];
            } else if (r2 == -1) {
                nums1[k] = nums1[r1--];
            } else if (nums1[r1] >= nums2[r2]) {
                nums1[k] = nums1[r1--];
            } else {
                nums1[k] = nums2[r2--];
            }
        }
    }
}
// @lc code=end
