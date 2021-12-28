/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft,
            int inorderRight) {

        if (preorderLeft > preorderRight || inorderLeft > inorderRight)
            return null;
        int rootposition = inorderLeft;
        while (inorder[rootposition] != preorder[preorderLeft]) {
            rootposition++;
        }
        TreeNode node = new TreeNode(preorder[preorderLeft]);
        node.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + rootposition - inorderLeft,
                inorderLeft, rootposition - 1);
        node.right = buildTree(preorder, inorder, preorderLeft + rootposition - inorderLeft + 1, preorderRight,
                rootposition + 1, inorderRight);
        return node;
    }

}
// @lc code=end
