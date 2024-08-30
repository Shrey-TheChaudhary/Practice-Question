//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(0, board, n);
        Collections.sort(ans, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        return ans;
    }
    
    public void solve(int row, int[][] board, int n)
    {
        if(row == n)
        {
            makeBoard(board, n);
            return;
        }
        
        for(int col=0; col<n; col++)
        {
            if(isSafe(row, col, board))
            {
                board[row][col] = 1;
                solve(row+1, board, n);
                board[row][col] = 0;
            }
        }
    }
    
    public boolean isSafe(int row, int col, int[][] board)
    {
        // checking row upwards
        for(int i=0; i<row; i++)
        if(board[i][col] == 1)
        return false;
        
        // checking left diagonal upwards
        int maxLeft = Math.min(row, col);
        for(int i=0; i<=maxLeft; i++)
        if(board[row-i][col-i] == 1)
        return false;
        
        // checking right diagonal upwards
        int maxRight = Math.min(row, board.length-1-col);
        for(int i=0; i<=maxRight; i++)
        if(board[row-i][col+i] == 1)
        return false;
        
        return true;
    }
    
    public void makeBoard(int[][] board, int n)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            if(board[j][i] == 1)
            arr.add(j+1);
        }
        ans.add(arr);
    }
}