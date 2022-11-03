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
    int[] arr;
    public TreeNode sortedArrayToBST(int[] nums) {
        arr=nums;
        
        return BST(0,nums.length-1);
    }
    
    public TreeNode BST(int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        
        int mid=left+(right-left)/2;
        
        TreeNode root=new TreeNode(arr[mid]);
        root.left=BST(left,mid-1);
        root.right=BST(mid+1,right);
        
        return root;
    }
}