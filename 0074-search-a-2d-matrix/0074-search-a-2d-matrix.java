class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int low=0,high=m-1;
        while(low<n && high>=0)
        {
            if(matrix[low][high]==target)
                return true;
            
            else if(matrix[low][high]>target)
                high--;
            else
                low++;
        }
        return false;
    }
}
