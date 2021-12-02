import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // key 是 A 和 B 数组分别取一个数可能的和，value 是这个和可能由几个不同的组合
        Map<Integer, Integer> map = new HashMap<>();
        // 计数器
        int res = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -c - d;
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
        }
        return res;
    }
}
// @lc code=end
