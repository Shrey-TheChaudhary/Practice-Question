//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public int nCr(int n, int r) {
        
        double ans=1;
        int diff=n-r;
        if(n==r || r==0) return 1;
        while(n>1){
              ans=(double)(ans*n)/((r)*(diff));
              if(r>1) r--;
              if(diff>1) diff--;
              n--;
        }
        return (int)Math.round(ans);
        
    }
}