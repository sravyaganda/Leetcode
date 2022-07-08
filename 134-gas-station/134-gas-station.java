class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total_tank=0;
        int cur_tank=0;
        int index=0;
        
        for(int i=0;i<gas.length;i++)
        {
            total_tank+=gas[i]-cost[i];
            cur_tank+=gas[i]-cost[i];
            
            if(cur_tank<0)
            {
                index=i+1;
                cur_tank=0;
            }
        }
        return total_tank>=0?index:-1;
        
    }
}