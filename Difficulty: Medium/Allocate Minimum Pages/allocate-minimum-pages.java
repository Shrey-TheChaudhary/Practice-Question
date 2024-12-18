//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java
class Solution {
    public static int findPages(int[] a, int k) {
        int n=a.length;
        if(n<k)
    return -1;
    
        int sum=0,max=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            max=Math.max(max,a[i]);
        }
        int low=max,high=sum,res=0;
        while(low<=high)
        {
            int mid=low + (high - low) / 2;
            
            if(isfeesible(a,n,k,mid))
            {
                res=mid;
                high=mid-1;
            }
            else
            low=mid+1;
            
        }
        return res;
    }
    public static boolean isfeesible(int a[],int n,int k,int ans)
    {
        int res = 1;
        int sum = 0;
 
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum > ans) {
                res++; 
                sum = a[i]; 
            }
        }
 
        return res <= k;
    }
    }