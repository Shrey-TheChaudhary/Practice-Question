class Solution {
    public int largestSubmatrix(int[][] arr) {
         int n = arr.length;
        int m = arr[0].length;

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    arr[i][j] = arr[i-1][j]+1;
                }
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            Arrays.sort(arr[i]);
            for(int j=1; j<=m; j++){
                ans = Math.max(ans,j*arr[i][m-j]);
            }
        }
        return ans;
    }
}