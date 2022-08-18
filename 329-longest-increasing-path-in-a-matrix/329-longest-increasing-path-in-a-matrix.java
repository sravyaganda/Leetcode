class Solution {
    
    public static final int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public static int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length==0)
            return 0;
        
        m=matrix.length;
        n=matrix[0].length;
        int[][] memo=new int[m][n];
        int ans=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans=Math.max(ans,dfs(matrix,i,j,memo));
            }
        }
        return ans;
    }
    
    public static int dfs(int[][] matrix,int i,int j,int[][] memo)
    {
        if(memo[i][j]!=0)
        {
            return memo[i][j];
        }
        for(int d=0;d<directions.length;d++)
        {
            int x=i+directions[d][0];
            int y=j+directions[d][1];
            if(x>=0 && y>=0 && x<m && y<n && matrix[x][y]>matrix[i][j])
            {
                memo[i][j]=Math.max(memo[i][j],dfs(matrix,x,y,memo));
            }
        }
        return ++memo[i][j];
    }
}