class Solution {
    public int calculate(String s) {
        
        if(s==null || s.isEmpty())
            return 0;
        
        int length=s.length();
        int currentNumber=0,lastNumber=0,result=0;
        char operator= '+';
        
        for(int i=0;i<length;i++)
        {
            char currentChar=s.charAt(i);
            
            if(Character.isDigit(currentChar))
            {
                currentNumber=(currentNumber*10)+(currentChar-'0');
            }
            
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i==length-1)
            {
                if(operator=='+' || operator=='-')
                {
                    result+=lastNumber;
                    lastNumber=(operator=='+')?currentNumber : -currentNumber;
                }
                else if(operator=='*')
                {
                    lastNumber=lastNumber*currentNumber;
                }
                else if(operator=='/')
                {
                    lastNumber=lastNumber/currentNumber;
                }
                operator=currentChar;
                currentNumber=0;
            }
        }
        result +=lastNumber;
        return result;
    }
}