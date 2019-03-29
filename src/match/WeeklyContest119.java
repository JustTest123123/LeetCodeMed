package match;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Templates;

public class WeeklyContest119 {
	public static void main(String[] args) {
	
		System.out.println( -5 % 5);
		int A[] = {0,-5};
		System.out.println(subarraysDivByK(A, 10));
	}
//21点10分
	public int[][] kClosest(int[][] points, int K) {
        if(K >= points.length){
        	return points;
        }
        int result [][] = new int[K][2];
        Map<Integer, Integer> tem = new HashMap<Integer, Integer>();
        //将坐标和其对应的值放入map中去
        for (int i = 0; i < points.length; i++) {
			tem.put(i, points[i][0] * points[i][0] + points[i][1] * points[i][1] );
		}
        for (int i = 0; i < result.length; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			for(Map.Entry<Integer, Integer> entry:tem.entrySet()){
				if(entry.getValue() < min){
					index = entry.getKey();
					min = entry.getValue();
				}
			}
			result[i][0] = points[index][0];
			result[i][1] = points[index][1];
			tem.remove(index);
		}
        
        
        return result;
    }
	//21点23分
	public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2 ;i--) {
			if(A[i] < A[i - 1] + A[i-2]){
				return (A[i] + A[i - 1] + A[i-2]);
			}
		}
        return 0;
    }
	//21点26分
	public static int subarraysDivByK(int[] A, int K) {
     /*  //从一开始进行循环
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] % K;
		}
		
		
       //超时了
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] % K == 0){
				result ++;
			}
			int tem = A[i];
			for (int j = i+1; j < A.length; j++) {
				tem+= A[j];
				if(tem% K == 0){
					result ++;
				}
			}
		}
		return result;*/
		int result = 0;
		int sum[] = new int[A.length + 1];
		//得出前i个的和
		for (int i = 0; i < A.length; i++) {
			sum[i + 1] = sum[i] + A[i];
			sum[i + 1] = sum[i + 1] % K;
		}
		System.out.println(Arrays.toString(sum));
		int tem[] = new int[K];
		for (int i = 0; i < A.length; i++) {
			if(sum[i] < 0){
				sum[i] = K + sum[i];
			}
			tem[sum[i]]++;
		}
		for (int i = 0; i < K; i++) {
			if(tem[i] >= 2){
				int linshi = tem[i] * (tem[i] - 1);
				result +=  linshi / 2;
			}
		}
		
		
		return result;
		
		
    }
}
