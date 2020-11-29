package LeetCode;

class MyHashMap {

    private int[] arr;

    public MyHashMap() {
        this.arr = new int[1000000];

        //need to set all values to -1 since key and values will be >=0
        for(int i = 0; i < this.arr.length; i++){
            this.arr[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.arr[key] = value;
    }

    public int get(int key) {
        return this.arr[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.arr[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(0,100);
        System.out.println(map.get(0));
        map.remove(0);
        System.out.println(map.get(0));
    }
}