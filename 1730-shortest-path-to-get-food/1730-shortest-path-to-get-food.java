class Solution {
       int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
   
    public int getFood(char[][] grid) {
        
        Queue<int[]> q=new LinkedList();
        int row=grid.length;
        int col=grid[0].length;
        boolean found=false;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='*')
                {
                    q.add(new int[]{i,j,0});
                    break;
                }
            }
            if(found)
            break;
        }
    
        return bfs(q,grid);
      
    }
    
    public int bfs(Queue<int[]> q,char[][] grid)
    {
        int row=grid.length;
        int col=grid[0].length;
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                int[] cell=q.poll();
                
                for(int d=0;d<4;d++)
                {
                    int newRow=cell[0]+directions[d][0];
                    int newCol=cell[1]+directions[d][1];
                    int distance=cell[2];
                    if(newRow<row && newRow>=0 && newCol<col && newCol>=0 && grid[newRow][newCol]!='X')
                    {
                        if(grid[newRow][newCol]=='#')
                        {
                            
                           return distance+1;
                        }
                        else if( newRow<row && newRow>=0 && newCol<col && newCol>=0 &&grid[newRow][newCol]=='O')
                        {
                            grid[newRow][newCol]='X';
                            q.add(new int[]{newRow,newCol,distance+1});
                        }
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    
}