class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list=new ArrayList<>();
        
        int k=p.length();
        int n=s.length();

         if(n<k)
          return new ArrayList<Integer>();

        char arr1[]=new char[26];
        char arr2[]=new char[26];
        
        for(int i=0;i<k;i++){
            arr1[s.charAt(i)-'a']++;
            arr2[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(arr1,arr2))
         list.add(0);

        for(int i=k;i<n;i++){
            arr1[s.charAt(i)-'a']++;
            arr1[s.charAt(i-k)-'a']--;

            if(Arrays.equals(arr1,arr2))
              list.add(i-k+1);
        }
        return list;
    }
}
