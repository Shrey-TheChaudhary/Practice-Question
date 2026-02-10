class Solution {
    public int kokoEat(int[] arr, int k) {
       
        int l = 1;
         int r = 0;
         for(int bb : arr){
             r = Math.max(r,bb);
         }
         int ans = r;
         while(l<=r){
             int m = l+(r-l)/2;
             int h = 0;
             for(int bb : arr){
                 h += (bb+m-1)/m;
             }if(h<=k){
                 ans = m;
                 r = m - 1;
             }else{
                 l = m+ 1;
             }
         }
         return ans;
    }
}