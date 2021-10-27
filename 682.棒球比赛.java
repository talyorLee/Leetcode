import java.util.ArrayDeque;
import java.util.Deque;
/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    Deque<Integer> stack = new ArrayDeque<>();
    int result = 0;

    public int calPoints(String[] ops) {
        for (String string : ops) {
            if (string.equals("C")) {
                var num = stack.removeLast();
                result -= num;
            } else if (string.equals("D")) {
                var num = stack.peekLast();
                result += 2 * num;
                stack.addLast(2 * num);
            } else if (string.equals("+")) {
                var num1 = stack.removeLast();
                result += num1;
                var num2 = stack.peekLast();
                result += num2;
                stack.addLast(num1);
                stack.addLast(num1 + num2);
            } else {
                Integer i = Integer.parseInt(string);
                stack.addLast(i);
                result += i;
            }
        }
        return result;

    }
}
// @lc code=end
