/*
 * @lc app=leetcode.cn id=234 lang=cpp
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    bool isPalindrome(ListNode *head)
    {
        ListNode *slowp = head, *fastp = head, *revp = nullptr;
        while (fastp && fastp->next)
        {
            fastp = fastp->next->next;
            ListNode *tmp = slowp->next;
            slowp->next = revp;
            revp = slowp;
            slowp = tmp;
        }
        if (fastp)
            slowp = slowp->next;
        while (slowp && revp)
        {
            if (slowp->val != revp->val)
                return false;
            slowp = slowp->next;
            revp = revp->next;
        }
        return true;
    }
};
// @lc code=end
