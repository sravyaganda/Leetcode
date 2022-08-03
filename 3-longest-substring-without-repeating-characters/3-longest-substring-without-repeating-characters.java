class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] letters=new int[256];
       int left=0,right=0,result=0;
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            letters[c]++;
            
            while(letters[c]>1)
            {
                char c1=s.charAt(left);
                letters[c1]--;
                left++;                
            }
            
            result=Math.max(result,(right-left)+1);
            right++;
            
        }
        
        return result;
        
    }
}