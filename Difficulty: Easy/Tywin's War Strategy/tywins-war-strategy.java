class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
         int res[]=new int[arr.length];
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            res[i]=k-arr[i]%k;
            if(res[i]==k)
            {
                res[i]=Integer.MAX_VALUE;
                c++;
            }
        }
        if((arr.length+1)/2<=c)
        return 0;
        int s=0;
        Arrays.sort(res);
        int i=0;
        while((arr.length+1)/2>c)
        {
            s+=res[i];
            i++;
            c++;
        }
        return s;
    }
}