//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String s) {
        Stack<Integer> st=new Stack<>();
          if(s==null ||s.length()<2) 
          return 0;
          int max=0;
          st.push(-1);
          
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(i);
                
            else if(ch==')')
            {
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else
                  max=Math.max(max,i-st.peek());
            }
        }
        return max;
    }
}