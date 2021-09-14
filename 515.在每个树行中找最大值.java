import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {

            // 当前这一层遍历的节点集合
            var res = Integer.MIN_VALUE;

            // 特别注意：每一次只能处理上一轮入队列的的元素，
            // 所以要将上一轮入队列的元素个数先存一下
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var curNode = queue.poll();
                res = Math.max(curNode.val, res);
                // 处理每一个元素都一样，都要考虑一下左右子树
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            list.add(res);

        }

        return list;
    }
}
// @lc code=end
