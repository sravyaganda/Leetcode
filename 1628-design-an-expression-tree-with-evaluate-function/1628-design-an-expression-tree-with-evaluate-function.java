/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it
 */

abstract class Node {
    public abstract int evaluate();
    Node left;
    Node right;
    int result;
};


class TreeNode extends Node{
    public int evaluate(){
        return this.result;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        
        HashSet<Character> set =new HashSet();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        
        Stack<TreeNode> stack=new Stack();
        int n=postfix.length;
        for(int i=0;i<n;i++)
        {
            TreeNode nd=new TreeNode();
            if(set.contains(postfix[i].charAt(0)))
            {
                TreeNode n1=stack.pop();
                TreeNode n2=stack.pop();
                
                nd.left=n2;
                nd.right=n1;
                nd.result=getResult(n2.result,n1.result,postfix[i]);
            }else{
                nd.result=Integer.parseInt(postfix[i]);
            }
            stack.push(nd);
        }
        return (Node) stack.pop();
        
    }
    
    private int getResult(int a, int b, String operator)
    {
        switch(operator)
        {
            case "*": return a*b;
            case "/": return a/b;
            case "-": return a-b;
            default:
              return a+b;
        }
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */