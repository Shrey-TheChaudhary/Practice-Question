class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, 1, ls, ans); 
        return ans;
    }

    public void helper(int n, int k, int start, ArrayList<Integer> ls, List<List<Integer>> ans) {
        if (ls.size() == k) { 
            ans.add(new ArrayList<>(ls));
            return;
        }
        

        for (int i = start; i <= n; i++) {
            ls.add(i); 
            helper(n, k, i + 1, ls, ans); 
            ls.remove(ls.size() - 1);
        }
    }
}