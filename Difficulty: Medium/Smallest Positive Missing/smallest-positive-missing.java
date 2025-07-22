class Solution {

    public int missingNumber(int[] arr) {

        // code here

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<=9;i++){

            map.put(i,0);

        }

        for(int i=0;i<arr.length;i++){

            

            if(map.containsKey(arr[i])){

                map.put(arr[i],map.get(arr[i])+1);

            }

            

        }

        int missing=-1;

        for(int i=1;i<=9;i++){

            if(map.get(i)==0){

                missing=i;

                break;

            }

        }

        return missing;

    }

}


