//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    

  int mod = 1000000007;
  public int padovanSequence(int n)
    {
        //code here
        if(n<3)
            return 1;
            
        int num0 = 1;
        int num1 = 1;
        int num2 = 1;
        int sum=0;
        for(int i=3;i<=n;i++){
            sum =(num0+num1)%mod;
            num0=num1;
            num1=num2;
            num2=sum;
        }
        
        return sum;
            
    }
    
}