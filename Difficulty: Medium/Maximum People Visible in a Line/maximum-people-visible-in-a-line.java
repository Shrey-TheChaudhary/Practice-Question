class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int mx = 0,n = arr.length;
        for(int i=0;i<n;i++){
            mx = Math.max(arr[i],mx);
        }
        LinkedList<Integer>lt = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i]==mx)lt.add(i);
        }
        lt.add(n);
        int pr = 0,cr,nxt,ans=0;
        while(lt.size()>1){
            cr = lt.removeFirst();
            nxt = lt.getFirst();
            ans=Math.max(ans,nxt-pr);
            pr=cr+1;
        }
        return ans;
    }
}
