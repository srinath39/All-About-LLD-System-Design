package CacheService.LRUCache;

public class ListNode<K,V>{
    public ListNode<K,V> prev;
    public ListNode<K,V> next;
    public K key;
    public V value;

    public ListNode(){
    }

    public ListNode(K k,V v){
        this.key=k;
        this.value=v;
        this.prev=null;
        this.next=null;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}