import java.util.HashSet;

import javax.management.openmbean.ArrayType;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result1 = new HashSet<>();
        HashSet<Integer> result2 = new HashSet<>();
        for (Integer integer : nums1) {
            result1.add(integer);
        }
        for (Integer integer : nums2) {
            if (result1.contains(integer)) {
                result2.add(integer);
            }
        }
        int[] res = new int[result2.size()];
        int j = 0;
        for (int i : result2) {
            res[j++] = i;
        }
        return res;

    }
}
// @lc code=end
