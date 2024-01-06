//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        int[] p=new int[(int)(b+1)];
        for(int i=2;i<=b;i++){
            if(p[i]==0){
                for(int j=i;j<=b;j+=i){
                    p[j]=i;
                }
            }
        }
        int ans=0;
        for(int i=(int)(a);i<=b;i++){
            int x=i;
            while(x>1){
                x/=p[x];
                ans++;
            }
        }
        return ans;
    }
}