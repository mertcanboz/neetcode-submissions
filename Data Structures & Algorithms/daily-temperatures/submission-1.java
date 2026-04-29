class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                result[stack.peekLast()] = i - stack.pollLast();
            }
            stack.offerLast(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pollLast()] = 0;
        }
        return result;
    }
}
