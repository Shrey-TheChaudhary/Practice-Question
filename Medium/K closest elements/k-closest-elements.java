//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        int id1 = findCrossOver(arr,0,n-1,x);
        int id2 = id1+1;
        if(arr[id1]==x) id1--;
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            if(id1>=0 && id2<n){
                int val1 = x-arr[id1], val2 = arr[id2]-x;
                if(val1<val2){
                    ans[i] = arr[id1];
                    id1--;
                }else{
                    ans[i] = arr[id2];
                    id2++;
                }
            }else if(id1>=0){
                ans[i] = arr[id1];
                id1--;
            }else{
                ans[i] = arr[id2];
                id2++;
            }
        }
        return ans;
    }
    private int findCrossOver(int[] arr, int low, int high, int x) {
        if (arr[high] <= x) {
            return high;
        }
        if (arr[low] > x) {
            return low;
        }
        int mid = (low + high) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        } else if (arr[mid] < x) {
            return findCrossOver(arr, mid + 1, high, x);
        }
        return findCrossOver(arr, low, mid - 1, x);
    }
}