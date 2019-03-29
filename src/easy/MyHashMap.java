package easy;

public class MyHashMap {

	
	Integer []tem;
	final int max = Integer.MAX_VALUE;
    /** Initialize your data structure here. */
    public MyHashMap() {
        tem = new Integer[max];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        tem[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(tem[key] != null){
        	return -1;
        }else {
			return tem[key];
		}
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        tem[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */