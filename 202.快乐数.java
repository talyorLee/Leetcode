import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
}
// @lc code=end
