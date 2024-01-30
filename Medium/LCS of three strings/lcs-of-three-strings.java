//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    Integer dp [][][];
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        dp= new Integer [A.length()+1][B.length()+1][C.length()+1];
        
        return helper(0,0,0,A,B,C);
        
    }
    int helper(int ind1 ,int ind2 , int ind3, String a , String b , String c)
    {
        if(ind1>=a.length()||ind2>=b.length()||ind3>=c.length())return 0;
        if(dp[ind1][ind2][ind3]!=null)return dp[ind1][ind2][ind3];
         if (a.charAt(ind1) == b.charAt(ind2)&&b.charAt(ind2)==c.charAt(ind3))
            return dp[ind1][ind2][ind3]=1 + helper(ind1+1,ind2+1,ind3+1,a,b,c);
            int max = Integer.MIN_VALUE;
          
              max=Math.max(max ,helper(ind1+1,ind2,ind3,a,b,c));
               max=Math.max(max ,helper(ind1,ind2+1,ind3,a,b,c));
               max=Math.max(max ,helper(ind1,ind2,ind3+1,a,b,c));
               max=Math.max(max ,helper(ind1+1,ind2+1,ind3,a,b,c));
               max=Math.max(max ,helper(ind1,ind2+1,ind3+1,a,b,c));
               max=Math.max(max ,helper(ind1+1,ind2,ind3+1,a,b,c));
                return dp[ind1][ind2][ind3]= max;
    }
}