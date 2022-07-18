class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    
        
        //Map of user names that holds list of Pairs of timestamp and user visited websites
        Map<String,List<Pair<Integer,String>>> usersMap=new HashMap();
        
        
        for(int i=0;i<timestamp.length;i++)
        {
            String user=username[i];       
            List<Pair<Integer,String>> visits=usersMap.getOrDefault(user,new ArrayList<Pair<Integer,String>>());
            visits.add(new Pair<Integer,String>(timestamp[i],website[i]));
            usersMap.put(user,visits);
        }
        //Map to hold each unique pattern of 3 sites and set of users visited the pattern
        Map<String,Set<String>> patternMap=new HashMap();
        String result="";
        int maxCount=0;
        
        for(Map.Entry<String,List<Pair<Integer,String>>> entry: usersMap.entrySet())
        {
            String user=entry.getKey();
            List<Pair<Integer,String>> visits=entry.getValue();
            Collections.sort(visits,(a,b)-> a.getKey()-b.getKey());
            
            for(int i=0;i<visits.size()-2;i++)
            {
                for(int j=i+1;j<visits.size()-1;j++)
                {
                    for(int k=j+1;k<visits.size();k++)
                    {
                        String pattern=visits.get(i).getValue() +":"+
                            visits.get(j).getValue()+":"+
                            visits.get(k).getValue();
                        Set<String> usersSet=patternMap.getOrDefault(pattern,new HashSet<String>());
                        usersSet.add(user);
                        
                        patternMap.put(pattern,usersSet);
                        if(patternMap.get(pattern).size()>maxCount)
                        {
                            maxCount=patternMap.get(pattern).size();
                            result=pattern;
                        }
                        else if(patternMap.get(pattern).size()==maxCount)
                        {
                            result= result.compareTo(pattern)<=0?result:pattern; 
                        }
                    }
                }
            }
       
        }
        
             
            return Arrays.asList(result.split(":"));
    }
}