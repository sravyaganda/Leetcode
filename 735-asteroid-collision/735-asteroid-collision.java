class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack=new Stack<Integer>();
        
        for(int ast:asteroids)
        {
          collision:{  while(!stack.isEmpty() && ast<0 && stack.peek()>0)
            {
                if(stack.peek()<-ast)
                {
                    stack.pop();
                    continue;
                }
                else if(stack.peek()==-ast)
                {
                    stack.pop();
                }
                break collision;
            }
            stack.push(ast);}
        }
        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}