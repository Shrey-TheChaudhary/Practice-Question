//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int k) {
        // code here
        Stack<Character> st=new Stack<>();
        for(int i=0;i<S.length();i++){
            while(!st.isEmpty() && st.peek()>S.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.add(S.charAt(i));
           
        }
        while(k-->0){
            st.pop();
        }
        if(st.isEmpty())
        return "0";
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop()+"");
        }
        ans=ans.reverse();
        int index=0;
        while(index<ans.length()-1 && ans.charAt(index)=='0'){
            index++;
        }
        return ans.substring(index);
    }
}