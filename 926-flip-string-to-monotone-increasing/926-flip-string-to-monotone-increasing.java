class Solution {
    public int minFlipsMonoIncr(String s) {
        
        
        int one=0;
        int flip=0;
        
        for(char c:s.toCharArray())
        {
            if(c=='1')
            {
                one++;
            }
            else
            {
                flip++;
            }
            flip=Math.min(flip,one);
        }
        
        return flip;
        
    }
}