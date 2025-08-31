class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int left =0;
        int right = arr.length-1;
        int maxWater = 0;
        while(left<right){
            int width = right-left;
            int height = Math.min(arr[left],arr[right]);
            int currentWater = width*height;
            maxWater = Math.max(maxWater,currentWater);
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return maxWater;
    }
}