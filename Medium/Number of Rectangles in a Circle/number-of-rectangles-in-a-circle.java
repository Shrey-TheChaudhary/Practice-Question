//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int rectanglesInCircle(int r) {
        int d=2*r;
        if(r==1)
        {
            return 1;
        }
        int rectangles=0;
       for(int i=1;i<d;i++)
       {
           int a=i*i;
           for(int j=1;j<d;j++)
           {
               int b=j*j;
             if(a+b<=2*d*r) 
             {
                 rectangles++;
             }
           }
       }
       return rectangles;
    }
};