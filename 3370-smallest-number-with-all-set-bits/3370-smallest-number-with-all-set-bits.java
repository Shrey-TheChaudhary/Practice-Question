class Solution {
    public int powerOf2(int n){
        int p = 1;
        while(p<n){
            p*=2;
        }
        return p;
    }
    public int smallestNumber(int n) {
        int num = powerOf2(n+1);
        return num-1;
    }
}