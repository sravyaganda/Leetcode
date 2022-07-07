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
    
    TreeNode x=null,y=null,pred=null;
    public void recoverTree(TreeNode root) {
        
        findTwoSwapped(root);
        swap(x,y);
    }
    
    public void findTwoSwapped(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        findTwoSwapped(root.left);
        if(pred!=null && root.val<pred.val)
        {
            y=root;
            if(x==null)
                x=pred;
            else return;
        }
        pred=root;
        findTwoSwapped(root.right);
    }
    
    public void swap(TreeNode x, TreeNode y)
    {
        int temp=x.val;
        x.val=y.val;
        y.val=temp;
    }
}