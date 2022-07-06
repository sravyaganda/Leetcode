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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        
        List<Integer> leftB=new LinkedList<>();
        List<Integer> rightB=new LinkedList<>();
        List<Integer> leaf=new LinkedList<>();
        preOrder(root,leftB,rightB,leaf,0);
        
        leftB.addAll(leaf);
        leftB.addAll(rightB);
        return leftB;
        
    }
    
    public boolean isLeaf(TreeNode node)
    {
        return (node.left==null && node.right==null) ;
    }
    
    public boolean isRight(int flag)
    {
        return flag==2;
    }
    public boolean isLeft(int flag)
    {
        return flag==1;
    }
    public boolean isRoot(int flag)
    {
        return flag==0;
    }
    public int leftChildFlag(TreeNode cur,int flag)
    {
        if(isLeft(flag)|| isRoot(flag))
        {
            return 1;
        }
        else if(isRight(flag) && cur.right==null)
        {
            return 2;
        }
       else return 3;
    }
     public int rightChildFlag(TreeNode cur,int flag)
    {
        if(isRight(flag)|| isRoot(flag))
        {
            return 2;
        }
        else if(isLeft(flag) && cur.left==null)
        {
            return 1;
        }
       else return 3;
    }
        
    
    public void preOrder(TreeNode curr,List<Integer> leftB,List<Integer> rightB,List<Integer> leaf,int flag)
    {
        if(curr==null)
        {
            return;
        }
        if(isRight(flag))
        {rightB.add(0,curr.val);}
        else if(isLeft(flag) || isRoot(flag))
        {
            leftB.add(curr.val);
        }
        else if(isLeaf(curr))
            leaf.add(curr.val);
        
        preOrder(curr.left,leftB,rightB,leaf,leftChildFlag(curr,flag));
  preOrder(curr.right,leftB,rightB,leaf,rightChildFlag(curr,flag));       
    }
}