class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        
        combinationSum1(0, candidates, target, res, list);
        return res;
    }
    public static void combinationSum1(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list) {
        
        if(index == arr.length)
        {
            if(target == 0)
                res.add(new ArrayList<>(list));
            
            return;
        }
        if(arr[index] <= target){
            //pick the index value
            list.add(arr[index]);
            combinationSum1(index, arr, target - arr[index], res, list);
            list.remove(list.size() - 1);
        }
        //not picking
        combinationSum1(index + 1, arr, target, res, list);
    }
}