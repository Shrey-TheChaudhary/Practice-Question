class Solution {
    public boolean checkPerfectNumber(int num) {
        int count = 1;
        if(num ==1)
            return false;
        

        for(int i=2 ; i<=num/2;i++)
        {
            if(num%i==0)
                count+=i;
            
        }
        
        return count == num;
    }
}