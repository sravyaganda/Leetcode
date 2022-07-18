class Solution {
    
     HashSet<String> set;
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack=new Stack<Integer>();
        int result=0;
        
       set=new HashSet();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(int i=0;i<tokens.length;i++)
        {
            if(set.contains(tokens[i]))
            {
                int firstNumber=stack.pop();
                int secondNumber=stack.pop();
                stack.push(getResult(secondNumber,firstNumber,tokens[i]));
            }
            else
            {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        
        return stack.pop();
    }
    
    public int getResult(int x,int y,String operator)
    {
        if(operator.equals("*"))
        {
            return x*y;
        }
        else if(operator.equals("/"))
        {
            return x/y;
        }
        else if(operator.equals("-"))
        {
            return x-y;
        }
        return x+y;
    }
}