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
    public int longestZigZag(TreeNode root) {
        
        return helper(root,false,false,1)-1;
    }
    
    public int helper(TreeNode node,boolean isLeft,boolean isRight,int count)
    {
        if(node==null)
        {
            return count;
        }
        
        return Math.max(helper(node.left,true,false,isRight?count+1:1),helper(node.right,false,true,isLeft?count+1:1));
    }
}