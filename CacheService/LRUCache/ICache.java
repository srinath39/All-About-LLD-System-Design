package CacheService.LRUCache;

public interface ICache<K,V> {
    public V get(K key);
    public void put(K key, V value);
    public void remove(K key);
    public int size();
    public int getMaxCapacity();
}