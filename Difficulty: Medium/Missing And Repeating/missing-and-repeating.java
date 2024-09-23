//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        
        int[]ans=new int[2];
        Arrays.sort(arr);

//CALCULATING THE REPEATING ELEMENT:


        for(int i=1;i<arr.length;i++){
            int k=i-1;
            if(arr[i]==arr[k]){
                ans[0]=arr[i];
                break;
            }
            else{
                continue;
            }
        }

//CALCULATING THE MISSING ELEMENT:

        long n=arr.length;
        long expectedSum = (long) (n * (n + 1)) / 2; 
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }
        ans[1] = (int) (expectedSum - (actualSum - ans[0]));

        
        return ans;
    }
}