class Solution {
    public long subArrayRanges(int[] nums) {
        
    long min=subArrayMin(nums);
    long max=subArrayMax(nums);
        
        return max-min;
       
    }
    
    public long subArrayMin(int[] arr)
    {
       Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        long count = 0;
        
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()]>arr[i])){
                int mid = stack.pop();
                int l = mid - (stack.isEmpty() ? -1 : stack.peek());
                int r = i - mid;
                
                count += (long)arr[mid]*(l)*(r);
            }
            stack.push(i);
        }
        
        return (count);
    }
    
    public long subArrayMax(int[] arr)
    {
         Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        long count = 0;
        
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()]<arr[i])){
                int mid = stack.pop();
                int l = mid - (stack.isEmpty() ? -1 : stack.peek());
                int r = i - mid;
                
                count += (long)arr[mid]*(l)*(r);
            }
            stack.push(i);
        }
        
        return (count);
    }
}