//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
   
    public boolean searchRowMatrix(int[][] mat, int x) {
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++)
        {
            int low=0,high=n-1; 
            if(mat[i][low]<=x && mat[i][high]>=x)
            {
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(mat[i][mid]==x)
                {
                    return true;
                }
                else if(mat[i][mid]<x)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            }
        }
        return false;
    }
}