class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int ns=s.length(),np=p.length();
        
        if(ns<np)
        {
            return new ArrayList<Integer>();
        }
        
        HashMap<Character,Integer> pCount=new HashMap();
        HashMap<Character,Integer> sCount=new HashMap();
        
        for(char c:p.toCharArray())
        {
            if(pCount.containsKey(c)){
                       pCount.put(c,pCount.get(c)+1);
            }
     else
     {
         pCount.put(c,1);
     }
            
        }
          List<Integer> output = new ArrayList();
        
        for(int i=0;i<ns;i++)
        {
            char ch=s.charAt(i);
            if(sCount.containsKey(ch))
            {
                sCount.put(ch,sCount.get(ch)+1);
            }
            else
            {
                sCount.put(ch,1);
            }
            
            if(i>=np)
            {
                ch=s.charAt(i-np);
                if(sCount.get(ch)==1)
                {
                    sCount.remove(ch);
                }
                else
                {
                    sCount.put(ch,sCount.get(ch)-1);
                }
            }
            
            if(pCount.equals(sCount))
            {
                output.add(i-np+1);
            }
        }
        
        return output;
    }
}