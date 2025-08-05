class Solution {
    static boolean isPali(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='a' && ch<='z' )|| (ch>='A' && ch<='Z')|| (ch>='0' && ch<='9')){
                s1.append(Character.toLowerCase(ch));
            }
        }
        String str = s1.toString(); 
        return isPali(str,0,str.length()-1);
    }
}