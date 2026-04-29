class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int size = 0;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        addToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
            size++;
            if (size > capacity) {
                prune();
            }
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void addToFront(Node node) {
        Node first = head.next;
        node.next = first;
        node.prev = head;
        head.next = node;
        first.prev = node;
    }

    private void prune() {
        Node node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;
        map.remove(node.key);
    }
}
