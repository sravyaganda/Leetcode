class Solution {
    
    List<List<Integer>> result;
    int[] numbers;
    public List<List<Integer>> permute(int[] nums) {
        
       result=new ArrayList();
       numbers=nums; 
      
        backtrack(new ArrayList<Integer>());
        
        return result;
    }
    
    public void backtrack(ArrayList<Integer> nums )
    {
        if(nums.size()==numbers.length)
        {
            result.add(new ArrayList(nums));
            return;
        }
        
        
        for(int i=0;i<numbers.length;i++)
        {
            if(nums.contains(numbers[i]))
            {
                continue;
            }
                if(nums.add(numbers[i]));
                backtrack(nums);
                nums.remove(nums.size()-1);
        }
    }
}