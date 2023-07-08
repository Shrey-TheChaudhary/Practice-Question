class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        solve(0,candidates,new ArrayList<>(),list,target);
        return list;
        
    }
    
    private void solve(int ind,int nums[],List<Integer> temp,List<List<Integer>> list,int target){
        
        if (target < 0 ) 
            return;
        
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=ind;i<nums.length;i++){
            
            temp.add(nums[i]);
            solve(i,nums,temp,list,target-nums[i]);
            temp.remove(temp.size()-1);          
            
        }
        
    }
}