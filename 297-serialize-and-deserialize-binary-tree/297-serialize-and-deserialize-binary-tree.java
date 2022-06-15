/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
        return serialize(root,"");
        
        
    }
    
     public String serialize(TreeNode root,String str) {

         if(root==null)
         {
             str+="null,";
         }
         else
         {
             str+=str.valueOf(root.val)+",";
             str=serialize(root.left,str);
             str=serialize(root.right,str);
         }
         return str;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array=data.split(",");
        List<String> data_List=new LinkedList<String>(Arrays.asList(data_array));
        
        return deserialize(data_List);
        
    }
    
     public TreeNode deserialize(List<String> l) {
        
        if(l.get(0).equals("null"))
        {
            l.remove(0);
            return null;
        }
         
         TreeNode root=new TreeNode(Integer.valueOf(l.get(0)));
         l.remove(0);
         root.left=deserialize(l);
         root.right=deserialize(l);
         
         return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));