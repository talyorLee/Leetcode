/*
 * @lc app=leetcode.cn id=82 lang=cpp
 *
 * [82] 删除排序链表中的重复元素 II
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
    ListNode *deleteDuplicates(ListNode *head)
    {
        if (!head || !head->next)
            return head;
        ListNode *dummy = new ListNode(0);
        ListNode *tail = dummy;
        int flag = true; // should the current head be added ?
        while (head)
        {
            while (head && head->next && head->val == head->next->val)
            {
                flag = false; // finds duplicate, set it to false
                head = head->next;
            }
            if (flag) // if should be added
            {
                tail->next = head;
                tail = tail->next;
            }
            head = head->next;
            flag = true; // time for a new head value, set flag back to true
        }
        tail->next = nullptr; // Don't forget this... I did..
        return dummy->next;
    }
};
// @lc code=end
