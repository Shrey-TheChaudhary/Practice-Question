class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        int n = arr.length;
        
        Map<Integer, int[]> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.computeIfAbsent(arr[i], k -> new int[]{-1, -1});
        }
        
        for (int i = 0; i < n; i++) {
            if (freq.get(arr[i])[0] == -1) {
                freq.get(arr[i])[0] = i;
            }
            freq.get(arr[i])[1] = i;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int val = query[2];
            
            if (freq.containsKey(val)) {
                int[] curr = freq.get(val);
                int start = Math.max(l, curr[0]);
                int end = Math.min(r, curr[1]);
                if (start - end <= 0) {
                    int count = end - start + 1;
                    ans.add(count);
                } else {
                    ans.add(0);
                }
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
}

