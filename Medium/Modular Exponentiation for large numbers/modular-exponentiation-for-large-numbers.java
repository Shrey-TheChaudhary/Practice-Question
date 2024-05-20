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
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
public long PowMod(long x, long n, long m)
{
    if (m == 1) return 0;  // Since any number mod 1 is 0
    long result = 1;
    x = x % m;  // Handle the case when x >= m

    while (n > 0)
    {
        // If n is odd, multiply x with the result
        if ((n & 1) == 1)
        {
            result = (result * x) % m;
        }

        // n must be even now
        n = n >> 1;  // Divide n by 2
        x = (x * x) % m;  // Square x and reduce modulo m
    }

    return result;
}
}