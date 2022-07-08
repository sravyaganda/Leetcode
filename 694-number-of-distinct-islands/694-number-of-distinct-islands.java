class Solution {
    public  int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    private int[][] grid;    
    private boolean[][] seen;
    private Set<Pair<Integer,Integer>> currentIsland;
    private int currRowOrigin;
    private int currColOrigin;
    
    public int numDistinctIslands(int[][] grid) {
        this.grid=grid;
        this.seen=new boolean[grid.length][grid[0].length];
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
        for(int row=0;row<grid.length;row++)
        {
            for(int col=0;col<grid[0].length;col++)
            {
                this.currentIsland=new HashSet<>();
                this.currRowOrigin=row;
                this.currColOrigin=col;
                dfs(row,col);
                if(!currentIsland.isEmpty()) islands.add(currentIsland);
            }
        }
        return islands.size();
        
    }
    
    private void dfs(int row, int col)
    {
        if(row<0|| row>=grid.length|| col<0 || col>=grid[0].length)
        {
            return;
        }
        if(grid[row][col]==0|| seen[row][col])
        {
            return ;
        }
        seen[row][col]=true;
        currentIsland.add(new Pair<>(row-currRowOrigin,col-currColOrigin));
        for(int d=0;d<4;d++)
        {
            dfs(row+directions[d][0],col+directions[d][1]);
        }
    }
}