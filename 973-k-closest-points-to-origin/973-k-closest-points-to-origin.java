class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result=new int[k][2];
            
         PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(b[0]-a[0])); 
        
        for(int i=0;i<points.length;i++)
        {
        
            int[] entry= new int[]{squaredDistance(points[i]),i};
            
            if(pq.size()<k)
            {
                pq.add(entry);
            }
            else if(entry[0]<pq.peek()[0])
            {
               
                pq.poll();
                pq.add(entry);
            }
        }
        
        for(int i=0;i<k;i++)
        {
            int entryIndex=pq.poll()[1];
            result[i]=points[entryIndex];
            
        }
        return result;
    }
    
    private int squaredDistance(int[] point)
    {
        return (point[0] * point[0]) + (point[1]*point[1])
;    }
}