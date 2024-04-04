//Striver

class Solution {
    public int findMin(int[] nums) 
    {
       int low = 0,high=nums.length-1,ans=Integer.MAX_VALUE;
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            //search space is already sorted then nums[low] will always be the minimum in that search space:
            
            if (nums[low] <= nums[high])
            {
                ans = Math.min(ans, nums[low]);
                break;
            }

            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                // keep the minimum & Eliminate left half:
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            else //if right part is sorted:
            {
                // keep the minimum & Eliminate right half:
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
    
    //-*-METHOD 2-*-*   little more time taking than above
    
//     int low = 0, high = arr.length - 1;
//         int ans = Integer.MAX_VALUE;
//         while (low <= high) {
//             int mid = (low + high) / 2;

//             //if left part is sorted:
//             if (arr[low] <= arr[mid]) {
//                 // keep the minimum:
//                 ans = Math.min(ans, arr[low]);

//                 // Eliminate left half:
//                 low = mid + 1;

//             } else { //if right part is sorted:

//                 // keep the minimum:
//                 ans = Math.min(ans, arr[mid]);

//                 // Eliminate right half:
//                 high = mid - 1;
//             }
//         }
//         return ans;
//     }
}