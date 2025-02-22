//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==')' && st.isEmpty())
            st.push(i);
            else if(ch=='(')
            st.push(i);
            else if(ch==')' && s.charAt(st.peek())=='(')
            st.pop();
            else
            st.push(i);
        }
        if(st.isEmpty())
        return s.length();
         int res = 0;
        int lastIndex = s.length(); 
        while (!st.isEmpty()) {
            int unmatchedIndex = st.pop();
            res = Math.max(res, lastIndex - unmatchedIndex - 1);
            lastIndex = unmatchedIndex; 
        }
        return Math.max(res, lastIndex);
    }
}