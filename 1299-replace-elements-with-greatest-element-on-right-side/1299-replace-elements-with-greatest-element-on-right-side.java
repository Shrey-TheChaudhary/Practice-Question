class Solution {
    public int[] replaceElements(int[] arr)
    {
        int n=arr.length;
        int maxx = arr[n-1];
        arr[arr.length-1]=-1;
        for(int i=n-2;i>=0;i--){
            int temp = Math.max(maxx,arr[i]);
            arr[i]=maxx;
            maxx=temp;
        }
        return arr;
    }
}