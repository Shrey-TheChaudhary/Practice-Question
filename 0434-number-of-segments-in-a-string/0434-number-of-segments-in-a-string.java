class Solution {
    public int countSegments(String s) {
        int segments=0;
        for(int i=0;i<s.length();i++){
            if((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' ')
                segments++;
        }
        return segments;
    }
}