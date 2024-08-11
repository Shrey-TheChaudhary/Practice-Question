class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for (char c : num.toCharArray()) 
        {
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        for (char c : st) {
            if (ans.length() == 0 && c == '0') 
                continue;
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}