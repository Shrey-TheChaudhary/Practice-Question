class Solution {
    public int minimumDeletions(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()){
            if (c == 'b')
                count++;
            else if (count != 0){
                res++;
                count--;
            }
        }
        return res;
    }
}