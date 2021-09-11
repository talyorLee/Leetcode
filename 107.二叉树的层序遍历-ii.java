/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {

            // 当前这一层遍历的节点集合
            List<Integer> curList = new ArrayList<>();

            // 特别注意：每一次只能处理上一轮入队列的的元素，
            // 所以要将上一轮入队列的元素个数先存一下
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var curNode = queue.poll();
                curList.add(curNode.val);
                // 处理每一个元素都一样，都要考虑一下左右子树
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            list.add(0, curList);

        }

        return list;
    }
}
// @lc code=end
