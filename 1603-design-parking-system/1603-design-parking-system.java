class ParkingSystem {
    
    int[] capacity;
    HashMap<Integer,Integer> parkSpace;
    

    public ParkingSystem(int big, int medium, int small) {
        
        parkSpace=new HashMap<Integer,Integer>();
        parkSpace.put(1,0);
        parkSpace.put(2,0);
        parkSpace.put(3,0);
        
       capacity= new int[]{big,medium,small};
    }
    
    public boolean addCar(int carType) {
        
        if(parkSpace.get(carType)<capacity[carType-1])
        {
            parkSpace.put(carType,parkSpace.get(carType)+1);
            return true;
        }
        return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */