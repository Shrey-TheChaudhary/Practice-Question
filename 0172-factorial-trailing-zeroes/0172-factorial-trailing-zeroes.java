class Solution {
    // public int trailingZeroes(int n) {
    //     int res = 0;
    //     for(int i = 5;i<=n;i=i*5){
    //         res = res+n/i;
    //     }
    //     return res;
    // }
    public int trailingZeroes(int n) {
    int count = 0;

    while(n > 0) {
        n /= 5;
        count += n;
    }

    return count;
}
}