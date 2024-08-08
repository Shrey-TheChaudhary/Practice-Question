class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[] directions = {0, 1, 0, -1, 0};
        int[][] res = new int[rows * cols][2];
        
        int j = 0, n = 0, idx = 0;
        res[idx][0] = rStart;
        res[idx++][1] = cStart;
        
        while (idx != rows * cols)
        {
            for (int i = 0; i < n / 2 + 1; i++) {
                rStart += directions[j];
                cStart += directions[j + 1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) 
                {
                    res[idx][0] = rStart;
                    res[idx++][1] = cStart;
                }
            }
            n++;
            j = (j + 1) % 4;
        }
        return res;
    }
}