class Solution {
    public boolean isPowerOfThree(int n) {
        
        // while(n>=3){
        //     if(n%3!=0) return false;
        //     n/=3;
        // }
        // return n==1;
        
         return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}