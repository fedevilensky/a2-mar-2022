package tads;

import java.util.ArrayList;

public class OpenHashMap<K, V> implements Map<K, V> {
    // ArrayList<Pair>[] arr
    private Object[] arr;
    private int elemCount;

    private class Pair {
        public K key;
        public V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Pair(K key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object other) {
            return this.key.equals(((Pair) other).key);
        }

        // c++
        /*
         * bool operator==(Pair<K,V> other)
         * {
         * this->key = other.key;
         * }
         */
    }

    @Override
    public void insert(K key, V value) {
        this.elemCount++;
        int pos = this.findPos(key);
        var list = (ArrayList<Pair>) this.arr[pos];
        if (list == null) {
            list = new ArrayList<Pair>();
            arr[pos] = list;
        }
        Pair p = new Pair(key, value);
        if (list.contains(p)) {
            this.elemCount--;
            list.remove(p);
        }
        list.add(p);
    }

    @Override
    public boolean contains(K key) {
        int pos = this.findPos(key);
        var list = (ArrayList<Pair>) this.arr[pos];
        if (list == null) {
            return false;
        }
        Pair p = new Pair(key);
        return list.contains(p);
    }

    @Override
    public V get(K key) throws Exception {
        // TODO Auto-generated method stub
        return null;
        /*
         * if(!list.contains(p)){
         * throw new Exception(
         * "la tabla no contiene al emeneto" + key.toString());
         * }
         */
    }

    @Override
    public void delete(K key) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return this.elemCount;
    }

    @Override
    public boolean isEmpty() {
        return this.elemCount == 0;
    }

    public OpenHashMap(int expectedSize) {
        this.arr = new Object[expectedSize * 2 - 1];
        this.elemCount = 0;
    }

    private int findPos(K key) {
        int h = key.hashCode();
        int pos = h % this.arr.length;
        return pos;
    }

}
