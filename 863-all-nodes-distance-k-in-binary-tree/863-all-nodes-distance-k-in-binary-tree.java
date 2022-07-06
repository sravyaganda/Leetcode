/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<Integer,List<Integer>> adjList;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        

       adjList=new HashMap();
        
       dfs(root,null);
        List<Integer> result=new ArrayList();
        Set<Integer> seen=new HashSet<Integer>();
        
        //pair, key-Node, value-distance
       Queue<Integer> q=new LinkedList();
        
        q.add(target.val);
        seen.add(target.val);
        
        while(!q.isEmpty())
        {
            for(int i=0;i<k;i++)
            {
               int size=q.size();
                while(size>0)
                {
                    int node=q.poll();
                    if(adjList.get(node)!=null)
                    for(int nei:adjList.get(node))
                    {
                        if(!seen.contains(nei))
                        { seen.add(nei);
                            q.add(nei);}
                    }
                    size--;
                }
            }
            
            while(!q.isEmpty())
            {
                result.add(q.poll());
            }
            
            return result;
        }
        
          return new ArrayList();
        
    }
    
    public void dfs(TreeNode node,TreeNode par)
    {
        if(node!=null)
        {
            List<Integer> list=new ArrayList();
            if(par!=null)
             list.add(par.val);
            if(node.left!=null)
                list.add(node.left.val);
            if(node.right!=null)
                list.add(node.right.val);
            if(list.size()>0)
                adjList.put(node.val,list);
                
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
}