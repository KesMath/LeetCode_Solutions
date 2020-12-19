package LeetCode;

public class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        this.set = new boolean[1000000];
    }

    public void add(int key) {
        this.set[key] = true;
    }

    public void remove(int key) {
        this.set[key] = false;
    }

    public boolean contains(int key) {
        return this.set[key];
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
