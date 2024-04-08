class Solution {
    public int countPrimes(int n) {
        int res = 0;
        if(n <= 2)
            return res;
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i = 2; i*i <= n; i++)
        {
            if(isPrime[i])
            {
                for(int j = 2*i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i])
                res++;  
        }
        return res;
    }
}