class Solution {
    public String removeStars(String s) {
       Stack<Character>st=new Stack<>();
       for(char ch:s.toCharArray())
       {
           if(ch=='*')
            st.pop();
           
           else
            st.push(ch);
           
       }
       if(st.isEmpty())
          return "";
       
       StringBuilder ans=new StringBuilder();
       for(char ch:st){
           ans.append(ch);
       }
        return ans.toString();


    }
}