class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int max=0;
        int result=0;
        
        for(int num:map.keySet())
        {
            if(max<map.get(num))
            {
                result=num;
                max=map.get(num);
            }
        }
        return result;
    }
}