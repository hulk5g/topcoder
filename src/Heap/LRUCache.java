package Heap;

import java.util.*;

/**
 * @author ksharma
 */
public class LRUCache {
    private Deque<Integer>Q;
    private Map<Integer,Integer>map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        Q=new LinkedList<Integer>();
        map=new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Integer val=map.get(key);
        if(val!=null){
            Q.remove(key);
            Q.offer(key);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Q.remove(key);
        }else{
            if(map.size()>=capacity){
                int k=Q.poll();
                map.remove(k);
            }
        }
        Q.offer(key);
        map.put(key,value);
    }
}
