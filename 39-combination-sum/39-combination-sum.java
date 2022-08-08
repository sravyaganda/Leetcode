class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        LinkedList<Integer> combination=new LinkedList<Integer>();
        
        backtrack(target,combination,results,target,candidates,0);
        return results;
       
    }
    
    public void backtrack(int rest,LinkedList<Integer> combination,List<List<Integer>> results,int target,int[] candidates,int start)
    {
        if(rest==0)
        {
            results.add(new ArrayList<>(combination));
        }
        
        if(rest<0)
        {
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            combination.add(candidates[i]);
            backtrack(rest-candidates[i],combination,results,target,candidates,i);
            combination.removeLast();
        }
        
    }
    
  
}