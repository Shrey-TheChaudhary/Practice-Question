class Solution {
    public int numSpecial (int[][] nums) {
        int result = 0;
        int [] columns = new int [nums[0].length];
        for (int i = 0; i < nums.length; i ++) {
            int ones_in_the_row = 0;
            int column = 0;
            for (int j = 0; j < nums[i].length; j ++) {
                if (nums[i][j] == 1) {
                    ones_in_the_row ++;
                    if (ones_in_the_row == 1) {
                        columns[j] = columns[j] == 0 ? 1 : 2;
                        column = j;
                    }
                    else {
                        columns[column] = 2;
                        columns[j] = 2;
                    }
                }
            }

        }
        for (int column : columns) {
            result += (column == 1 ? 1 : 0);
        }
        return result;
    }
}