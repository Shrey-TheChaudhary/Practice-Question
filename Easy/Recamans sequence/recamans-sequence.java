//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> seq = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();
        seq.add(0);
        s.add(0);
        int i =1;
        while(i < n) {
            int prev = seq.get(i - 1);
            int next = prev - i;
            if (next < 0 || s.contains(next)) {
                next = prev + i;
            }
            seq.add(next);
            s.add(next);
            i++;
        }
        return seq;
    }
}