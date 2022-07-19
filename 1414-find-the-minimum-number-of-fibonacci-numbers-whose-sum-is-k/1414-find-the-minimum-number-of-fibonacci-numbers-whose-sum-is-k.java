class Solution {
    public int findMinFibonacciNumbers(int k) {
        
       int ans = 0;

        while (k > 0) {
            int fib2 = 1;
            int fib1 = 1;
            while (fib1 <= k) {
                int temp = fib2+ fib1;
                fib2 = fib1;
                fib1 = temp;
            }
            k -= fib2;
            ans += 1;
        }
        return ans;
        
    }
}