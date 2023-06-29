class Solution {
    public int[] sortedSquares(int[] nums) {
       int pt1 = 0;
       int pt2 = nums.length -1;
       int n = nums.length -1;

       int result[] = new int[n+1];

       while(pt1 <= pt2){
           int a = (int)Math.pow(nums[pt1],2);
           int b = (int)Math.pow(nums[pt2],2);
           if(a > b)
           {
               result[n] = a;
               pt1++;
           }
           else
           {
               result[n] = b;
               pt2--;;
           }

           n--;
       } 

       return result;
    }
}