class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.offerLast(val);
        minStack.offerLast(minStack.isEmpty() ? val : Math.min(minStack.peekLast(), val));
    }
    
    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}
