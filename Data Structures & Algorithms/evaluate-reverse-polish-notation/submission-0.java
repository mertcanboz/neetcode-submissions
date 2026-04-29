class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t: tokens) {
            if ("+".equals(t)) {
                int operand2 = stack.pollLast();
                int operand1 = stack.pollLast();
                stack.offerLast(operand1 + operand2);
            } else if ("-".equals(t)) {
                int operand2 = stack.pollLast();
                int operand1 = stack.pollLast();
                stack.offerLast(operand1 - operand2);
            } else if ("/".equals(t)) {
                int operand2 = stack.pollLast();
                int operand1 = stack.pollLast();
                stack.offerLast(operand1 / operand2);
            } else if ("*".equals(t)) {
                int operand2 = stack.pollLast();
                int operand1 = stack.pollLast();
                stack.offerLast(operand1 * operand2);
            } else {
                stack.offerLast(Integer.parseInt(t));
            }
        }
        return stack.pollLast();
    }
}
