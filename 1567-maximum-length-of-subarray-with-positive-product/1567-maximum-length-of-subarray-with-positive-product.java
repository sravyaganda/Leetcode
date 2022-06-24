class Solution {
    public int getMaxLen(int[] nums) {
        
        // when ever the product is positive we store the length;
        
     int neg=-1,zero=-1,negCount=0,ans=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                negCount++;
                if(neg==-1)
                {
                    neg=i;
                }
            }
            
            if(nums[i]==0)
            {
                negCount=0;
                zero=i;
                neg=-1;
            }
            
            else
            {
                if(negCount%2==0)
                {
                    ans=Math.max(i-zero,ans);
                }
                else
                {
                    ans=Math.max(i-neg,ans);
                }
            }
        }
        
        return ans;
        
    }
}