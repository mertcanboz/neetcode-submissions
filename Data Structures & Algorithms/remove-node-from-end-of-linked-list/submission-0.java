/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i=1; i<n; i++) {
            end = end.next;
        }
        ListNode prev = new ListNode();
        prev.next = head;
        while (end.next != null) {
            end = end.next;
            prev = prev.next;
        }
        if (prev.next == head) return head.next;
        prev.next = prev.next.next;
        return head;
    }
}
