//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findCoverage(int[][] mat) {
         int n = mat.length;
        int m = mat[0].length;
        int sum = 0;
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    for(int z = 0; z <4; z++){
                        int xx = i + x[z];
                        int yy = j + y[z];
                        if(xx >= 0 && xx < n && yy >= 0 && yy < m && mat[xx][yy] == 1){
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }
}