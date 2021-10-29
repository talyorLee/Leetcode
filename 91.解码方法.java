import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        var list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "26");

        int pre = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int res = 0;
            if (list.contains(s.charAt(i))) {
                int t = cur;
                cur = pre + cur;
                pre = t;
            }

        }
        return 0;
    }
}
// @lc code=end
