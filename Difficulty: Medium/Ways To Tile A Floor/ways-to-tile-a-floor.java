class Solution {
    public int numberOfWays(int n) {
        // code here
        int cur=1;
        int prev=1;
        int sum=1;
        for(int i=1;i<n;i++){
            sum=cur+prev;
            prev=cur;
            cur=sum;
        }
        return sum;
    }
};
