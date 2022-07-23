class Solution {
    List<String> result=new ArrayList();
  private Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
        {
            return result;
        }        
        phoneDigits=digits;
        backtrack(0,new StringBuilder());
        return result;
        
        
        
    }
    
    public void backtrack(int index,StringBuilder path)
    {
        if(index>phoneDigits.length())
        {
            return;
        }
        if(path.length()==phoneDigits.length())
        {
            result.add(path.toString());
            return;
        }
        
        String combinationLetters=map.get(phoneDigits.charAt(index));
        
        for(char c:combinationLetters.toCharArray())
        {
            path.append(c);
            backtrack(index+1,path);
            path.deleteCharAt(index);
        }
    }
}