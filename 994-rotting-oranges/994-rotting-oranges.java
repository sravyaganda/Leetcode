class Solution {
    
    int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        
        
        Queue<int[]> q=new LinkedList<>();
        int minutes=0;
        int freshOranges=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    freshOranges++;
                }
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if( freshOranges==0)
        {
            return 0;
        }
        
        int[] bfsResult=bfs(q,grid, freshOranges);
        return bfsResult[0]==0?bfsResult[1]:-1;
        
    }
    
    public int[] bfs( Queue<int[]> q,int[][] grid,int freshOranges)
    {
        int minute=-1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] orange=q.poll();
                for(int d=0;d<directions.length;d++)
                {
                    int newRow=orange[0]+directions[d][0];
                    int newCol=orange[1]+directions[d][1];
                    if(newRow>=0 && newRow<grid.length && newCol>=0
                      && newCol<grid[0].length && grid[newRow][newCol]==1)
                    {
                         freshOranges--;
                        grid[newRow][newCol]=2;
                        q.add(new int[]{newRow,newCol});
                    }
                }
              
            }
              minute++;
        }
        
        return new int[]{freshOranges,minute};
    }
}