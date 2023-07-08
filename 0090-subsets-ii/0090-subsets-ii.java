class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        sub(0,nums,ans,new ArrayList<>());
        return ans;
    }
    static void sub(int index,int arr[],List<List<Integer>> ans,List<Integer> li)
{        
        ans.add(new ArrayList<>(li));
        
        for(int i=index;i<arr.length;i++)
        {
            if(i>index && arr[i]==arr[i-1]) 
                continue;
            li.add(arr[i]);
            sub(i+1,arr,ans,li);
            li.remove(li.size()-1);
        }
    }
}