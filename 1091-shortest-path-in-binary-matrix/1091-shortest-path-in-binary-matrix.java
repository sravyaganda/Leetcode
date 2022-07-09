class Solution {
    
    public  int row;
    public  int col;
    //public final int[][] grid;
    public final int[][] directions={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        row=grid.length;
        col=grid[0].length;
        if(grid[0][0]!=0|| grid[row-1][col-1]!=0)
        {
            return -1;
        }
        
        Queue<int[]> q=new LinkedList<>();
        
        q.add(new int[]{0,0});
        grid[0][0]=1;
        
        while(!q.isEmpty())
        {
            int[] cell=q.poll();
            int distance=grid[cell[0]][cell[1]];
           
                for(int d=0;d<directions.length;d++)
                {
                    int newRow=cell[0]+directions[d][0];
                    int newCol=cell[1]+directions[d][1];
                    if(newRow>=0&& newRow<row&&newCol>=0&&newCol<col){
                    
                    if(grid[newRow][newCol]==0)
                    {
                        q.add(new int[]{newRow,newCol});
                        grid[newRow][newCol]=distance+1;
                    }}
                }
          
        }
        
        if(grid[row-1][col-1]==0)
        {
            return -1;
        }
        
        return grid[row-1][col-1];
    }
}