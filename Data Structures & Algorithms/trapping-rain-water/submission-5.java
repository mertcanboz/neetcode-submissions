class Solution {
    public int trap(int[] height) {
        int water = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // store indices, heights are decreasing

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int floor = stack.pollLast();
                if (stack.isEmpty()) continue;
                int left = stack.peekLast();
                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[floor];
                water += w * h;
            }
            stack.offerLast(i);
        }
        return water;
    }
}
