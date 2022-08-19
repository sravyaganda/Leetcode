class Solution {
    public List<List<String>> partition(String s) {
        
        if(s.length()==0)
        {
            return new ArrayList();
        }
        
        boolean[][] dp=new boolean[s.length()][s.length()];
        List<List<String>> result=new ArrayList();
        
        dfs(result,s,0,new ArrayList<>(),dp);
            return result;
        
    }
    
    public void dfs(List<List<String>> result,String s,int start,List<String> currentList,boolean[][]dp)
    {
        if(start>=s.length())
        {
            result.add(new ArrayList<>(currentList));
        }
        
        for(int end=start;end<s.length();end++)
        {
            if(s.charAt(start)==s.charAt(end) && (end-start<=2|| dp[start+1][end-1]))
            {
                dp[start][end]=true;
                currentList.add(s.substring(start,end+1));
                dfs(result,s,end+1,currentList,dp);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}