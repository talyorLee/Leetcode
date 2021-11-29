import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // 误区：题目中虽说只有一个重复的数字 但并没有说这个数字只会出现两次

        if (nums.length == 0)
            return 0;
        var i = 0;
        while (i < nums.length) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    var midVariable = nums[i];
                    nums[i] = nums[midVariable - 1];
                    nums[midVariable - 1] = midVariable;

                }
            }
            i++;
        }
        return 0;

    }
}
// @lc code=end
