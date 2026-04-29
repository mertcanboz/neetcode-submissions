class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i=0; i<heights.length+1; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekLast()] > height) {
                int h = heights[stack.pollLast()];
                int w = stack.isEmpty() ? i : (i-stack.peekLast()-1);
                result = Math.max(result, w * h);
            }
            stack.offerLast(i);
        }
        return result;
    }
}
