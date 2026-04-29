class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) maxHeap.offer(stone);
        while (!maxHeap.isEmpty()) {
            int stone1 = maxHeap.poll();
            if (maxHeap.isEmpty()) return stone1;
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) maxHeap.offer(stone1-stone2);
        }
        return 0;
    }
}
