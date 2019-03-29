package easy;

import java.util.HashMap;

public class Sum {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	    	HashMap hashMap = new HashMap<>();
	    	
	    	for(int i = 0; i<nums.length; i++){
	    		Integer index = (Integer) hashMap.get(target - nums[i]);
		    	if(index != null){
		    		return new int[]{index,i};
		    		
		    	}else {
					hashMap.put(nums[i], i);
				}
	    	}
			return null;
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	   /*     HashMap<Integer,Integer> map = new HashMap<>(nums.length * 2);
	        for (int i = 0; i < nums.length; i++){
	            int num = nums[i];
	            
	            Integer index = map.get(target-num);
	            if (index != null){
	                return new int[]{index, i};
	            }
	            
	            map.put(num, i);
	        }
	        
	        throw new IllegalArgumentException("No two sum solution");
	        //return null; //cant throw exception?
*/	    }
	}

}
