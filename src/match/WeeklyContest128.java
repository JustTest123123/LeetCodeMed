
package match;

import java.util.HashMap;
import java.util.Map;

public class WeeklyContest128 {
	public static void main(String[] args) {
		System.out.println(bitwiseComplement(10));
		
	}
	
	
	
	
	public int shipWithinDays(int[] weights, int D) {
		int sum = 0;
		if(D == 1){
			for (int i : weights) {
				sum += i;
			}
			return sum;
		}
		if(D == weights.length){
			int max = weights[0];
			for (int i : weights) {
				if(i > max){
					max = i;
				}
			}
			return max;
		}
		while (D > 1 ) {
			
		}
		return 0;
        
    }
	
	
	
	
/*	public int numDupDigitsAtMostN(int N) {
		
        
    }
	*/
	
	public int numPairsDivisibleBy60(int[] time) {
		for (int i = 0; i < time.length; i++) {
			time[i] = time[i] % 60;
		}
		Map<Integer, Integer> temMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < time.length; i++) {
			temMap.put(time[i], temMap.getOrDefault(time[i], 0) + 1);
		}
		int result = 0;
		for (int i = 0; i < time.length; i++) {
			for (int j =  i + 1; j < time.length; j++) {
				if((time[i] + time[j]) % 60 == 0){
					result ++;
				}
			}
		}
		return result;
		
        
    }
	
	public static int bitwiseComplement(int N) {
        int result = 0;
        int index = 0;
        if(N == 0){
        	return 1;
        }
        while (N > 0) {
        	int i = N & 1;
			int j = i ^ 1;
			if(j == 0){
				
			}else {
				result += Math.pow(2, index);
			}
			index++;
			N = N >> 1;
			System.out.println(i);
		}
        return result;
    }
		
	
}