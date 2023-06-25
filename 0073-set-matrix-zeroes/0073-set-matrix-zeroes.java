class Solution {
    public void setZeroes(int[][] matrix) {
/*keep track of rows and columns when ever we encounter 0
and then using stored info we will set all rows and col to 0*/

        HashSet<Integer> row= new HashSet<>();
        HashSet<Integer> col= new HashSet<>();

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

// if set contains i and j we will set all the element to 0

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
                if(row.contains(i) || col.contains(j)) 
                    matrix[i][j]=0;
        }
    }
}