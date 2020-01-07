/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 876. 链表的中间结点 快慢指针法
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null ) return head;
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}