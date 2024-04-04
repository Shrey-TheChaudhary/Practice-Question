//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static long sumSubstrings(String s){
        long mod = (long)1e9+7;
        long m = 1;
        long ans = 0;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            long d = s.charAt(i)-'0';
            long sum = (i+1)*m*d;
            ans += sum;
            m*=10;
            m++;
            m%=mod;
            ans %=mod;
        }
        return ans;
    }
}