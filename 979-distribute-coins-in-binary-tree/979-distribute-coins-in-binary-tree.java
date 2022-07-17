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
    int coins;
    public int distributeCoins(TreeNode root) {
        coins=0;
        getCoins(root);
        return coins;
        
    }
    
    public int getCoins(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int leftSubTree=getCoins(node.left);
        int rightSubTree=getCoins(node.right);
        coins+=Math.abs(leftSubTree)+Math.abs(rightSubTree);
        
        return node.val+leftSubTree+rightSubTree-1;
    }
}