class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        backtrack(ans, nums, new ArrayList<>(), visited);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> temp, boolean[] visited) {
        //for this problem, the base case will be if temp.size==nums.length
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //if element is already exist, than skip that
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(ans, nums, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}