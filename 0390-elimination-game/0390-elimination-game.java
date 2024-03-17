class Solution {
    public int lastRemaining(int n) {
        
        //firstly n==1 the output is 1
        //then using lifo 9 is number [2*(5.5-4.5)]=2
        //for 8 :- [2*(5-4)]=2
        //for 2 :- [2*(2-1)]=2
        //for 3 :- [2*(2.5-1.5)]=2
        //for 4 :- [2*(3-2)]=2
        return n==1 ? 1 : 2*(1 + n / 2 - lastRemaining(n/2));
    }
}