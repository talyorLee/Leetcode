/*
 * @lc app=leetcode.cn id=24 lang=cpp
 *
 * [24] 两两交换链表中的节点
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
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head && head ->next)
        {
            ListNode *p =head->next->next;
            ListNode *q =head->next;
            ListNode *r = swapPairs(p); 
            q->next =head;
            head->next = r;
            return q;
        }
        else
        {
            return head;
        }
        
        
    }
};
// @lc code=end

