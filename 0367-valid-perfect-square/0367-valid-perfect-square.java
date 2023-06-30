class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        if(num==1) return true;
       
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            double val = (num*1.0)/(mid*(1.0));
            if(mid == val) 
                return true;
            else if(mid<val) 
                low = mid + 1;
            else high = mid-1;
        }
        return false;
    }
}