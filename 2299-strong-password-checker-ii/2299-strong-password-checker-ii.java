class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        if(password.length()<8)
        {
            return false;
        }
        HashSet<Character> set=new HashSet<>();
        //!@#$%^&*()-+
        set.add('!');
        set.add('@');
        set.add('#');
        set.add('$');
        set.add('%');
        set.add('^');
        set.add('*');
        set.add('&');
        set.add('(');
        set.add(')');
        set.add('-');
        set.add('+');
        boolean uppercaseCheck=false,lowercaseCheck=false,numberCheck=false,specialcharacterCheck=false;
        int[] letters=new int[128];
        Arrays.fill(letters,0);
        
        for(int i=0;i<password.length();i++)
        {
            char c=password.charAt(i);
            
            if(i!=0 && c==password.charAt(i-1))
            {
                return false;
            }
            
            if(Character.isLetter(c) && Character.isLowerCase(c))
            {
                letters[c]++;
                lowercaseCheck=true;
            }
             if(Character.isLetter(c) && Character.isUpperCase(c))
            {
                letters[c]++;
                uppercaseCheck=true;
            }
              if(Character.isDigit(c))
            {
                letters[c]++;
                numberCheck=true;
            }
            
            if(!Character.isLetterOrDigit(c))
            {
                if(!set.contains(c))
                {
                    return false;
                }
                else
                {
                 letters[c]++;
                specialcharacterCheck=true;
                }
            }
        }
        
        System.out.println(uppercaseCheck);
        
        return uppercaseCheck && lowercaseCheck&&numberCheck&&specialcharacterCheck ;
    }
}