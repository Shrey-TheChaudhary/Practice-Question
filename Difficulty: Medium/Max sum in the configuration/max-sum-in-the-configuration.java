class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += (i*arr[i]);
        }
        int i=1;
        while(i<n)
        {   int min_sum = 0;
            int first = arr[n-1];
            for(int j=n-1;j>0;j--)
            {
                arr[j] = arr[j-1];
            }
            arr[0] = first;
            for(int k=0;k<n;k++)
             {
                min_sum += (k*arr[k]);
             }
             sum = Math.max(sum,min_sum);
            i++;
        }
        return sum;
        
    }
}

