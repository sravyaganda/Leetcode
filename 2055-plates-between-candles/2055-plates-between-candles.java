class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
       int n = s.length();
    //calculate sum so far array : *-> add,  |-> keep prev
    int[] total = new int[n];
    total[0] = s.charAt(0)=='*' ? 1 : 0;
    for(int i = 1; i<n; i++) 
        total[i] = s.charAt(i)=='*' ? total[i-1]+1 : total[i-1];
    
    //calculate left : index of left star 
    int[] left = new int[n];
    left[0] = s.charAt(0)=='|' ? 0 : -1;
    for(int i = 1; i<n; i++) 
        left[i] = s.charAt(i)=='|' ? i : left[i-1];
    
    //calculate right : index of right star 
    int[] rigth = new int[n];
    rigth[n-1] = s.charAt(0)=='|' ? n-1 : -1;
    for(int i = n-2; i>=0; i--) 
        rigth[i] = s.charAt(i)=='|' ? i : rigth[i+1];
    
    //for each query based on left and rigth get a close rang and then do prefix sum (sum(j)-sum(i))
    // if there is no closed range, then add 0 as answer
    int[] ans = new int[queries.length];
    int i = 0;
    for(int[] q:queries) {
        int start = rigth[q[0]];
        int end = left[q[1]];            
        if(start==-1 || end==-1 || start>end) 
            ans[i++] = 0;
        else
            ans[i++] = total[end]-total[start];
    }
    return ans;

       
    }
}