class Solution {
    
    public int findmaxcol(int mat[][],int n,int col)
    {
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i = 0 ;i<n;i++)
        {
            if(max < mat[i][col]){
                max=mat[i][col];
                index=i;
            }
            
        }
        return index;
    }
    
    
    
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int n = mat.length;
        int m =mat[0].length;
       int low=0,high =m-1;
       
       while(low <= high)
       {
           int mid = low + (high-low)/2;
           
          int row= findmaxcol(mat,n,mid);
          
          int left = mid-1>=0?mat[row][mid-1]:Integer.MIN_VALUE;
          
          int right = mid +1<m?mat[row][mid+1]:Integer.MIN_VALUE;
          
          if(left <= mat[row][mid] && right <= mat[row][mid])
                return new ArrayList<>(Arrays.asList(row, mid));
                
          else if(left > mat[row][mid] )
            high = mid-1;
            
          else 
                low = mid+1;
       }
       return new ArrayList<>(Arrays.asList(-1, -1));
    }
}