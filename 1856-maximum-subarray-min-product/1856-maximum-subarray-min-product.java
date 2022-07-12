class Solution {
    static int MOD = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        
         int n = nums.length;
        int[] left = new int[n]; // index of previous element < num[i]
        int[] right = new int[n]; // index of next element <= nums[i]
        Arrays.fill(right, -1);
        Stack<Integer> monoStack = new Stack<>(); // increasing
        
        for (int i = 0; i < n; i++){
            while (!monoStack.isEmpty() && nums[ monoStack.peek() ] >= nums[i] ) {
                right[monoStack.pop()] = i;
            }
            
            left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }
        
        long[] prefixSum = new long[n + 1]; // 1 based
        for (int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        long max = 0;
        for (int i = 0; i < n; i++ ) {
            int rightIndex = right[i] == -1 ? n : right[i];
            int leftIndex = left[i];
            long sum = prefixSum[rightIndex] - prefixSum[leftIndex + 1];
            max = Math.max(max, sum * nums[i]);
        }
        
        return (int)( max % MOD );
    }
    
}