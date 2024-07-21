//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
      
      
      long ans=1;
      long min=Integer.MAX_VALUE;
      boolean hz=false;
      boolean hp=false;
      if(arr.size()==1)return arr.get(0);
      
      
      
      for(int i=0;i<arr.size();i++){
          int num=arr.get(i);
          
          if(num==0){hz=true;continue;}
          else if(0>num){
              if(Math.abs(num)<Math.abs(min)){
                  min=num;
                  
              }
              
              ans*=num;
              ans%=1000000007;
          }
          else{
               hp = true;
                ans*=num;
                ans%=1000000007;
              
          }
          
          
          
          
      }
      
      
      
       if(arr.size()==2){
            if(hp==false && hz==true){
                return 0;
            }
        }
        if (ans < 0 ) {
            ans /= min;
        }
        
        return ans%1000000007;
      
    }
}