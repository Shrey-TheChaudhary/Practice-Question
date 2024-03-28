//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution 
{
    class Node implements Comparable<Node>
    {
        int des;
        int dist;
        
        Node(int des,int dist)
        {
            this.des=des;
            this.dist=dist;
        }
        
        public int compareTo(Node temp)
        {
            return this.dist-temp.dist;
        }
    }
    
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
           List<List<int[]>> graph = new ArrayList<>();
           
           for(int i=0;i<n;i++)
           {
               graph.add(new ArrayList<>());
           }
           
           for(int i=0;i<edges.length;i++)
           {
               int src=edges[i][0];
               int dest=edges[i][1];
               int weight=edges[i][2];
               graph.get(src).add(new int[]{src,dest,weight});
               graph.get(dest).add(new int[]{dest,src,weight});
           }
           
           int miniCity=-1;
           int count=Integer.MAX_VALUE;
           
            for(int i=0;i<n;i++)
            {
                            int visited[]=new int[n];
            PriorityQueue<Node> pq=new PriorityQueue<>();
            pq.add(new Node(i,0));
            int cities=0;
            while(pq.size()>0)
            {
                Node nd=pq.poll();
                
                if(visited[nd.des]==0)
                {
                    if(nd.dist<=distanceThreshold)
                    {
                        cities++;
                    }
                }
                
                visited[nd.des]=1;
                for(int a[]:graph.get(nd.des))
                {
                        int destination=a[1];
                        int distance=a[2];
                        if(visited[destination]==0)
                        {
                            
                        pq.add(new Node(destination,distance+nd.dist));
                        }
                    }
                }
                
            if(cities<=count)
            {
                count=cities;
                miniCity=i;
            }
                
                
            }
            
            return miniCity;
      }
}