class Solution {
    public boolean isPowerOfFour(int n) {
        // return (Math.log10(n) / Math.log10(4)) % 1 == 0;
        
        while(n>=4){
            if(n%4!=0) 
                return false;
            n/=4;
        }
        return n==1;
    }
}