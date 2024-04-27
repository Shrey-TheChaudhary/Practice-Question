class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder num = new StringBuilder(number);
        StringBuilder max = new StringBuilder("-1");
       
        for (int i = 0; i < number.length(); i++) 
        {
            if (num.charAt(i) == digit) 
            {
                StringBuilder ans=new StringBuilder (num.deleteCharAt(i));
                if (ans.compareTo(max)>0) 
                    max = ans;
                
                num.insert(i,digit);
            }
            

        }
        return max.toString();
    }
}