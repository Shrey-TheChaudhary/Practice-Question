// class Solution {
//     public int hIndex(int[] citations) {
//          Arrays.sort(citations);  [0 1 3 5 6]
//         int hIndex=0;
//         int n = citations.length;  5
//         for(int i=0;i<n;i++)
//         {
//             if(citations[i]>=n-i) 0>=5 1>=4 3>=3 5>=2 6>=1
//             {
//  hIndex = Math.max(hIndex,n-i); 3 
//             }
//         }
//         return hIndex;
//     }
// }

class Solution {
    public int hIndex(int[] c) {
        int low=0 , high = c.length;
        while(low < high)
        {
            int mid = (low+high+1)/2;
            int cnt=0;
            for(int i=0 ; i<c.length ; i++)
            { 
            if(c[i] >= mid) 
            cnt++;
            }
            if(cnt >= mid) 
            low = mid;
            else 
             high=mid-1;
        }
        return low;
    }
}