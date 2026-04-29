class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        for (int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        for (int[] pre: prerequisites) {
            int from = pre[1];
            int to = pre[0];
            adj.get(from).add(to);
            inDegrees[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<numCourses; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited.add(course);
            for (int nextCourse: adj.get(course)) {
                inDegrees[nextCourse]--;
                if(inDegrees[nextCourse] == 0)
                    queue.offer(nextCourse);
            }
        }
        for (int inDegree: inDegrees) {
            if (inDegree != 0) return false;
        }
        return true;
    }
}
