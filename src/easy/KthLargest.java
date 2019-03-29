package easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
	public static void main(String[] args) {
		PriorityQueue<Integer> tem = new PriorityQueue<>();
		tem.offer(1);
		tem.offer(3);
		tem.offer(2);
		System.out.println(tem.peek());
		System.out.println();
		tem.poll();
		System.out.println(tem.peek());
	}
	
	
    
	PriorityQueue<Integer> tem = null;
	int size = 0;
	
    public KthLargest(int k, int[] nums) {
        size = k;
        tem = new PriorityQueue<Integer>(k);
        for (int i : nums) {
			add(i);
		}
    }
    
    public int add(int val) {
    	if(size > tem.size() ){
    		tem.offer(val);
    	}else {
			if(tem.peek() > val){
				tem.poll();
				tem.offer(val);
			}
		}
    	return tem.peek();
    }
}
