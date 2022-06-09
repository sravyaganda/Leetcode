class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return 1;
        }
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i] && dp[i]<=dp[j])
                {
                    dp[i]=1+dp[j];
                }
            }
        }
        
        int max=1;
        
        for(int i=0;i<dp.length;i++)
        {
            System.out.println(dp[i]);
            max=Math.max(max,dp[i]);
        }
        
        return max;
    }
}