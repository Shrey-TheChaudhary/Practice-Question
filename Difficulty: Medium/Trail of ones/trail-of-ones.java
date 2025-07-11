class Solution {
    public static int fibonacci(int n){
        
        if(n==0) return 0;
        else if(n==2 || n==1){
            return 1;
        }
        else return (fibonacci(n-1)+fibonacci(n-2));
    }
    public int countConsec(int n) {
        // code here
        int pre=1<<n;
        return (pre-fibonacci(n+2));
    }
}