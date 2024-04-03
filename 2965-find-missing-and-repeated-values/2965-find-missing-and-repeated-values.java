class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> hs = new HashSet<>();
        int[] ans = new int[2];
        int n = grid.length;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(hs.contains(grid[i][j]))
                    ans[0] = grid[i][j];
                else
                    hs.add(grid[i][j]);
            }
        }

        for(int i=1;i<=n*n;i++)
        {
            if(!hs.contains(i))
            {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}