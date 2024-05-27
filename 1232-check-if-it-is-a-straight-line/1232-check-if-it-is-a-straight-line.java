class Solution {
    public boolean checkStraightLine(int[][] nums) {
    if(nums.length<=2) 
        return true;
    int x0= nums[0][0], y0= nums[0][1], x1= nums[1][0], y1=nums[1][1];
 
    for(int i=0;i< nums.length;i++)
    {
           int x2=nums[i][0];
           int y2=nums[i][1];
        
    if( (y0-y1)*(x2-x1) != (y2-y1)*(x0-x1) )
        return false;   
    }
        
        return true;

    }
}