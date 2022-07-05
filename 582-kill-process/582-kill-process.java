class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        HashMap<Integer,List<Integer>> map=new HashMap();
        List<Integer> result=new ArrayList();
        
        for(int i=0;i<ppid.size();i++)
        {
          if(ppid.get(i)>0)
          {
              List<Integer> list=map.getOrDefault(ppid.get(i),new ArrayList<Integer>());
              list.add(pid.get(i));
              map.put(ppid.get(i),list);
          } 
        }
        
        result.add(kill);
        getAllChilder(map,result,kill);
        return result;
    }
    
    public void getAllChilder(HashMap<Integer,List<Integer>> map,List<Integer> l,int kill)
    {
        if(map.containsKey(kill))
        {
            for(int id:map.get(kill))
            {
            l.add(id);
                getAllChilder(map,l,id);
            }
        }
    }
}