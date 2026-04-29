class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i=0; i<heights.length+1; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekLast()] > height) {
                int h = heights[stack.pollLast()];
                int w = i - (stack.isEmpty() ? 0 : (stack.peekLast() + 1));
                maxArea = Math.max(maxArea, h * w);
            }
            stack.offerLast(i);
        }
        return maxArea;
    }
}
