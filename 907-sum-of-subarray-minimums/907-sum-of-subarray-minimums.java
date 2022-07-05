class Solution {
    public int sumSubarrayMins(int[] arr) {
      
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        long count = 0;
        double mod=(1e9 +7);
        
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()]>arr[i])){
                int mid = stack.pop();
                int l = mid - (stack.isEmpty() ? -1 : stack.peek());
                int r = i - mid;
                
                count += (long)arr[mid]*(l)*(r);
                count%=mod;
            }
            stack.push(i);
        }
        
        return (int)(count);
    }
}