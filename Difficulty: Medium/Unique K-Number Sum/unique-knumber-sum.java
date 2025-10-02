class Solution {
      void find(int i,int n,int k,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans,boolean [] nums ){
           // base case 
             if(list.size()==k){
                 if(n==0){
               ans.add(new ArrayList<>(list));         
                 }
                return ; 
             }
           for(int j=i+1;j<=9;j++){
               if((n-j)<0)
                return;
               if(!nums[j]){
                  list.add(j);
                  nums[j]=true;
                  find(j,n-j,k,list,ans,nums);
                  list.remove(list.size()-1);
                  nums[j]=false;
               }
           }
      }
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        boolean nums []=new boolean[10];
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        find(0,n,k,list,ans,nums);
        return ans;
        
    }
}