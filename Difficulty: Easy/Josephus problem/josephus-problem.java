class Solution {
    public int josephus(int n, int k) {
        // code here
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            ls.add(i);
        }
        int start = 0;
        while(ls.size() > 1) {
            start = (start + k - 1) % ls.size();
            ls.remove(start);
        }
        return ls.get(0);
    }
}