class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}
