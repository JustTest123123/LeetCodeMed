package hard;

import java.util.Arrays;

public class Hard {
	public static void main(String[] args) {
		int[] arr = new int[]{8,2,1,0,3};
		int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
		String tel = new String();
		for (int i:index) {
			tel += arr[i];
		}
		System.out.println(tel);
	}
	public int splitArray(int[] nums, int m) {
		long left = nums[0];
		long sum = 0;
		for (int i : nums) {
			sum += i;
			left = i > left ? i:left;
		}
		if(m == 1){
			return (int) sum;
		}
		if (m == nums.length) {
			return (int) left;
		}
        long right = sum;
        while (left != right) {
        	long mid = (left + right) >> 1;
        	int need = 1;
        	int cur = 0;
        	for (int i : nums) {
				if(cur + i > mid){
					cur = 0;
					need ++;
				}
				cur += i;
			}
        	if(need > m){
        		left = mid + 1;
        	}else {
				right = mid;
			}
        	
		}
        
        return (int) left;
    }
	
	
	
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int tem = nums1.length + nums2.length;
		//用size来表示新建数组的已有数字
		int size = 0;
		//如果是奇数那么需要的是中间的那个
		if((tem & 1) == 1){
			
		
			
			
		}else {
			
			
			
		
		}
		
		
		return 0.0;
		
		
    }
	public int findMinStep(String board, String hand) {
		//21点47分
		
		
        return 0;
    }
}
