class Solution {
    public int romanToDecimal(String s) {

       HashMap<Character, Integer> map = new HashMap<>();     
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        for(int i = 0 ; i < s.length()-1; i++){
            int num1 = map.get(s.charAt(i));
            int num2 = map.get(s.charAt(i+1));
            
            if(num1 >= num2){
                ans += num1; 
            }else{
                ans -= num1;
            }
        }
        return ans + map.get(s.charAt(s.length()-1));
    }
}