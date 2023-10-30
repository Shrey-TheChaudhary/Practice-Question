class Solution {
    // O(n)
//      public static int findDays(int[] weights, int cap) {
//         int days = 1; //First day.
//         int load = 0;
//         int n = weights.length; //size of array.
//         for (int i = 0; i < n; i++) {
//             if (load + weights[i] > cap) {
//                 days += 1; //move to next day
//                 load = weights[i]; //load the weight.
//             } else {
//                 //load the weight on the same day.
//                 load += weights[i];
//             }
//         }
//         return days;
//     }

//     public static int leastWeightCapacity(int[] weights, int d) {
//         //Find the maximum and the summation:
//         int low = Integer.MIN_VALUE, high = 0;
//         for (int i = 0; i < weights.length; i++) {
//             high += weights[i];
//             low = Math.max(low, weights[i]);
//         }

//         while (low <= high) {
//             int mid = (low + high) / 2;
//             int numberOfDays = findDays(weights, mid);
//             if (numberOfDays <= d) {
//                 //eliminate right half
//                 high = mid - 1;
//             } else {
//                 //eliminate left half
//                 low = mid + 1;
//             }
//         }
//         return low;
//     }
     public int shipWithinDays(int[] weights, int days) {
         //O(logn)
        int low=0;
        int high=0;
        for(int i:weights)
        {
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(capacity(weights,days,mid))     
                high=mid-1;
            
            else
                low=mid+1;
            
        }
        return low;
    }

    public boolean capacity(int[] weights,int days,int minw){
        int countday=1;
        int w=0;
        for(int i=0;i<weights.length;i++)
        {
            if(w+weights[i]<=minw){
                w+=weights[i];
            }
            else{
                countday++;
                w=weights[i];
            }
        }
        if(countday>days)
            return false;
        
        return true;
    }
}