class Solution {
    
    //O(n)
    public int findKthPositive(int[] arr, int k) {
         for (int i = 0; i < arr.length; i++) 
         {
            if (arr[i] <= k)
                k++; //shifting k
            else 
                break;
        }
        return k;
    }
}