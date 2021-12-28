/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {

        if (inLeft > inRight || postLeft > postRight)
            return null;

        TreeNode root = new TreeNode(postorder[postRight]);
        int pivot = inLeft;
        while (inorder[pivot] != postorder[postRight]) {
            pivot++;
        }
        root.left = buildTree(inorder, postorder, inLeft, pivot - 1, postLeft, postLeft + pivot - inLeft - 1);
        root.right = buildTree(inorder, postorder, pivot + 1, inRight, postLeft + pivot - inLeft, postRight - 1);
        return root;

    }
}
// @lc code=end
