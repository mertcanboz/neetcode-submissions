class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t: times) {
            int source = t[0];
            int target = t[1];
            int time = t[2];
            adj.computeIfAbsent(source, s -> new ArrayList<>()).add(new int[]{target, time});
        }
        int delay = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int node = minHeap.peek()[0];
            int time = minHeap.poll()[1];
            if (visited.contains(node)) continue;
            visited.add(node);
            delay = Math.max(delay, time);
            for (int[] t: adj.getOrDefault(node, new ArrayList<>())) {
                int neighbor = t[0];
                int nextTime = t[1];
                minHeap.offer(new int[]{neighbor, time + nextTime});
            }
        }
        return visited.size() == n ? delay : -1;
    }
}
