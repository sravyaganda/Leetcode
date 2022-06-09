class Solution {
    
    
    Set<Integer> visited;
    Map<Integer,List<Integer>> adjList;
    public boolean validTree(int n, int[][] edges) {
        
        if(n==0)
        {
            return true;
        }
        
        if(edges.length!=n-1)
        {
            return false;
        }
        
     visited=new HashSet<Integer>();
        adjList=new HashMap<Integer,List<Integer>>();
        
        for(int[] edge:edges)
        {
            if(!adjList.containsKey(edge[0]))
            {
                adjList.put(edge[0],new ArrayList<Integer>());
            }
            
            adjList.get(edge[0]).add(edge[1]);
            
             if(!adjList.containsKey(edge[1]))
            {
                adjList.put(edge[1],new ArrayList<Integer>());
            }
            
            adjList.get(edge[1]).add(edge[0]);
        }
        
        
       dfs(0);
        
        return  visited.size()==n;
       
    }
    
    public void dfs(int vertex)
    {
        if(visited.contains(vertex))
        {
            return ;
        }
        
        visited.add(vertex);
        for(Integer nei:adjList.getOrDefault(vertex,new ArrayList<Integer>()))
        {
            dfs(nei);
        }
        
    }
}