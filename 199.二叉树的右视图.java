/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
import java.util.ArrayList;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {

            // 当前这一层遍历的节点集合
            TreeNode node = null;

            // 特别注意：每一次只能处理上一轮入队列的的元素，
            // 所以要将上一轮入队列的元素个数先存一下
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                // 处理每一个元素都一样，都要考虑一下左右子树
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(node.val);

        }

        return list;
    }
}
// @lc code=end
