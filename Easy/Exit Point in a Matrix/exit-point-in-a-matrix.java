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
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    
    class Pair{
        int r,c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        
        int dx[]={1,0,-1,0};
        int dy[]={0,-1,0,1};
        int count=3; //count of 1's
        
        Queue<Pair> q=new ArrayDeque<Pair>();
        q.add(new Pair(0,0));
        
        while(!q.isEmpty()){
            
            Pair curr=q.poll();
            if(matrix[curr.r][curr.c]==1){
                count=(count+1)%4;
                matrix[curr.r][curr.c]=0;
            }
            
            int r=curr.r+dx[count];
            int c=curr.c+dy[count];
            if(r<0 || c<0 || r>=n || c>=m){
                return new int[]{curr.r,curr.c};
            }

            q.add(new Pair(r,c));
            
        }
        
        return new int[]{};
        
    }
}