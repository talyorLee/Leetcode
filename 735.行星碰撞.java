import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : asteroids) {
            if (i > 0) {
                stack.addLast(i);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < Math.abs(i)) {
                    stack.removeLast();
                }
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.addLast(i);
                }
                if (stack.peekLast() == Math.abs(i)) {
                    stack.removeLast();
                }
            }
        }
        int[] res = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[j--] = stack.removeLast();
        }
        return res;
    }
}
// @lc code=end
