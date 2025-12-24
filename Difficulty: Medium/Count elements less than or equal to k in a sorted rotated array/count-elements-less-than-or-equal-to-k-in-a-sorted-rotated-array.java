class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        int count =0;
        for(int num:arr){
            if(num<=x) count++;
        }
        
        return count;
    }
}