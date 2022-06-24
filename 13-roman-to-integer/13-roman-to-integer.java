class Solution {
    
     static Map<Character, Integer> values = new HashMap<>();
    
    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
    public int romanToInt(String s) {
        
       int result=values.get(s.charAt(s.length()-1));
        
        
        for(int i=s.length()-2;i>=0;i--)
        {
           char c1=s.charAt(i);
           char c2=s.charAt(i+1);
            
            if(values.get(c1)<values.get(c2))
            {
                result-=values.get(c1);
            }else
            {
                result+=values.get(c1);
            }
            
            
        }
        return result;
    }
}