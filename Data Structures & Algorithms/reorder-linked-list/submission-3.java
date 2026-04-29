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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        // reverse the second half!
        ListNode prev = null;
        ListNode ptr2 = slow.next;
        slow.next = null;
        ListNode next = ptr2.next;
        
        
        while (next != null) {
            ListNode temp = next.next;
            ptr2.next = prev;
            next.next = ptr2;

            prev = ptr2;
            ptr2 = next;
            next = temp;
        }
        ListNode ptr1 = head, dummy = new ListNode(0);
        ListNode ptr = dummy;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                ptr.next = ptr1;
                ptr1 = ptr1.next;
                ptr = ptr.next;
            }
            
            if (ptr2 != null) {
                ptr.next = ptr2;
                ptr2 = ptr2.next;
                ptr = ptr.next;
            }
        }
    }
}
