class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int cost = 0;
        for (int i=0; i<n; i++) {

            int u = -1;
            for (int j=0; j<n; j++) {
                if (!inMST[j] && (u == -1 || dist[u] > dist[j]))
                    u = j;
            }

            inMST[u] = true;
            cost += dist[u];

            for (int j=0; j<n; j++) {
                if (!inMST[j]) {
                    int d = manhattanDistance(points[u], points[j]);
                    dist[j] = Math.min(dist[j], d);
                }
            }
        }

        return cost;
    }

    private int manhattanDistance(int[] p0, int[] p1) {
        return Math.abs(p0[0]-p1[0]) + Math.abs(p0[1]-p1[1]);
    }
}
