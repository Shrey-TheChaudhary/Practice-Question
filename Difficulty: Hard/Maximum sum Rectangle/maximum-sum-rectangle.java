class Solution {
    public int maxRectSum(int mat[][]) {
    int n = mat.length;
    if (n == 0) return 0;
    int m = mat[0].length;
    int maxSum = Integer.MIN_VALUE;

   
    int[] temp = new int[n];

   
    for (int left = 0; left < m; left++) {
     
        Arrays.fill(temp, 0);

      
        for (int right = left; right < m; right++) {
           
            for (int i = 0; i < n; i++) {
                temp[i] += mat[i][right];
            }

           
            int currMax = temp[0];
            int currSum = temp[0];
            for (int i = 1; i < n; i++) {
                currSum = Math.max(temp[i], currSum + temp[i]);
                currMax = Math.max(currMax, currSum);
            }

            
            maxSum = Math.max(maxSum, currMax);
        }
    }

    return maxSum;
}
};