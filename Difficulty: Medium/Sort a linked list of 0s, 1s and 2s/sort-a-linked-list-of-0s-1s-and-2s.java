class Solution {
    static Node segregate(Node head) {
        // code here
        int zero = 0, one = 0, two = 0;
        Node curr = head;
        while(curr!=null){
            if(curr.data==0){
                zero++;
            }
            else if(curr.data==1){
                one++;
            }
            else{
                two++;
            }
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr!=null){
            if(zero!=0){
                curr.data = 0;
                zero--;
            }
            else if(one!=0){
                curr.data = 1;
                one--;
            }
            else if(two!=0){
                curr.data = 2;
                two--;
            }
            curr = curr.next;
        }
        
        return head;
    }
}