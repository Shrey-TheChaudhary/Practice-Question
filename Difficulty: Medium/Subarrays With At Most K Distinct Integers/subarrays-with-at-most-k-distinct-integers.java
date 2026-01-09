class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
         int n=arr.length;
        long total=n*(n+1)/2;
        
        int i=0;
        int j=0;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n)
        {
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
           // System.out.println(map);
            while(map.size()>k)
            {
                ans+=n-j;
                
                  map.put(arr[i],map.get(arr[i])-1);
                  
                  if(map.get(arr[i])==0) 
                  map.remove(arr[i]);
                
                i++;
            }
            j++;
        }
        
        return (int)total-ans;
    }
}
