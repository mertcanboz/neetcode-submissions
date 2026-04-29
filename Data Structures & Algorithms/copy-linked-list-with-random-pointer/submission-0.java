/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;

        while (ptr != null) {
            Node nodeClone;
            if (!map.containsKey(ptr)) {
                nodeClone = new Node(ptr.val);
                map.put(ptr, nodeClone);
            }
            nodeClone = map.get(ptr);

            if (ptr.next != null) {
                Node nextClone = map.computeIfAbsent(ptr.next, a -> new Node(a.val));
                nodeClone.next = nextClone;
            }
            if (ptr.random != null) {
                nodeClone.random = map.computeIfAbsent(ptr.random, a -> new Node(a.val));
            }
            
            ptr = ptr.next;
        }

        return map.get(head);
    }
}
