class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
       
        return mergesort(arr,0,arr.length-1);
    }
     public static int mergesort(int arr[],int si,int ei){
       if(si>=ei){
           return 0;
       }
        int count=0;
        int mid=si+(ei-si)/2;
        count +=mergesort(arr,si,mid);
        count +=mergesort(arr,mid+1,ei);
        count +=merge(arr,si,mid,ei);
        return count;
        
    }
    public static int merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        int count1=0;
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }
            else{
                temp[k]=arr[j];
                count1+=mid-i+1;
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        
        for( k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
        return count1;
    }
}