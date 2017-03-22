import java.util.Iterator;

/**
 * Created by Ilgiz on 26.09.2016.
 */
public class MyHashTable<K, V> implements Iterable {
    private final double LOAD_CAPACITY = 0.5;

    private Object[] table;
    private int capacity;
    private int q;
    private int size;

    @Override
    public Iterator iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator {
        int i;

        public HashTableIterator() {
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            while (i < capacity && table[i] == null) i++;

            return i < capacity;
        }

        @Override
        public Object next() {
            return ((Entry) table[i++]).getValue();
        }
    }

    private class Entry {
        K key;

        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public MyHashTable(int capacity) {
        int n = (int) (capacity / LOAD_CAPACITY);

        this.capacity = SieveOfEratosthenes.getInstance(n).getNextPrimary(n);
        this.q = SieveOfEratosthenes.getInstance(n).getPrevPrimary(n);

        table = new Object[this.capacity];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        Entry entry = new Entry(key, value);
        int hash = firstHash(key);

        if (table[hash] == null) {
            table[hash] = entry;
            size++;
            return null;
        }

        int i = 0;
        while (table[hash] != null) {
            if ((i > capacity) &&
                    (size + 1 == capacity)) {
                throw new ArrayIndexOutOfBoundsException(capacity);
            }

            Entry old = (Entry) table[hash];
            V oldValue = old.getValue();

            if (old.getKey().equals(key)) {
                old.setValue(value);
                return oldValue;
            }

            hash = secondHash(key, hash);
            i++;
        }

        size++;

        table[hash] = entry;
        return null;
    }

    public V get(K key) {
        int hash = firstHash(key);

        int i = 0;
        while (table[hash] != null) {
            if ((i > capacity) &&
                    (size + 1 == capacity)) {
                break;
            }

            Entry entry = (Entry) table[hash];

            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }

            hash = secondHash(key, hash);
            i++;
        }

        return null;
    }

    public V remove(K key) {
        int hash = firstHash(key);

        int i = 0;
        while (table[hash] != null) {
            if ((i > capacity) &&
                    (size + 1 == capacity)) {
                break;
            }

            Entry entry = (Entry) table[hash];

            if (entry.getKey().equals(key)) {
                V old = entry.getValue();
                table[hash] = null;
                size--;
                return old;
            }

            hash = secondHash(key, hash);
            i++;
        }

        return null;
    }

    private int secondHash(K key, int hash) {
        int d = q - firstHash(key) % q;
        return (hash + d) % capacity;
    }

    private int firstHash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }
}
