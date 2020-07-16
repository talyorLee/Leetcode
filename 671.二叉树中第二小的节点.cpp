/*
 * @lc app=leetcode.cn id=671 lang=cpp
 *
 * [671] 二叉树中第二小的节点
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
    int findSecondMinimumValue(TreeNode *root)
    {
        if (root == nullptr)
        {
            return -1;
        }
        else if (root->left == nullptr)
        {
            return -1;
        }
        else
        {
            int leftVal = root->left->val;
            int rightVal = root->right->val;
            if (leftVal == root->val)
                leftVal = findSecondMinimumValue(root->left);
            if (rightVal == root->val)
                rightVal = findSecondMinimumValue(root->right);
            if (leftVal != -1 && rightVal != -1)
                return min(leftVal, rightVal);
            if (leftVal != -1)
                return leftVal;
            return rightVal;
        }
    }
};
// @lc code=end
