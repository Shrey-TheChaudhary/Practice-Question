class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int sum=0;
        while(n>0)
        {
            sum=sum*10+n%10;
            n=n/10;
        }
        return (sum==x);
    }
}