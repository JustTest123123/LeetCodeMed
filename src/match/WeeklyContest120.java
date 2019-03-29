package match;

import java.util.Arrays;

public class WeeklyContest120 {
	public static void main(String[] args) {
		//int A[] = {9,4,2,10,7,8,8,1,9,10,1,12,1,13,1};
		int []A = {100,100,100};
		System.out.println(maxTurbulenceSize(A));;
	}
	
	public int[] sortedSquares(int[] A) {
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] <  0 ){
				A[i] = 0 - A[i];
			}
		}
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		
		return A;
        
    }
	
	public static  int maxTurbulenceSize(int[] A) {
		int result = 0;
		if(A.length == 1 || A.length == 0)
			return 1;
		//初始化一个dayu默认为false
		boolean dayu = false;
		int index = 0;
		while (index + 1 < A.length && A[index] == A[index + 1]) {
			index ++;
		}
		if(index + 1  == A.length)
			return 0;
		if(A[index] < A[index + 1]){
			dayu = false;
		}else {
			dayu = true;
		}
		int tem = 1;
		boolean ise = false;
		System.out.println(index);
		for (int i = index + 1; i + 1 <= A.length - 1; i++) {
			if(A[i] < A[i + 1]){
				System.out.println("小于");
				if(dayu && !ise){
					tem++;
					dayu = false;
				}else {
					result = Math.max(result, tem);
					System.out.println("最大为"+result);
					tem = 1;
					dayu = false;
				}
				ise = false;
			}else if (A[i] > A[i + 1]) {
				System.out.println("大于");
				if(!dayu && !ise){
					tem ++;
					dayu = true;
				}else {
					result = Math.max(result, tem);
					tem = 1;
					System.out.println("最大为" + result);
					dayu = true;
				}
				ise = false;
			}else {
				System.out.println("等于");
				result = Math.max(result, tem);
				tem = 0;
				System.out.println("最大为"+ result);
				ise = true;
			}
		}
		
		return Math.max(result, tem) + 1;
        
    }
	
}
