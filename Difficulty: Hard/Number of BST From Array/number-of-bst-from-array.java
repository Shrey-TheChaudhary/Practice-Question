class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int[]map=new int[]{1,1,2,5,14,42};
        ArrayList<Integer>res=new ArrayList<>();
        for(int ele:arr) {
            int[]a=getLeftAndRight(ele,arr);
            res.add(map[a[0]]*map[a[1]]);
        }
        return res;
    }
    private int[] getLeftAndRight(int ele,int[]arr) {
        int l=0,r=0;
        for(int e:arr) {
            if(e<ele)l++;
            if(e>ele)r++;
        }
        return new int[]{l,r};
    }
}