package CacheService.LRUCache;

import java.util.*;

public class LRUCache<K, V> implements ICache<K, V> {
    private int maxCapacity;
    private HashMap<K, ListNode<K, V>> map;
    private DobuleLinkedListNode<K, V> dobuleLinkedListNode;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        map = new HashMap<>();
        dobuleLinkedListNode = new DobuleLinkedListNode<>();
    }

    @Override
    public V get(K key) {
        if(map.containsKey(key)){
            var curRetrievedNode=map.get(key);
            dobuleLinkedListNode.makeNodeMRU(curRetrievedNode);
            return curRetrievedNode.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        // update
        if (map.containsKey(key)) {
            var curNode = map.get(key);
            curNode.value = value;
            dobuleLinkedListNode.makeNodeMRU(curNode);
            return;
        }

        // remove LRU when size is same as capacity
        if (size()>= getMaxCapacity()) {
            var removedNode = dobuleLinkedListNode.removeLRUNode();
            if (removedNode != null) {
                map.remove(removedNode.getKey());
            }
            System.out.println("removed node is with value "+removedNode.getValue());
        }

        // new entry
        var newNode = new ListNode<>(key, value);
        map.put(key, newNode);
        dobuleLinkedListNode.addToFront(newNode);

    }

    @Override
    public void remove(K key) {
        if (map.containsKey(key)) {
            var removedNode = dobuleLinkedListNode.removeNode(map.get(key));
            if(removedNode!=null){
                map.remove(removedNode.getKey());
            }
        }
    }

    @Override
    public int size() {
       return map.size();
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

}
