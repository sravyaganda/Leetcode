/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        if(root==null)
        {
            return new ArrayList();
        }
        
    //Initialize Variables
       TreeMap<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>();
       Queue<Pair<TreeNode,Integer>> q=new LinkedList();
       List<List<Integer>> result=new ArrayList();
       
        q.add(new Pair<>(root,0));
        
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size>0)
            {
                Pair<TreeNode,Integer> pair=q.poll();
                int col=pair.getValue();
                TreeNode node=pair.getKey();
                map.putIfAbsent(col,new ArrayList());
                map.get(col).add(node.val);
                
                if(node.left!=null)
                    q.add(new Pair(node.left,col-1));
                if(node.right!=null)
                    q.add(new Pair(node.right,col+1));                
                size--;
            }
        }
        
        for(int i:map.keySet())
        {
            result.add(map.get(i));
        }
        
        return result;
        
        
    //BFS
    //Construct Result List;    
        
    }
}