//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int solve(int i, int m){
        if(i==0)
            return 1;
              if(m==0)
            return 0;
            
        int take=solve(i-1,m/2);
        int notTake=solve(i,m-1);
        
        return take+notTake;  
        }
        
   static  int numberSequence(int m, int n)
   {
        return solve(n,m);
    }
    
}