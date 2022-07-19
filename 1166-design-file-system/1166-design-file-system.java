class FileSystem {
HashMap<String,Integer> map;
    public FileSystem() {
        map=new HashMap();
    }
    
    public boolean createPath(String path, int value) {
        
        if(path.equals("/")|| path.length()==1 || path.isEmpty()|| map.containsKey(path))
        {
            return false;
        }
        
        int delimIndex=path.lastIndexOf("/");
        String parent=path.substring(0,delimIndex);        
        if(parent.length()>1 && !map.containsKey(parent))
        {
            return false;
        }
        
        map.put(path,value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path,-1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */