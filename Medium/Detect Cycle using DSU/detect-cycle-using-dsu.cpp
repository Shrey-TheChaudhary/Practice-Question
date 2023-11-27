//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Disjoint_Set
     {
    
    vector<int> parent, rank;
    public:
   
    
    //initialization of disjoint data structure
    Disjoint_Set(int n)
    {
        parent.resize(n);
        rank.resize(n,0);
        
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
    }
    
    
    //finding parent of each node
    
    int FindParent(int u)
    {
        //until we dont get the value itself
        if(parent[u]!=u)
        {
            parent[u]= FindParent(parent[u]);
        }
        
        return parent[u];
    }
    
    
    //making the union graph and adjusting according to the rank
    void Union(int u, int v)
    {
        int u_parent = FindParent(u);
        int v_parent = FindParent(v);
        
        //if the parents are not same
        //update the rank and connect accordingly
        
        if(u_parent!=v_parent)
        {
            if(rank[v_parent]>rank[u_parent])
            {
                parent[u_parent]=v_parent;
            }
            else if(rank[u_parent]>rank[v_parent])
            {
                parent[v_parent]=u_parent;
            }
            else
            {
                parent[u_parent]=v_parent;
                rank[v_parent]++;
            }
        }
    }
    
     };
  
class Solution
{
     public:
     // Disjoint Data Structure
    
int detectCycle(int V, vector<int> adj[])
{
    
    Disjoint_Set ds(V);
        set<pair<int, int>> s;
        
    for(int i=0;i<V;i++)
    {
        for(int j=0;j<adj[i].size();j++)
        {
            
               if(s.find({i, adj[i][j]}) != s.end() or s.find({adj[i][j], i}) != s.end())
                {
                    continue;
                }
                
                s.insert({i, adj[i][j]});
            int u = ds.FindParent(i);
            int v = ds.FindParent(adj[i][j]);
            
            //if they have same parent then its a cycle
            
            if(u==v)return 1;
            
            // other wise keep making the set of the nodes
            ds.Union(i,adj[i][j]);
        }
    }
    
    return 0;
    
}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		int ans = obj.detectCycle(V, adj);
		cout << ans <<"\n";	}
	return 0;
}
// } Driver Code Ends