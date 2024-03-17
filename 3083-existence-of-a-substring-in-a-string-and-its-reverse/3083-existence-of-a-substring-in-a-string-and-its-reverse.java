class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        
        for(int i=0;i<s.length()-1;i++)
        {
            String temp=s.substring(i, i + 2);
            if(rev.indexOf(temp)!=-1)
                return true;
        }
        return false;
    }
}