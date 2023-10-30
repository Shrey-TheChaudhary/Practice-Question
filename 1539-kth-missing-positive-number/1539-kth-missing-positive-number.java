//Striver
class Solution
{
    
    // //O(n)
    // public int findKthPositive(int[] arr, int k) {
    //      for (int i = 0; i < arr.length; i++) 
    //      {
    //         if (arr[i] <= k)
    //             k++; //shifting k
    //         else 
    //             break;
    //     }
    //     return k;
    // }
    
    public int findKthPositive(int[] arr, int k) 
    {
        //O(logn)
        // index: 0 1 2 3 4
        //array:  2 3 4 7 11
        int low = 0, high = arr.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);//arr[index]-(index+1) are missing
            if (missing < k) 
                low = mid + 1;
             else 
                high = mid - 1;
            
        }
        return k + high + 1;
    }
}