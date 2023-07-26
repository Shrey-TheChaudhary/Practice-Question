class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l =1 ;
        int r = (int)1e7;
        int minspeed = -1;
  
        while(l<=r){
          int mid = l+(r-l)/2;
          if(check(dist , hour , mid)){
            minspeed = mid;
            r = mid-1;
          }
          else{
            l  = mid+1;
          }
        }
        return minspeed;
    }
    public static boolean check(int[]dist , double hour , int speed){
      int n = dist.length;
      double sum = 0.0;
      for(int i =0 ; i<n ; i++){
        double time = (double)dist[i]/(double)speed;
        if(i == n-1) sum +=time;
        else sum = sum + Math.ceil(time);
        if(sum>hour) return false;
      }
      return sum<=hour;
    }
}