class Solution {
    
boolean isCycle; 
Map<Integer,Integer> color;
Map<Integer,List<Integer>> adjList;    
Stack<Integer> courseOrder;
    
static int WHITE=1;
static int GRAY=2;
static int BLACK=3;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.color=new HashMap();
        this.adjList=new HashMap();
        this.courseOrder=new Stack();
        this.isCycle=false;
        
        for(int[] i:prerequisites)
        {
            adjList.putIfAbsent(i[1],new ArrayList());
            adjList.get(i[1]).add(i[0]);
        }
        
        for(int i=0;i<numCourses;i++)
        {
            this.color.put(i,WHITE);
        }
            
        for(int i=0;i<numCourses;i++)
        {
            if(this.color.get(i)==WHITE){
                  this.dfs(i);
            }
        }
        
        int[] order;
        
        if(!this.isCycle)
        {
            order=new int[numCourses];
            
            for(int i=0;i<numCourses;i++)
            {
                order[i]= courseOrder.pop();
            }}
        else{
            order=new int[0];
        }
        
        return order;
        }
        

  private  void dfs(int node)
    {
        if(isCycle)
        {
            return;
        }
        
        this.color.put(node,GRAY);
        
        for(Integer nei:this.adjList.getOrDefault(node,new ArrayList<Integer>()))
        {
            if(this.color.get(nei)==WHITE)
            {
                this.dfs(nei);
            }
            else if(this.color.get(nei)==GRAY)
            {
                this.isCycle=true;
            }
        }
        
        this.color.put(node,BLACK);
        courseOrder.push(node);
    }
}