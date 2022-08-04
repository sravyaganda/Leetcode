class MedianFinder {

   PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
      
        maxHeap=new PriorityQueue<Integer>((a,b)->b-a);
        minHeap=new PriorityQueue<Integer>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || maxHeap.peek()>=num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        
         if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
      
    }
    
    public double findMedian() {
        
        if(maxHeap.size()==minHeap.size())
        {
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        else
        {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */