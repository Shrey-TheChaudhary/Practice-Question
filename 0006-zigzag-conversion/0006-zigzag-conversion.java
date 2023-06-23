class Solution {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> list=new ArrayList<>();
        for(int i=0;i<numRows;i++)
            list.add(new StringBuilder());
        
        int c=0;
        while(c<s.length())
        {
            for(int i=0;i<numRows && c<s.length() ;i++,c++)
                list.get(i).append(s.charAt(c));
            
            for(int i=numRows-2;i>=1 && c<s.length();i--,c++)
                list.get(i).append(s.charAt(c));
        }
        String ans="";
        for(int i=0;i<numRows;i++){
            String str=new String(list.get(i));
            ans=ans+str;
        }

        return ans;
    }
}