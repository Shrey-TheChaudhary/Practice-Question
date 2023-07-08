class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   List<List<Integer>> list = new LinkedList<List<Integer>>();
   Arrays.sort(candidates);
    
   combisum(list, new ArrayList<Integer>(), candidates, target, 0);
   return list;
}

private void combisum(List<List<Integer>> list, List<Integer> tempList, int[] cand, int target, int start) {
   
   if(target < 0) 
       return; /** no solution */
   else if(target == 0) 
       list.add(new ArrayList<>(tempList));
   else
   {
      for (int i = start; i < cand.length; i++) 
      {
         if(i > start && cand[i] == cand[i-1]) 
             continue; 
         tempList.add(cand[i]);
         combisum(list, tempList, cand, target - cand[i], i+1);
         tempList.remove(tempList.size() - 1);
      }
   }
}
}