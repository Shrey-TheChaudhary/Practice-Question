class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int arr[] = new int[2];
        int count;
        int maxCount = Integer.MIN_VALUE;
        int maxCountIndex = -1;
        
        for(int i = 0; i < mat.length; i++) 
        {
            count = 0;
            for(int j = 0; j < mat[i].length; j++) 
            {
                if(mat[i][j] == 1) 
                    count++;
            }
            maxCountIndex = count > maxCount ? i : maxCountIndex;
            maxCount = Integer.max(count, maxCount);
        }
        arr[0] = maxCountIndex;
        arr[1] = maxCount;
        return arr;
    }
}