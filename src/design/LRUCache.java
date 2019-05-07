package design;

import java.util.HashMap;
import java.util.Map;

//Design and implement a data structure for Least Recently Used (LRU) cache.
// It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
// otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present.
// When the cache reached its capacity,
// it should invalidate the least recently used item before inserting a new item.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
public class LRUCache {
    class DLLNode {
        DLLNode prev;
        DLLNode next;
        int key;
        int value;

        DLLNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, DLLNode> keyToNode;
    DLLNode dummyHead;
    DLLNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        dummyHead = new DLLNode(0, 0);
        dummyTail = new DLLNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * Time: O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            DLLNode node = keyToNode.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }

    /**
     * Time: O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLLNode node;
        if (keyToNode.containsKey(key)) {
            node = keyToNode.get(key);
            node.value = value;
            remove(node);
        } else {
            //add a new node
            if (keyToNode.size() >= capacity) {
                keyToNode.remove(dummyTail.prev.key);
                remove(dummyTail.prev);
            }
            node = new DLLNode(key, value);
            keyToNode.put(key, node);
            node.value = value;
        }
        addFirst(node);
    }

    private void remove(DLLNode node) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(DLLNode node) {
        DLLNode next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = next;
        next.prev = node;
    }

}
