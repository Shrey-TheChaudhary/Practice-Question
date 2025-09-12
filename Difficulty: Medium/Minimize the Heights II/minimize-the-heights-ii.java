class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int min = arr[0]+k;
        int max = arr[arr.length-1]-k;
        int diff = arr[arr.length-1] - arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i]-k>=0){
                int minh = Math.min(arr[i]-k,min);
                int maxh = Math.max(arr[i-1]+k, max);
                diff = Math.min((maxh-minh),diff);
            }
            
        }
        return diff;
    }
}
