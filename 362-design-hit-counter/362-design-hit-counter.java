class HitCounter {

    Deque<Integer> dq ;
    public HitCounter() {
        dq= new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        dq.offerLast(timestamp);
    }
    
    public int getHits(int timestamp) {
        
       removeOldEntries(timestamp);
        
        return dq.size();
    }
    
    public void removeOldEntries(int timestamp)
    {
        while(!dq.isEmpty() && dq.peekFirst()<=timestamp-300) 
        {dq.pollFirst();} 
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */