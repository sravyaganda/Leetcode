class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int result=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->a-b);
        for(int i=0;i<heights.length-1;i++)
        {
           int climb=heights[i+1]-heights[i];
            if(climb<=0)
            {
                continue;
            }
            pq.add(climb);
            
            if(pq.size()<=ladders)
            {
                continue;
            }
            
            bricks-=pq.remove();
            if(bricks<0)
            {
                return i;
            }
            
        }
        return heights.length-1 ;
        
    }
}