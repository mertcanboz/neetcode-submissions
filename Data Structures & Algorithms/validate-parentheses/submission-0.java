class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) return false;
                if      (stack.peekLast() == '{' && c == '}') stack.pollLast();
                else if (stack.peekLast() == '[' && c == ']') stack.pollLast();
                else if (stack.peekLast() == '(' && c == ')') stack.pollLast();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
