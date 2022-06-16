class Solution {
    public String longestPalindrome(String s) {
        
        int start=0;
        int maxLength=1;
        int n=s.length();
        
        if(s.length()==1)
        {
            return s;
        }
        
        boolean[][] dp=new boolean[n][n];
        
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
        }
        
        for(int i=0;i<n-1;i++)
        {
            dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
            start=dp[i][i+1]?i:start;
            maxLength=dp[i][i+1]?2:maxLength;
        }
        
           for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
 
                if (dp[i + 1][j - 1]
                    && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return s.substring(start,start + maxLength);
        
    }
}