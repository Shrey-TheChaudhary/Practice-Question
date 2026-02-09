class Solution {
    public int findKRotation(int arr[]) {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            count++;
            if(arr[i] > arr[i + 1]){
                return count;
            }
        }
        return 0;
    }
}