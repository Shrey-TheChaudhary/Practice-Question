class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
         Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(rows.contains(i) || cols.contains(j)){
                    mat[i][j]=0;
                }
            }
        }
    }
}