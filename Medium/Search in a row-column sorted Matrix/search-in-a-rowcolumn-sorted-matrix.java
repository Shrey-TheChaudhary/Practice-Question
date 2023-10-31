//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
            if (n == 0) 
                return false; // Empty matrix, no elements to search.
            

            int row = 0, col = m - 1;
        
            while (row < n && col >= 0) 
            {
                if (matrix[row][col] == x) 
                    return true;
                else if (matrix[row][col] < x) 
                    row++;
                else 
                    col--;
                
            }
            return false;
	} 
} 
