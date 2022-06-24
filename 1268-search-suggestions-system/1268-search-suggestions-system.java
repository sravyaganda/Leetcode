class Trie
{
    class Node{
        boolean word=false;
        List<Node> children=Arrays.asList(new Node[26]);
        
    };
    
    Node root,curr;
    List<String> resultBuffer;
    Trie()
    {
        this.root=new Node();
    }
    
    void insert(String s)
    {
        this.curr=root;
        
        for(char c:s.toCharArray())
        {
            if(curr.children.get(c-'a')==null)
            {
                curr.children.set(c-'a',new Node());
            }
            curr=curr.children.get(c-'a');
        }
        curr.word=true;
    }
    
    void dfsWithPrefix(Node curr,String word)
    {
        if(resultBuffer.size()==3)
        {
            return;
        }
        
        if(curr.word)
        {
            resultBuffer.add(word);
        }
        
       for(char c='a';c<='z';c++)
       {
          if(curr.children.get(c-'a')!=null)
          dfsWithPrefix(curr.children.get(c-'a'),word+c);
       }
    }
    List<String> getWordsStartingWith(String prefix)
    {
        curr=this.root;
        resultBuffer=new ArrayList<String>();
        
        for(char c:prefix.toCharArray())
        {
            if(curr.children.get(c-'a')==null)
            {
                return resultBuffer;
            }
            curr=curr.children.get(c-'a');
        }
        dfsWithPrefix(curr,prefix);
        return resultBuffer;
    }
}



class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        
        Trie trie=new Trie();
        List<List<String>> result=new ArrayList();
        for(String s:products)
        {
            trie.insert(s);
        }
        
        String prefix=new String();
        
        for(char c: searchWord.toCharArray())
        {
            prefix+=c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        
        return result;
        
    }
}