class Solution {
    public int minimumKeypresses(String s) {
        
        HashMap<Character,Integer> map=new HashMap();
        
        for(char c:s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int clicks=0;
        
        HashMap<Integer,StringBuilder> numberMap=new HashMap();
        
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        pq.addAll(map.keySet());
        
        
        while(!pq.isEmpty()){            
        for(int i=1;i<=9 && !pq.isEmpty();i++)
        {
            char c=pq.poll();
            StringBuilder sb=numberMap.getOrDefault(i,new StringBuilder());
            int count=map.get(c);
            sb.append(c);
            clicks+=(sb.length()*count);
            numberMap.put(i,sb);
            //System.out.println(numberMap.get(i));
        }
    }
        
        
        return clicks;
    }
}