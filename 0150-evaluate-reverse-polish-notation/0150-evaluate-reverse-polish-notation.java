class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token: tokens)
        {
            if("+".equalsIgnoreCase(token))
            {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                token = String.valueOf(b+a);
            }
            if("-".equalsIgnoreCase(token))
            {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                token = String.valueOf(b-a);
            }
            if("*".equalsIgnoreCase(token))
            {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                token = String.valueOf(b*a);
            }
            if("/".equalsIgnoreCase(token))
            {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                token = String.valueOf(b/a);
            }
            stack.add(token);
        }
        return Integer.valueOf(stack.pop());
    }
}