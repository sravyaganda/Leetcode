class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
       int n = s.length();
  
    int[] total = new int[n];
    total[0] = s.charAt(0)=='*' ? 1 : 0;
          System.out.print(0 +"-"+total[0]+"  ");
    for(int i = 1; i<n; i++) 
    {  total[i] = s.charAt(i)=='*' ? total[i-1]+1 : total[i-1];
        System.out.print(i +"-"+total[i]+"  ");}
    
   System.out.println();
    int[] left = new int[n];
    left[0] = s.charAt(0)=='|' ? 0 : -1;
    System.out.print(0 +"-"+left[0]+"  ");
    for(int i = 1; i<n; i++) 
    {  left[i] = s.charAt(i)=='|' ? i : left[i-1];
        System.out.print(i +"-"+left[i]+"  ");
    }
    
       
   System.out.println();
    int[] right = new int[n];
    right[n-1] = s.charAt(n-1)=='|' ? n-1 : -1;
      //  System.out.print(9 +"-"+right[9]+"  ");
    for(int i = n-2; i>=0; i--) 
    { right[i] = s.charAt(i)=='|' ? i : right[i+1];
     System.out.print(i +"-"+right[i]+"  ");
    }
    
    
    int[] ans = new int[queries.length];
    int i = 0;
    for(int[] q:queries) {
        int start = right[q[0]];
        int end = left[q[1]];            
        if(start==-1 || end==-1 || start>end) 
            ans[i++] = 0;
        else
            ans[i++] = total[end]-total[start];
    }
    return ans;

       
    }
}