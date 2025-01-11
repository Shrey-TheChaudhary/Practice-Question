//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character,Integer> mp=new HashMap<>();
        int l=0,r=0,maxi=0;
        while(r<s.length()){
            char c=s.charAt(r);
            if(mp.get(c)!=null){
                l=Math.max(mp.get(c)+1,l);
            }
           // System.out.println(r+" "+c+" --"+mp.get(c)+"->"+l);
            mp.put(s.charAt(r),r);
            maxi=Math.max(r-l+1,maxi);
            r++;
        }
        return maxi;
    }
}