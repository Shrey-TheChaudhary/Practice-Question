class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] array=Arrays.copyOf(arr,arr.length);
        
        Arrays.sort(array);
        int k=1;
        
        for(int i=0;i<array.length;i++)
        {
            if(!hm.containsKey(array[i]))
                hm.put(array[i],k++);
        }
        
        int[] result=new int[array.length];
        
        for(int i=0;i<arr.length;i++)
            result[i]=hm.get(arr[i]);
        
        return result;
    }
}