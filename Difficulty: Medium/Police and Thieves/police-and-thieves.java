class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> theif = new LinkedList<>();
        for(int i=0 ; i<arr.length; i++){
            if(arr[i] == 'T') theif.add(i);
            else police.add(i);
            
        }
        int count=0;
        while(!police.isEmpty() && !theif.isEmpty()){
            if(Math.abs(police.peek()-theif.peek())<=k){
                police.remove();
                theif.remove();
                count++;
            }else if(police.peek()>theif.peek()){
                theif.remove();
            }else{
                police.remove();
            }
        }
        return count;
    }
}