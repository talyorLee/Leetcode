import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int j = 0;
        for (int i : pushed) {
            stack.addLast(i);
            while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                stack.removeLast();
                j++;
            }

        }
        return stack.isEmpty();

    }
}
// @lc code=end
