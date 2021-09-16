/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int j = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[j] && nums[i] == nums[j - 1]) {
                continue;

            } else {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
// @lc code=end
