class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : arr) { 
            if (hm.containsKey(2*num) || (num % 2 == 0 && hm.containsKey(num/2)))
                return true; 
           
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        return false;
    }
}