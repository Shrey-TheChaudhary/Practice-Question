class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                st.push(i);
            else if(s.charAt(i) == ')')
            {
                st.pop();
                if(st.empty())
                    st.push(i);
                else
                    n = Math.max(n, i - st.peek());
            }
        }
        return n;
    }
}
