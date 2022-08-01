class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n=nums.length;
        int[] result=new int[n];
        int left=0;
        int right=n-1;
        
        for(int i=n-1;i>=0;i--)
        {
            int num;
            if(Math.abs(nums[left])<Math.abs(nums[right]))
            {
                num=nums[right--];
            }
            else 
            {
                num=nums[left++];
            }
            result[i]=num*num;
        }
        return result;
        
    }
}