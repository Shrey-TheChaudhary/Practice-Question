class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int len=0;
        StringBuilder result=new StringBuilder();
        int i=s.length()-1;
        s=s.toUpperCase();
        
        while(i>=0){
            if(Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i))){
                    if(len==k){
                        result.append('-');
                        len=0;
                    }
                    result.append(s.charAt(i));
                    len++;
                
            }
            i--;
        }
        return result.reverse().toString();
    }
}
