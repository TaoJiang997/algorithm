package tracy.algorithm.engineer.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: tracy
 * Time: 2015/7/20 14:55
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int cacheSize;

    public LRUCache(int cacheSize){
        /**
         *tracy(2015-7-20): third param 'true' means using access-order,thus the cache will
         * move the element to the end of the list(LinkedHashMap is a doubly linked list,the newest element
         * is at the end of the list) after Map.get or Map.set;
         */
        super(16,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() >= cacheSize;
    }

}
