class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       List<Boolean> ans=new ArrayList<>();
        int max=0;
        for(int x:candies)
            max=Math.max(max,x);
        
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]+extraCandies>=max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}