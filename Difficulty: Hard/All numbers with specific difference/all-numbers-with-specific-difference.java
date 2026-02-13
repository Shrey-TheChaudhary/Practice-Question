class Solution {
    public int sumofdig(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }return sum;
    }
    public int getCount(int n, int d) {
        // code here
        if(n<10)return 0;
        int i=1,j=n,firstidx=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(mid-sumofdig(mid)>=d){
                firstidx=mid;
                j=mid-1;
            }else if(mid-sumofdig(mid)<d)i=mid+1;
            
        }
        if(firstidx==-1)return 0;
        return (n-firstidx+1);
        
    }
};