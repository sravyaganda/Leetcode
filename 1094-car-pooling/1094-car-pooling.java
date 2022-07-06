class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Map<Integer,Integer> timestamp=new TreeMap<>();
        for(int[] trip:trips)
        {
            int startPassenger=timestamp.getOrDefault(trip[1],0)+trip[0];
            timestamp.put(trip[1],startPassenger);
            
            int endPassenger=timestamp.getOrDefault(trip[2],0)-trip[0];
            timestamp.put(trip[2],endPassenger);
        }
        
        int usedCapacity=0;
        for(int passenger:timestamp.values())
        {
            usedCapacity+=passenger;
            if(usedCapacity>capacity)
            {
                return false;
            }
        }
        return true;
    }
}