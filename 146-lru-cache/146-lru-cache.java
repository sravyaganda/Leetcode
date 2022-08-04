class LRUCache {
       
    class DLinkedNode
    {
        int key;
        int value;
        DLinkedNode prev,next;
    }
    
    public void addNode(DLinkedNode node)
    {
        node.prev=head;
        node.next=head.next;
        
        head.next.prev=node;
        head.next=node;
        
    }
    
    public void removeNode(DLinkedNode node)
    {
        DLinkedNode prev=node.prev;
        DLinkedNode next=node.next;
        
        prev.next=next;
        next.prev=prev;
    }
    
    public void moveToHead(DLinkedNode node)
    {
        removeNode(node);
        addNode(node);
        
    }
    
    public DLinkedNode popTail()
    {
              DLinkedNode node=tail.prev;
        removeNode(node);
        return node;
    }
    
   
  HashMap<Integer,DLinkedNode> cache;
    int size;
    int capacity;
    DLinkedNode head,tail;
    
    public LRUCache(int capacity) {
        
        cache=new HashMap();
        this.capacity=capacity;
        this.size=0;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        DLinkedNode node=cache.get(key);
        
        if(node==null)
        {
            return -1;
        }
        
        moveToHead(node);
        return node.value;
        
       
    }
    
    public void put(int key, int value) {
        
        DLinkedNode node=cache.get(key);
        
        if(node==null)
        {
            DLinkedNode newNode=new DLinkedNode();
            newNode.key=key;
            newNode.value=value;
            cache.put(key,newNode);
            addNode(newNode);
            size++;
            
            if(size>capacity)
            {
                DLinkedNode remove=popTail();
               cache.remove(remove.key);
                size--;
                
            }
            else
            {
                
            }
        }
        else
        {
            node.value=value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */