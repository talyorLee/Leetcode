/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        var num = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < len1)
            num[k++] = nums1[i++];
        while (j < len2)
            num[k++] = nums2[j++];

        return k % 2 == 0 ? (num[k / 2] + num[(k / 2) - 1]) / 2.0 : num[k / 2];
    }
}
// @lc code=end
