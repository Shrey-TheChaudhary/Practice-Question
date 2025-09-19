class Solution {
    public int minParentheses(String s) {
        // code here
        Stack<Character> st = new Stack<Character>();
        for(char ch : s.toCharArray())
        {
            if(ch == ')'){
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }
                else{
                st.push(ch);
            }
            }
            else{
                st.push(ch);
            }
        }
        return st.size();
    }
}