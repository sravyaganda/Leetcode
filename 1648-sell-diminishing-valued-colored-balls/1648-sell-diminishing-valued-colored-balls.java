class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
    Arrays.sort(inventory);
        int n = inventory.length;
        long result = 0;
        for(int i = n-1; i >= 0; i--)
        {
            long diff = inventory[i] - (i > 0 ? inventory[i-1]: 0);
            long x = Math.min((long)orders, (n - i) * diff);
            long r = inventory[i];
            long l = r - x/(n - i);
            
            result += ((r * (r+1)/2 ) - (l * (l+1)/2)) * (n - i);
            result %= 1000000007;
            
            result += l * (x % (n - i));
            result %= 1000000007;
            orders -= x;
        }
        
        return (int)result;
        
    }
}