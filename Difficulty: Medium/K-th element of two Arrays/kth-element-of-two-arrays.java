//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

      // code here
class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int i=0,j=0,idx=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
                idx++;
                if(idx==k) return arr1[i];
                i++;
            }else{
                idx++;
                if(idx==k) return arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            idx++;
            if(idx==k) return arr1[i];
            i++;
        }
        while(j<arr2.length){
            idx++;
            if(idx==k) return arr2[j];
            j++;
        }
        return -1;
    }
}
  