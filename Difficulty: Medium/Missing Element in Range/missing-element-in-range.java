class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        int l=arr.length;
        ArrayList<Integer> fr = new ArrayList<>();
        // ArrayList<Integer> r = new ArrayList<>();
        HashSet<Integer> r=new HashSet<>();
        for(int i=0;i<l;i++){
            if(arr[i]>=low && arr[i]<=high){
                r.add(arr[i]);
            }
        }
        for(int i=low;i<=high;i++){
            if(!r.contains(i)){
                fr.add(i);
            }
        }
        return fr;
    }
}