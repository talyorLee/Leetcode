/*
 * @lc app=leetcode.cn id=404 lang=cpp
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    int sum = 0;
    bool isLeaf(TreeNode *node)
    {
        if (node == nullptr)
            return false;
        return node->left == nullptr && node->right == nullptr;
    }
    int sumOfLeftLeaves(TreeNode *root)
    {
        if (!root)
        {
            return 0;
        }

        if (isLeaf(root->left))
            return root->left->val + sumOfLeftLeaves(root->right);
        return sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
    }
};
// @lc code=end
