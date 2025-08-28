class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int n=arr.length;
        int left=0, right=0;
        int zeros=0;
        int result=0;
        while(right<n){
            if(arr[right]==0){
                zeros++;
            }
            if(zeros>k){
                while(zeros>k){
                    if(arr[left]==0){
                        zeros--;
                    }
                    left++;
                }
            }
            right++;
            result=Math.max(result, right-left);
        }
        return result;
    }
}