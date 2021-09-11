/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这一步要特别注意，是一个很容易被忽略的情况
        return (root.left == null || root.right == null) ? Math.max(minDepth(root.left), minDepth(root.right)) + 1
                : Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

}
// @lc code=end
