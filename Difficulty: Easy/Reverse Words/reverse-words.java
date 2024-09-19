//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
       Stack<String> st=new Stack<>();
       int i=0;
       String s="";
       while(i<str.length())
       {
           if(str.charAt(i)=='.')
           {
               st.push(s);
               st.push(".");
               s="";
           }
           else
                s=s+str.charAt(i);
            i++;
       }
       while(st.isEmpty()==false)
       {
           s+=st.pop();
       }
       return s;
    }
}

