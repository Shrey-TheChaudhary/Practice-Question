class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
         for(int i =0; i< arr.length; i++){
            if(arr[i] <= k)
            k++;
            else 
            break ;
        }
        return k;
    }
}