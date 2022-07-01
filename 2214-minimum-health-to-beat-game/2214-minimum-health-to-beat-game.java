class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
      long maxHealth=0;
        long result=1;
        
        for(int i:damage)
        {
            maxHealth=Math.max(i,maxHealth);
            result+=i;
        }
        
        return result-=Math.min(maxHealth,armor);
    }
}