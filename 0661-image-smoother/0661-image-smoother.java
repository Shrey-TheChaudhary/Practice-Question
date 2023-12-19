class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int total_sum = 0;
                int count = 0;

                for (int l = Math.max(0, i-1); l < Math.min(rows, i+2); ++l) {
                    for (int k = Math.max(0, j-1); k < Math.min(cols, j+2); ++k) {
                        total_sum += img[l][k];
                        count += 1;
                    }
                }

                result[i][j] = total_sum / count;
            }
        }

        return result;
    }
}