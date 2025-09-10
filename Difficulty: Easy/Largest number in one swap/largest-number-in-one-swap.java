class Solution {
    public String largestSwap(String s) {
        char maxVal = '0';
        int valIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= maxVal) {
                maxVal = c;
                valIdx = i;
            }
        }
        
        StringBuilder result = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i != valIdx && maxVal != c) {
                char d = result.charAt(i);
                result.setCharAt(i,maxVal);
                result.setCharAt(valIdx,d);
                break;
            }
        }
        
        
        return result.toString().compareTo(s) >=0 ?result.toString():s;
    }
}