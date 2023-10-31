class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n=matrix.length;
//         int m=matrix[0].length;

//         int low=0,high=m-1;
//         while(low<n && high>=0)
//         {
//             if(matrix[low][high]==target)
//                 return true;
            
//             else if(matrix[low][high]>target)
//                 high--;
//             else
//                 low++;
//         }
//         return false;
//     }
    
    //Striver 
     public boolean searchMatrix(int[][] matrix, int target) {
          int n = matrix.length, m = matrix[0].length;
            if (n == 0) 
                return false; 
         
    // Apply binary search:
        int low = 0, high = n * m - 1;
         
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
