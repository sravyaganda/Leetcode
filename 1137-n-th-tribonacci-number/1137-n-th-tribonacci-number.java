class Solution {
    public int tribonacci(int n) {
        
        if(n==0)
        {
            return 0;
        }
        if(n==1 || n==2)
        {
            return 1;
        }
        int first=0,second=1,third=1;
        
        int i=3;
        
        while(i<=n)
        {
           int fourth=first+second+third;
            first=second;
            second=third;
            third=fourth;
            i++;
        }
        
        return third;
        
        
        
    }
}