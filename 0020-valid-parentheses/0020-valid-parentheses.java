class Solution {
    public boolean isValid(String s) {
        Deque<Character> st=new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(ch=='(' ||ch=='{'||ch=='[')
                st.push(ch);
            else
            {
                if(st.isEmpty())
                    return false;
                else if(match(st.peek(),ch)==false)
                    return false;
                else
                    st.pop();
            }
        }
        return (st.isEmpty()==true);
    }
     public static boolean match(char a,char b){
        if( (a=='(' && b==')' )||( a=='[' && b==']' )||( a=='{' && b=='}'))
        return true;
        
        else 
        return false;
    }
}