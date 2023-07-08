class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if(nums==null || nums.size()==0) 
            return null;
        
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int count=0;
        
        for(int i=nums.size()-1;i>=0;i--)
        {
            count+=nums.get(i).size();
            for(int j=0;j<nums.get(i).size();j++)
            {
                if(!map.containsKey(i+j))
                    map.put(i+j,new ArrayList<Integer>());
                
                map.get(i+j).add(nums.get(i).get(j));
            }
        }
        
        int size=map.size();
        int mapIndex=0;
        int arrIndex=0;
        
        int arr[]=new int[count];
        
        while(mapIndex<size)
        {
            for(int i:map.get(mapIndex))
                arr[arrIndex++]=i;
            
            mapIndex++;
        }
        return arr;
    }
}
