class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] version1Arr=version1.split("\\.");
        String[] version2Arr=version2.split("\\.");
        
        //System.out.println(version1Arr.length +" - "+version2Arr.length );
        int i=0,j=0;
        
        while(i<version1Arr.length || j<version2Arr.length)
        {
            int num1= i<version1Arr.length? Integer.valueOf(version1Arr[i]):0;
            int num2= j<version2Arr.length?Integer.valueOf(version2Arr[j]):0;
            
            
            if(num1==num2)
            {
                i++;
                j++;
                continue;
            }
            else if(num1<num2)
            {
                return -1;
                
            }
            else if(num2<num1)
            {
                return 1;
            }
        }
        
        
        return 0;
        
    }
}