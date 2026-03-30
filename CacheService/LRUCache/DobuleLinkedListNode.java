package CacheService.LRUCache;

public class DobuleLinkedListNode<K, V> {
    private ListNode<K, V> head;
    private ListNode<K, V> tail;

    public DobuleLinkedListNode() {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.prev = head;
    }

    public void addToFront(ListNode<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    public ListNode<K, V> removeNode(ListNode<K, V> node) {
        if (node == head || node == tail) {
            return null;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }

    public void makeNodeMRU(ListNode<K, V> node) {
        if (removeNode(node)!=null) {
            addToFront(node);
        }
    }

    public ListNode<K, V> removeLRUNode() {
        if(tail.prev==head){
            return null;
        }
        return removeNode(tail.prev);
    }
}
