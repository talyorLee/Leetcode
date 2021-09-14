/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        var head = new ListNode(-1);
        var cur = head;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            var node = new ListNode(carry % 10);
            cur.next = node;
            cur = node;
            carry = carry / 10;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
// @lc code=end
