class Solution {
    public int totalElements(int[] arr) {
        // code here
        int left = 0;
        int maxLen = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            
            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            
          maxLen = Math.max(maxLen, i - left + 1);    
        }
        
        return maxLen;
    }
}