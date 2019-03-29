package match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyContest121 {
	public static void main(String[] args) {

		
	
		int []days = {1,2,3};
		int []costs = {1,2,3,4};
		mincostTickets(days, costs);
	}
	public static int mincostTickets(int[] days, int[] costs) {
		//dp数组记录的是存储的是第i天所花费的最小价格
		int dp[] = new int[366];
		List<Integer> tem = new ArrayList<>();
		for (int i = 0; i < days.length; i++) {
			tem.add(days[i]);
		}
		System.out.println(tem.toString());
		for (int i = 1; i < 366; i++) {
			if(tem.contains(i)){
				//如果第i天已经在旅行了，那么需要更新一下dp数组
				//选择买一天的卡	
				System.out.println("包含"+ i);
				int get1 = dp[i - 1] + costs[0];
				//选择买七天的卡，那么i的值必须大于等于7才行
				int get2 = Integer.MAX_VALUE;
				if(i >= 7){
					get2 = dp[i -7] + costs[1]; 
				}else {
					get2 = costs[1];
				}
				//选择买三十天的卡，那么i的值必须大于等于30才行
				int get3 = Integer.MAX_VALUE;
				if(i >= 30){
					get3 = dp[i - 30] + costs[2];
				}else {
					get3 = costs[2];
				}
				//找到那种情况是最小的
				get1 = Math.min(get1, get2);
				dp[i] = Math.min(get1, get3);
			}else {
				//否则就是前一天的最小值
				dp[i] = dp[i - 1];
			}
		}
		System.out.println(Arrays.toString(dp));
        
		return dp[365];
    }
	
	Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String,String>>();
    public void set(String key, String value, int timestamp) {
        Map<String , String> temMap = new HashMap<>();
        temMap.put(key, value);
        result.put(timestamp, temMap);

    }
    
    public String get(String key, int timestamp) {
        if(result.size() == 0){
        	return "";
        }else {
			while (timestamp >= 1) {
				if(result.get(timestamp) != null){
					Map<String, String> tems = result.get(timestamp);
					if(tems.get(key) != null){
						return tems.get(key);
					}
				}
				timestamp --;
			}
			return "";
		}
    }
	
	
	public static String strWithout3a3b(int A, int B) {
		StringBuilder result = new StringBuilder();
		if(A <= B){
			//还需要多插入chazhi个b
			int chazhi = B - A;
			int index = 0;
			while (index < A) {
				result.append("b").append("a");
				index ++;
			}
			int inde = 0;
			while (chazhi > 0) {
				chazhi --;
				System.out.println("插入的索引是："+ inde);
				if(inde > result.length()){
					result.insert(result.length(), "b");
					continue;
				}
				result.insert(inde, "b");
				inde += 3;
			}
			
		}else {
			//还需要多插入chazhi个a
			int chazhi = A - B;
			int index = 0;
			while (index < B) {
				result.append("a").append("b");
				index ++;
			}
			int inde = 0;
			while (chazhi > 0) {
				chazhi --;
				if(inde > result.length()){
					result.insert(result.length(), "a");
					continue;
				}
				result.insert(inde, "a");
				inde +=3;
			}
			
			
		}
		
		return new String(result);
	}
}
