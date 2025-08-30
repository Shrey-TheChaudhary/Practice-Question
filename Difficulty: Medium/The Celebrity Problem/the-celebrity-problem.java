class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        if(n==1) return 0;
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1)
                {
                    arr[j]++;
                    arr[i]--;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i] == n-1) return i;
        }
        return -1;
    }
}