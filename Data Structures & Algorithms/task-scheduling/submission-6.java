class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // Max heap by frequency
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq)
            if (f > 0) maxHeap.offer(f);

        int time = 0;

        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            // Fill one cycle
            while (cycle > 0 && !maxHeap.isEmpty()) {

                int cnt = maxHeap.poll();
                if (cnt > 1) temp.add(cnt - 1);

                time++;
                cycle--;
            }

            // Put remaining tasks back
            for (int t : temp) maxHeap.offer(t);

            // If tasks remain, we must account for idle slots
            if (!maxHeap.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}
