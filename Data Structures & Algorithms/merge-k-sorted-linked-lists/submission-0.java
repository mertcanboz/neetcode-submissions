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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode l: lists) {
            if (l != null) pq.offer(l);
        }

        while (!pq.isEmpty()) {
            ptr.next = pq.poll();
            ptr = ptr.next;
            if (ptr.next != null) pq.offer(ptr.next);
        }
        return dummy.next;
    }
}
