package easy;

import java.util.ArrayList;
import java.util.List;

class RecentCounter {

	   int[] num;
	   int count;

     public RecentCounter() {
    	 num = new int[10000];
    	 count = 0;
    }
    
    public int ping(int t) {
        
    	
    	num[count++ ] = t;
    	
    	int result = count;
    	for (int i = 0; i < count; i++) {
			if(t - num[i] > 3000 ){
				result --;
			}else {
				
				break;
			}
		}
    	
    	
    	return result;
    	
    	
    }
}