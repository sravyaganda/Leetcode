class Solution {
    public int minSwaps(int[] data) {
        
        int ones=Arrays.stream(data).sum();
        
        int count=0,max_one=0;
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i:data)
        {
            q.add(i);
            count+=i;
            
            if(q.size()>ones)
            {
                count-=q.poll();
                
            }
            
            max_one=Math.max(count,max_one);
        }
        
        return ones-max_one;
        
    }
}