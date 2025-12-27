class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Count how many numbers are <= mid
            int count = countLessEqual(mat, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessEqual(int[][] mat, int mid) {
        int count = 0;
        int n = mat.length;
        int row = n - 1; // Start from bottom-left
        int col = 0;

        while (row >= 0 && col < n) {
            if (mat[row][col] <= mid) {
                // Since columns are sorted, if mat[row][col] <= mid,
                // then all elements above it in this column are also <= mid.
                count += (row + 1);
                col++;
            } else {
                // If the element is too large, move up to a smaller value
                row--;
            }
        }
        return count;
    }
}