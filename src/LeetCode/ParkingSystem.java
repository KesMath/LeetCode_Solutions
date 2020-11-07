package LeetCode;
import java.util.HashMap;

public class ParkingSystem {
    private HashMap<Integer,Integer> parkingSlots = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        if (big >= 0 && medium >=0 && small >=0){
            this.parkingSlots.put(1,big);
            this.parkingSlots.put(2,medium);
            this.parkingSlots.put(3,small);
        }
    }

    public boolean addCar(int carType) {
        boolean hasSpace = false;
        if (carType == 1 || carType == 2 || carType==3){
            int carTypeCapacity = this.parkingSlots.get(carType);
            if (carTypeCapacity != 0){
                this.parkingSlots.put(carType, --carTypeCapacity);
                hasSpace = true;
            }
        }
        return hasSpace;
    }

    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(1,1,0);
        System.out.println(p.addCar(1));
        System.out.println(p.addCar(2));
        System.out.println(p.addCar(3));
        System.out.println(p.addCar(1));
    }
}
