class Solution {
    public boolean canServe(int[] arr) {
        // code here
         int l=arr.length;
        int c5=0,c10=0,c20=0;
        boolean f=true;
        // System.out.println(l);
        for(int i=0;i<l;i++){
            int b=arr[i];
            int c=b-5;
            if(c==0){
                c5++;
                continue;
            }else if(c==5){
                if(c5>0){
                    c5--;
                    c10++;
                }else{
                    return false;
                }
            }else{
                if(c10>0&& c5>0){
                    c10--;
                    c5--;
                    c20++;
                }else if(c5>2){
                    c5-=3;
                    c20++;
                }
                else{
                    return false;
                }
            }
        }
        return f;
    }
}