class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int n = arr.length;
        int i=0,j=n-1;
        while(i<=j){
            int m = i + (j-i)/2;
            if(arr[m]==k)return m;
            if(arr[m]>k)j=m-1;
            else i=m+1;
        }
        return i;
    }
};