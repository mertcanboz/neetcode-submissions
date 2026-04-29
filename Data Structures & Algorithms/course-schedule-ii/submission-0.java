class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p: prerequisites) {
            int src = p[1];
            int target = p[0];
            adj.get(src).add(target);
            inDegrees[target]++;
        }

        for (int i=0; i<numCourses; i++){
            if (inDegrees[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            for (int next: adj.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) queue.offer(next);
            }
        }
        for (int degree: inDegrees) {
            if (degree != 0) return new int[]{};
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);  // auto-unboxing Integer -> int
        }
        return res;
    }
}
