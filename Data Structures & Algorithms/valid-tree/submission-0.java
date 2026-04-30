class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int from = edge[0];
            int to   = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        Set<Integer> seen = new HashSet<>();
        if (!dfs(0, -1, seen, adj)) {
            return false;
        }

        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> seen, List<List<Integer>> adj) {
        if (seen.contains(node))
            return false;

        seen.add(node);
        for (int neighbor: adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (!dfs(neighbor, node, seen, adj))
                return false;
        }
        return true;
    }
}
