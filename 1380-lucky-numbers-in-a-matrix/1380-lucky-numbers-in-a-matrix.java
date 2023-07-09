class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<Integer>();

         for (int i=0; i<n; i++)
         {
             int small = Integer.MAX_VALUE;
             int index = -1;
            for (int j=0; j<m; j++)
            {
                if(matrix[i][j] < small)
                {
                    small = matrix[i][j];
                    index = j;
                }
            }
             int large=Integer.MIN_VALUE;
             for(int row=0; row<n; row++){
                 large=Math.max(large,matrix[row][index]);
             }
             if(large==small) 
                 ans.add(small);
        }

        return ans;
    }
}