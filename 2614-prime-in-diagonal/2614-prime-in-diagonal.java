class Solution {
    public int diagonalPrime(int[][] nums) {
      int n = nums.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
           if(isprime(nums[i][i]))
              max=Math.max(max,nums[i][i]);
            
            if (i != n - 1 - i) 
              {
               if(isprime(nums[i][n - 1 - i]))
                  max=Math.max(max,nums[i][n - 1 - i]);
            }
                
        }
        
        return max;  
    }
      boolean isprime(int n){
        if(n < 2)  
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) 
                return false;
        }
        return true;
    }
}