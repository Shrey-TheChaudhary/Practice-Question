//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    static LinkedHashMap<Integer,Integer> lhm;
    static int capa;
    LRUCache(int cap)
    {
        lhm=new LinkedHashMap<>(cap);
        capa=cap;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        int a=lhm.getOrDefault(key,-1);
        if(a!=-1){
            lhm.remove(key);
            lhm.put(key,a);
        }
        return a;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(lhm.size()<capa){
            lhm.put(key,value);
        }
        else{
            if(lhm.containsKey(key)){
                lhm.remove(key);
                lhm.put(key,value);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>(lhm.keySet());
                int a=arr.get(0);
                lhm.remove(a);
                lhm.put(key,value);
            }
        }
    }
}