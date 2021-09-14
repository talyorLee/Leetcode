/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNodeOdd = new ListNode(-1);
        ListNode dummyNodeEven = new ListNode(-1);
        ListNode curOdd = dummyNodeOdd;
        ListNode curEven = dummyNodeEven;
        int count = 0;
        while (head != null) {
            if ((count % 2) == 0) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            count++;
        }
        curOdd.next = dummyNodeEven.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curEven.next = null;
        return dummyNodeOdd.next;
    }
}
// @lc code=end
