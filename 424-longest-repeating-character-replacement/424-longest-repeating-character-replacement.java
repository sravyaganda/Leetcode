class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character,Integer> count=new HashMap();
        
        //window
        int left=0,right=0;
        int result=0;
        int maxFreq=0;
        
        for(int i=0;i<s.length();i++)
        {
            right=i;
            char c=s.charAt(right);
            count.put(c,count.getOrDefault(c,0)+1);
            int windowSize=(right-left)+1;
             maxFreq=Math.max(maxFreq,count.get(c));
            
            if(windowSize-maxFreq<=k)
            {
             result=Math.max(result,windowSize);   
            }
            else
            {
                char remove=s.charAt(left);
                count.put(remove,count.get(remove)-1);
                left++;
            }
            
        }
        return result;
    }
}