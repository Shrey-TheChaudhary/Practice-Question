 class Solution{
    static long minTime(int[] arr,int k){
        PaintersPartition partition=new PaintersPartition();
        return partition.getMinTime(arr,k);
    }
    
}
class PaintersPartition{
    int board[];
    int availableWorkers;
    long getMinTime(int board[],int workers){
        this.board=board;
        this.availableWorkers=workers;
        long minTime=getMaxBoard(board);
        long maxTime=getSumBoard(board);
        long l=minTime,r=maxTime;
        while(l<r){
            long currTime=l+(r-l)/2;
            boolean possibleToPaintInTime=isPossibleToPaintInTime(currTime);
            if(possibleToPaintInTime){
                r=currTime;
            }else{
                l=currTime+1;
            }
        }
        return r;
    }
    long getMaxBoard(int board[]){
        return Arrays.stream(board).max().getAsInt();
    }
    long getSumBoard(int board[]){
        long sum=0;
        for (int i = 0; i < board.length; i++) {
           sum+=board[i]; 
        }
        return sum;
    }
    boolean isPossibleToPaintInTime(long maxTime){
        int requiredWorkers=1;
        long currentWorkerTime=0;
        for(int i=0;i<board.length;i++){
            currentWorkerTime+=board[i];
            if(currentWorkerTime>maxTime){
                currentWorkerTime=board[i];
                requiredWorkers++;
            }
        }
        return requiredWorkers<=availableWorkers;
    }
}

