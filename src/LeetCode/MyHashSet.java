package LeetCode;

import java.util.LinkedList;

public class MyHashSet {
    private LinkedList<Integer> linkedList;

    public MyHashSet() {
        this.linkedList = new LinkedList<>();
    }

    public void add(int key) {
        if(this.contains(key) == false){
            this.linkedList.add(key);
        }
    }

    public void remove(int key) {
        if(this.contains(key) == true){
            this.linkedList.removeFirstOccurrence(key);
        }
    }

    public boolean contains(int key) {
        return this.linkedList.contains(key);
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
