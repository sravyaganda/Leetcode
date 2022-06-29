class Solution {
    public int connectSticks(int[] sticks) {
        
        int totalcost=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int stick:sticks)
        {
            pq.add(stick);
        }
        
        while(pq.size()>1)
        {
            int stick1=pq.poll();
            int stick2=pq.poll();
        
            int cost=stick1+stick2;
            totalcost+=cost;
        pq.add(cost);
            
        }
        
        return totalcost;
        
    }
}