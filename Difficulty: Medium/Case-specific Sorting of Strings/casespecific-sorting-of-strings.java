class Solution {
    public static String caseSort(String s) {
        // code here
        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> upper = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isLower(c)) {
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        
        Collections.sort(lower);
        Collections.sort(upper);
        
        StringBuilder res = new StringBuilder();
        int lowIdx = 0, upperIdx = 0;
        
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isLower(c)) {
                res.append(lower.get(lowIdx++));
            } else {
                res.append(upper.get(upperIdx++));
            }
        }
        
        return res.toString();
    }
    
    private static boolean isLower(char ch) {
        if(ch >= 'a' && ch <= 'z') return true ;
        return false ;
    }
}

