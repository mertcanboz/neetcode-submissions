class Solution {
    public int trap(int[] height) {
        int water = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // store indices, heights are decreasing

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int mid = stack.pollLast(); // bottom of a "valley"

                if (stack.isEmpty()) break; // no left boundary

                int left = stack.peekLast();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[mid];

                if (boundedHeight > 0) {
                    water += width * boundedHeight;
                }
            }
            stack.offerLast(i);
        }
        return water;
    }
}
