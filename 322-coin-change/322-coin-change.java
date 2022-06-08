class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int maxAmount=amount+1;
        // Stores subproblem solutions
        int[] dp=new int[maxAmount];
      
            
            Arrays.fill(dp,maxAmount);
              dp[0]=0;
            for(int i=1;i<=amount;i++)
            {
                for(int j=0;j<coins.length;j++)
                {
                    if(coins[j]<=i)
                    {
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    }
                }
            }
        
        return dp[amount]>amount?-1:dp[amount];
    }
}