class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        int f=nums[0];
        int s=nums[1];
        int th=nums[2];
        
        if(f+s<=th)
            return "none";
        if(f==s && s==th)
            return "equilateral";
        
        if(f==s ||s==th||f==th)
            return "isosceles";
        
       else
            return "scalene";
    }
}