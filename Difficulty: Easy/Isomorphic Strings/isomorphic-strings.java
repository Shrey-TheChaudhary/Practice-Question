class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length()!=str2.length()){
            return false;
        }
        // Your code here
        int s1[]=new int [256];
        int s2[]=new int [256];
        Arrays.fill(s1,-1);
        Arrays.fill(s2,-1);
        
        for(int i=0;i<str1.length();i++){
            char ss=str1.charAt(i);
            char tt=str2.charAt(i);
            
            if(s1[ss]==-1 && s2[tt]==-1){
                s1[ss]=tt;
                s2[tt]=ss;
            }
            else if(s1[ss]!=tt || s2[tt]!=ss){
                return false;
            }
            
        }
        return true;
        
    }
}