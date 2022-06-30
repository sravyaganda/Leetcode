class TimeMap {

       class Node {
        int time;
        String val;
        Node next;
        
        Node(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }
    HashMap<String,Node> map;
    public TimeMap() {
      map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        Node curr=new Node(timestamp,value);
        curr.next=map.getOrDefault(key,null);
        map.put(key,curr);
    }
    
    public String get(String key, int timestamp) {
        
        Node curr=map.get(key);
        if(curr==null)
        {
            return "";
        }
        while (curr.next != null && curr.time > timestamp) { 
            curr = curr.next;
        }
        if (curr.time > timestamp) return "";
        return curr.val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */