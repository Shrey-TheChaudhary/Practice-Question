class Solution {
    public int subarraySum(int[] arr) {
        // code here
       int  n=arr.length;
       int result=0;
        for(int i=0;i<n;i++)
        
        {
            int a=(i+1)*(n-i);
              result+=a*arr[i];
        }
        return result;
    }
}