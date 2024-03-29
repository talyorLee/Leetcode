/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var dummyNode = new ListNode(-1);
        var curNode = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                curNode = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                curNode = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            curNode.next = l1;
        }
        if (l2 != null) {
            curNode.next = l2;
        }

        return dummyNode.next;
    }
}
// @lc code=end
