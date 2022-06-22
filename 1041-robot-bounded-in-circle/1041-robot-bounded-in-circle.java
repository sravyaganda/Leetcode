class Solution {
    public boolean isRobotBounded(String instructions) {
        
        // north=0,east=1,south=2,west=3;
        
        int x=0;
        int y=0;
        int[][] directions=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        
        int index=0;
       for(char step:instructions.toCharArray())
       {
          if(step=='L')
          {
              index=(index+3)%4;
          }
           else if(step=='R')
           {
               index=(index+1)%4;
           }
           else
           {
               x+=directions[index][0];
               y+=directions[index][1];
           }
       }
        
        return (x==0 && y==0) || (index!=0);
    }
}