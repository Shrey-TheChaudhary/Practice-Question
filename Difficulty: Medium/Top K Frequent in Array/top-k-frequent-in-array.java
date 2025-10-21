class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int ele : arr) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freq.entrySet());
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
              
                return b.getKey().compareTo(a.getKey());
            } else {
         
                return b.getValue().compareTo(a.getValue());
            }
        });

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && i < entryList.size(); i++) {
            res.add(entryList.get(i).getKey());
        }

        return res;
    }
}