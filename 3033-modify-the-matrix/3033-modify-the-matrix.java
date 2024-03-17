class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] maxcolumn = new int[matrix[0].length];
        
        for(int j=0; j<matrix[0].length; j++){
            for(int i=0; i<matrix.length; i++){
                maxcolumn[j] = Math.max(maxcolumn[j], matrix[i][j]);
            }
        }
        
        
        for(int r=0; r<matrix.length; r++){
            for(int c=0; c<matrix[0].length; c++){
                if(matrix[r][c] == -1){
                    matrix[r][c] = maxcolumn[c];
                }
            }
        }
        return matrix;
    }
}