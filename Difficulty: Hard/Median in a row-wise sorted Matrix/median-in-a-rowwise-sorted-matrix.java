class Solution {
    public int median(int[][] mat) {
        // code here
        int a=0;
        int arr[]=new int[mat.length*mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                arr[a++]=mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[(a)/2];
    }
}