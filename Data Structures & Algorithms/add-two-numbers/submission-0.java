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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        
        int carry = 0;
        while (l1 != null && l2 != null) {
            ptr.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ptr.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            ptr = ptr.next;
        }
        while (l2 != null) {
            ptr.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            ptr = ptr.next;
        }
        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
