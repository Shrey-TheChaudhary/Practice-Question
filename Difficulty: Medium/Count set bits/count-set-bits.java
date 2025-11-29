class Solution {
    public static int countSetBits(int n) {
       
        int count=0;
        for(int i=0;(1<<i)<=n;i++)
        {
         int cycle=1<<(i+1);
         int full=n/cycle;        //o(logn) Effecient for large Numbers;
         int rem=n%cycle;
         count+=full*(1<<i)+Math.max(0,rem-(1<<i)+1);
        }
        return count;
    }
}