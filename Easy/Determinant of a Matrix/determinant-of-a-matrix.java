//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution{
    static int determinantOfMatrix(int matrix[][], int n){
        if(n==2){
            return ((matrix[0][0]*matrix[1][1])-(matrix[1][0]*matrix[0][1]));
        }
        if(n==1){
            return matrix[0][0];
        }
        int mat[][]=new int[n-1][n-1];
        int p=0,sum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                 p=matrix[0][i];
            }
            else{
                 p=-matrix[0][i];
            }
            for(int j=1;j<n;j++){
                for(int k=0;k<n;k++){
                    if(k==i){
                        continue;
                    }
                    else if(k>i){
                        mat[j-1][k-1]=matrix[j][k];
                    }
                    else{
                        mat[j-1][k]=matrix[j][k];
                    }
                }
            }
            sum+= p*determinantOfMatrix(mat,n-1);
        }
        return sum;
    }
}