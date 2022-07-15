/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        HashSet<Node> seen=new HashSet();
        
        while(p!=null)
        {
            seen.add(p);
            p=p.parent;
        }
        
        while(q!=null)
        {
            if(seen.contains(q))
            {
                return q;
            }
            else
            {
                seen.add(q);
                q=q.parent;
            }
        }
        return null;
    }
}