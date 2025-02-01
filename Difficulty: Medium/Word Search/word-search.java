//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i,j,0,word,mat,vis)) return true;
            }
        }
        return false;
    }
    
    static boolean dfs(int i,int j,int s,String word,char[][] mat,boolean[][] vis){
        if(s==word.length()) return true;
        if(word.charAt(s)!=mat[i][j]) return false;
        vis[i][j]=true;
        int[] dir={0,1,0,-1,0};
        int n=mat.length;
        int m=mat[0].length;
        for(int d=0;d<4;d++){
            int nI=dir[d]+i;
            int nJ=dir[d+1]+j;
            if(isValid(nI,nJ,n,m) && !vis[nI][nJ]){
                if(dfs(nI,nJ,s+1,word,mat,vis)) return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
    
    static boolean isValid(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}