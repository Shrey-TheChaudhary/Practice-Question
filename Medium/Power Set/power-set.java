//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> res = new ArrayList<>();
        int n = s.length();

        for(int num = 1; num < (1<<n) ; num++){
            String str = "";
            
            for(int bit = 0; bit<n;bit++){
                if((num & (1<<bit)) != 0 )
                    str += s.charAt(bit);
            }
            res.add(str);
        }
        Collections.sort(res);
        return res;
    }
}