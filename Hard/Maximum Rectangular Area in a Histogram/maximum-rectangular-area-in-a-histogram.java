//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends



class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        ArrayDeque<Integer> s=new  ArrayDeque<Integer>();
        long res=0;
         for(int i=0;i<n;i++)
         {
             while(!s.isEmpty() && hist[s.peek()]>=hist[i])
             {
                 int tp=(int)s.pop();
                 long curr=hist[tp]*(s.isEmpty()?i:(i-s.peek()-1));
                 res=Math.max(res,curr);
              }
             s.push(i);
         }
         while(!s.isEmpty())
         {
             int tp=(int)s.pop();
             long curr=hist[tp] *(s.isEmpty()?n:(n-s.peek()-1));
              res=Math.max(res,curr);
         }
        
    return res;
    }
        
}