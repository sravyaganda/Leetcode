class Solution {
    public int titleToNumber(String columnTitle) {
        
        int result=0;
        int n=columnTitle.length();
        
        for(int i=0;i<n;i++)
        {
            result=result*26;
            result+= columnTitle.charAt(i)-64;
        }
        
        return result;
    }
}