class Solution {
    public long getDescentPeriods(int[] prices) {
        
          long sum = 1;
        int left = 0;
        int right = 1;
        while(right < prices.length){
            int val = prices[right];
            if(val + 1 != prices[right - 1]){
                left = right;
            }
            sum += right - left + 1;
            right++;
        }
        return sum;
        
    }
}