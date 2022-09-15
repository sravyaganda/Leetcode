class Vector2D {

    private List<Integer> flatVector=new ArrayList<>();
    private int pointer=0;
    public Vector2D(int[][] vec) {
        
        for(int[] vector:vec)
        {
            for(int num:vector)
            {
                flatVector.add(num);
            }
        }
    }
    
    public int next() {
        
        int number=flatVector.get(pointer++);
        return number;
    }
    
    public boolean hasNext() {
        
       return pointer<flatVector.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */