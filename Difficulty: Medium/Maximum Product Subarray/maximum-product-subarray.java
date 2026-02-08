class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int ma = arr[0];
        int mi = ma;
        int ans = ma;
        for(int i = 1; i < n; i++){
            if(arr[i] < 0){
               int temp = ma;
               ma = mi;
               mi = temp;
            }
            ma = Math.max(arr[i], arr[i]*ma);
            mi = Math.min(arr[i], arr[i]*mi);
            ans = Math.max(ans, ma);
        }
        
        return ans;
    }
}