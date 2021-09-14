/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 比 x 小的虚拟头结点
        ListNode dummyNodeL = new ListNode(-1);
        // 大于等于 x 的虚拟头结点
        ListNode dummyNodeR = new ListNode(-1);
        // 用于遍历
        ListNode curL = dummyNodeL;
        // 用于遍历
        ListNode curR = dummyNodeR;
        int val;
        while (head != null) {
            val = head.val;
            if (val < x) {
                curL.next = head;
                curL = curL.next;
            } else {
                curR.next = head;
                curR = curR.next;
            }
            head = head.next;
        }
        curL.next = dummyNodeR.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curR.next = null;
        return dummyNodeL.next;
    }
}
// @lc code=end
