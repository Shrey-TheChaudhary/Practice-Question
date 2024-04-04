// class Solution {
    
//     //Striver
//     public int minEatingSpeed(int[] piles, int h) {
//         int max=0;
//         for(int x:piles)
//             max=Math.max(max,x);
//         int low = 1, high = max;

//         //apply binary search:
//         while (low <= high)
//         {
//             int mid = (low + high) / 2;
//             int totalH = calculateTotalHours(piles, mid);
//             if (totalH <= h) {
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return low;
//     }
//       public static int calculateTotalHours(int[] piles, int h) {
//         int totalH = 0;
//         int n = piles.length;
//         //find total hours:
//         for (int i = 0; i < n; i++) {
//             totalH += Math.ceil((double)(piles[i])/(double)(h));
//         }
//         return totalH;
    
//     }
// }

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);

        while (left < right) {
            int hoursUsed = 0;
            int middle = (right + left) / 2;

            for (int pile : piles) {
                hoursUsed += Math.ceil((double) pile / middle);
            }

            if (hoursUsed <= h) {
                right = middle;
            }   else {
                left = middle + 1;
            }
        }

        return right;
    }
}