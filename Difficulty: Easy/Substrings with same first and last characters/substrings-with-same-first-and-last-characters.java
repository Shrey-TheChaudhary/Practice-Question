//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
       int n=s.length();
       int count=0;
       HashMap<Character,Integer>ans=new HashMap<>();
       for(int i=0;i<n;i++){
           char ch=s.charAt(i);
           ans.put(ch,ans.getOrDefault(ch,0)+1);
           count+=ans.get(ch);
       }
        return count;
    }
}