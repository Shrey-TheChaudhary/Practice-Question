//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        
        // for all rows
        for(int i = 0; i < arr.length; i++){
            if(isRowPalindrome(arr[i])){
                return i + " " + "R";
            }
        }
        
        // for all cols
        for(int j = 0; j < arr[0].length; j++){
            if(isColPalindrome(arr, j)){
                return j + " " + "C";
            }
        }
        
        return "-1";
    }
    
    boolean isRowPalindrome(int row[]){
        
        int left = 0, right = row.length - 1;
        
        while(left <= right){
            if(row[left] != row[right]){
                return false;
            }
            left++; right--;
        }
        
        return true;
    }
    
    boolean isColPalindrome(int arr[][], int j){
        
        int left = 0, right = arr.length - 1;
        
        while(left <= right){
            if(arr[left][j] != arr[right][j]){
                return false;
            }
            left++; right--;
        }
        
        return true;
    }
}