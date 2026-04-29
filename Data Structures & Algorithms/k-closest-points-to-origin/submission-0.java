class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(euclideanDistance(b), euclideanDistance(a)));
        for (int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            int[] point = maxHeap.poll();
            result[i] = point;
        }
        return result;
    }

    private static double euclideanDistance(int[] a) {
        return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
    }
}
