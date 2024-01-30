class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
