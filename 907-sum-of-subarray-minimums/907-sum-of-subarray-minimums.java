class Solution {
    public int sumSubarrayMins(int[] arr) {
      
        Stack<Integer> stack=new Stack();
        int[] previousLess=new int[arr.length];
        int[] nextLess=new int[arr.length];
        Arrays.fill(nextLess,arr.length);
        
        for(int i=0;i<arr.length;i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
            {
                nextLess[stack.pop()]=i;
            }
            
            previousLess[i]=stack.isEmpty() ? -1:stack.peek();
            
            stack.push(i);            
        }
        
        long sum=0;
        double mod=1e9 +7;
        
        for(int i=0;i<arr.length;i++)
        {
            long left=i-previousLess[i];
            long right=nextLess[i]-i;
            
            sum+=arr[i]*(left*right);
            sum%=mod;
        }
        
        return (int)sum;
    }
}