class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0 || (x%10==0 && x!=0))
        {
            return false;
        }
        
        int lastHalf=0;
        
        while(x>lastHalf)
        {
            lastHalf=lastHalf *10 +x %10;
            x/=10;
        }
        
        return x==lastHalf || x== lastHalf/10;
        
    }
}