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
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        if(root==null)
        {
            return new ArrayList();
        }
        List<String> result=new ArrayList();
        preOrder(root,"",result);
        return result;
        
    }
    
    public void preOrder(TreeNode root,String path,List<String> result)
    {
        if(root==null)
        {
            return;
        }
       if (root.left == null && root.right == null) 
       {
           result.add(path+root.val);
           return;
        }
        
        path=path+root.val+"->";
        
        preOrder(root.left,path,result);
        preOrder(root.right,path,result);
        
    }
    
    
}