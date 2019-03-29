
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


import easy.TreeNode;
@SuppressWarnings("all")
public class Med {

	
	
	//20点44分
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int gas1 [] = new int[gas.length * 2];
        int cost1[] = new int[cost.length * 2];
        //将数组进行扩展，避免麻烦
        for (int i = 0; i < gas1.length; i++) {
			gas1[i] = gas[i % gas.length];
		}
        
        for (int i = 0; i < gas1.length; i++) {
			cost1[i] = cost[i % gas.length];
		}
        int len = gas.length;
        int index = 0;
        int shengyu = 0;
        for (int i = 0; i < len; i++) {
			shengyu = 0;
			int end = i + len;
			boolean flag = true;
			for (int j = i; j < end; j++) {
				if(shengyu + gas1[j] - cost1[j] >= 0){
					shengyu = shengyu + gas1[j] - cost1[j]; 
					continue;
				}
				flag = false;
			}
			if(flag){
				return i;
			}
		}
        return -1;
        
        
        
    }
	//22点02分
	public int magicalString(int n) {
        if(n == 0){
        	return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        int indexA = 2;
        int k = 1;
        while (list.size() < n) {
        	if(list.get(indexA) == 2){
        		list.add(k);
        		list.add(k);
        	}
        	if(list.get(indexA) == 1){
        		list.add(k);
        	}

        	k = k == 1 ? 2 : 1;
        	indexA ++;
		}
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	if(list.get(i) == 1){
				sum += list.get(i);
			}
			
		}
        return sum;
    }
	
	public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null){
        	return sum;
        }
        List<Integer> tem = new ArrayList<>();
        
        get(root,0,tem);
        
        for (Integer integer : tem) {
			sum += integer;
		}
        return sum;
    }

	public static void get(TreeNode root,int sum,List<Integer>tem){
		if(root.left == null && root.right == null){
			sum = sum * 10 + root.val;
			tem.add(sum);
		}
		sum = sum * 10 + root.val;
		if(root.left != null){
		
			get(root.left, sum, tem);
		}
		
		if(root.right != null){
			get(root.right, sum, tem);
		}
		
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length <= 3){
        	return result;
        }
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if(nums[i] + nums[j] + nums[left] + nums[right] == target){
						List<Integer> tem = new ArrayList<>();
						tem.add(nums[i]);
						tem.add(nums[j]);
						tem.add(nums[left]);
						tem.add(nums[right]);
						int size = set.size();
						set.add(tem);
						if(size > set.size()){
							result.add(tem);
						}
						left ++;
						right --;
					}else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						left ++;
					}else {
						right --;
					}
					
				}
			}
		}
        return result;
    }
	
	 public static int minEatingSpeed(int[] piles, int H) {
		 //首先判断的是H的次数多少
		 int sum = 0;
		 int max = piles[0];
		 for (int i : piles) {
			sum += i;
			max = i > max ? i : max;
		}
		 if(H == sum){
			 return 1;
		 }
		 if(H == piles.length){
			 return max;
		 }
		 
		 int left = 1;
		 int right = max;
		 while (left < right) {
			int mid = left + (right - left) >> 1;
		 	System.out.println(mid);
		 	if(isEatAll(piles, mid, H)){
		 		right = mid;
		 	}else {
				left = mid + 1;
			}
		}
		 return left;
	 }
	 public static boolean isEatAll(int []piles,int mid,int H){
		 //判断以mid速度是否可以吃完一堆
		 int need = 0;
		 for (int i : piles) {
			need += i / mid;
			if(i % mid != 0){
				need ++;
			}
		}
		 
		 return need <= H;
	 }
	 
	 
	//21点53分
	public int shipWithinDays(int[] weights, int D) {
		long sum = 0;
		long left = weights[0];
		for (int i : weights) {
			sum += i;
			left = left > i ? left : i;
			
		}
		if(D == 1){
			return (int) sum;
		}
		if(D == weights.length){
			return (int) left;
		}
		long right = sum;
		while (left != right) {
			long mid = (left + right) >> 1;
			long cur = 0;
			int need = 1;
			for (int i : weights) {
				if(cur + i > mid){
					cur = 0;
					need ++;
				}
				cur += i;
				
			}
			if(need > D){
				left = mid + 1;
			}else {
				right = mid;
			}
			
		}
		return (int) left;
        
    }
	
	
	public int removeStones(int[][] stones) {
		//使用并查集
		if(stones == null || stones.length <=1){
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < stones.length; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				if(map.get(i) == null){
					map.put(i, i);
				}
				if(map.get(j) == null){
					map.put(j, j);
				}
				if(stones[j][0] == stones[i][0] || stones[i][1] == stones[j][1]){
					System.out.println(stones[i]);
					Union(i,j, map);//i是value，key是j
				}
				
			}
		}
		for (int i = 0; i < stones.length; i++) {
			set.add(Find(i, map));
		}
		System.out.println(map.toString());
		return stones.length - set.size();
		
		
    }
	public int Find(int i,Map<Integer, Integer> map){
		return map.get(i) == i? i:Find(map.get(i), map);
	}
	public void Union(int i,int j,Map<Integer, Integer> map){
		map.put(Find(j, map), Find(i, map));
	}
	
	public int numberOfArithmeticSlices(int[] A) {
		int dp = 0;
		int sum = 0;
		if(A == null || A.length <= 2){
			return sum;
		}
		for (int i = 2; i < A.length; i++) {
			if(A[i] - A[i-1] == A[i-1] - A[i - 2]){
				dp++;
			}else {
				sum += dp;
				dp = 0;
			}
		}
		return sum;
    }
	
	
	
	
	
	public int[] nextGreaterElements(int[] nums) {
		if(nums == null || nums.length == 0){
			return new int[]{};
		}
		
		int result[] = new int[nums.length];
		
		int tem[] = new int[nums.length * 2];
		int max = nums[0];
		for (int i = 0; i < tem.length; i++) {
			tem[i] = nums[i % nums.length];
			max = tem[i] > max ? tem[i]:max;
		}
		System.out.println(Arrays.toString(tem));
		//stack存放的也是下标，map里面存放的key是下标，value是对应的值
		Stack<Integer> stack = new Stack<>();
		int len = tem.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tem.length; i++) {
			 while (!stack.isEmpty() && tem[stack.peek()] < tem[i]) {
				 map.put(stack.pop(), tem[i]);
			}
			 stack.push(i % len);
		}
		System.out.println(map.toString());
		int i = 0;
		for (int j = 0; j < result.length; j++) {
			result[j] = map.getOrDefault(j, -1);
		}
		return result;
    }
	
	
	int nums = 0;
	int time = 0;
	public int[] findFrequentTreeSum(TreeNode root) {
		//这是别人的思路，我是照着模仿的
		//使用的是后序遍历然后放入map中，list中的前num个值都是次数最多的几个
		List<Integer> temlist = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		getfind(root, temlist, map);
		int result [] = new int[nums];
		for (int i = 0; i < nums; i++) {
			result[i] = temlist.get(i);
		}
		
		return result;
    }

	public int getfind(TreeNode root,List<Integer> tem,Map<Integer, Integer> map){
		
		if(root == null){
			return 0;
		}
		int left = getfind(root.left, tem, map);
		int right = getfind(root.right, tem, map);
		int sum = root.val + left + right;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		int times = map.get(sum);
		if(times >= time){
			if(times > time){
				nums = 0;
			}
			nums++;
			tem.add(0,sum);
			time = times;
		}
		return sum;
	}
	//连续数组
	public int findMaxLength(int[] nums) {
        int sum = 0;
        int result = 0;
        if(nums == null || nums.length == 0 || nums.length == 1){
        	return 0;
        }
        Map<Integer, Integer> temmap = new HashMap<>();
        temmap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				sum--;
			}else {
				sum++;
			}
			if(temmap.get(sum) != null){
				temmap.put(sum, i);
			}else {
				result = Math.max(result, i - temmap.get(sum));
				
			}
		}
        
        return result;
    }
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0 || nums.length == 1){
			return result;
		}
		//根据下标进行取反
		
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if(nums[num - 1] > 0){
				nums[num - 1] *=-1;
			}else {
				result.add(num);
			}
		}
		
		
		return result;
		
		
	}
	public int minSubArrayLen(int s, int[] nums) {
		 int min = nums.length;
		 int sum = 0;
		 for (int i : nums) {
			sum += i;
		}
		 if(sum < s){
			 return 0;
		 }
		 if(sum == s){
			 return nums.length;
		 }
		 sum = 0;
		 int l = 0;
		 int start = 0;
		 for (int r = 0; r < nums.length; r++) {
			sum += nums[r];
			while (sum - nums[l] >= s && l <= r) {
				sum -= nums[l++];
				
			}
			if(sum >= s){
				min = Math.min(min, r - l + 1);
			}
			
		}
		 
		 
		 return min;
		 
		 
	 }
	
	public int findLength(int[] A, int[] B) {
		int lenA = A.length + 1;
		int lenB = B.length + 1;
        int dp[][] = new int[lenA][lenB];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if(A[i] == B[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
					max = Math.max(max, dp[i+1][j+1]);
				}else {
					dp[i+1][j+1] = 0;
				}
			}
		}
        return max;
    }
	
	int countArrangement = 0;
	public static void main(String[] args) {
		
		List<Integer> tem = new ArrayList<>();
		tem.add(1);
		tem.add(2);
		System.out.println(tem.toString());
		tem.remove(tem.size() - 1);
		System.out.println(tem.toString());
		
		
	}
	//00点12分
	public void sortColors(int[] nums) {
        //0、 1 和 2 分别表示红色、白色和蓝色
		
		int indexstart = 0;
		int indexend = nums.length - 1;
		  for (int i = 0; i <= indexend; i++) {
			if(nums[i] == 0){
				//移动到表头
				int tem = nums[indexstart];
				nums[indexstart] = nums[i];
				nums[i] = tem;
				indexstart ++;
			}else if (nums[i] == 2) {
				int tem = nums[indexend];
				nums[indexend] = nums[i];
				nums[i] = tem;
				indexend --;
			}
		}
			
	    
	
	
	}
	
	List<List<Integer>> result = new ArrayList<>();
	//23点00分
	public List<List<Integer>> combine(int n, int k) {
        

        int dire[] = new int[n];
        for (int i = 0; i < dire.length; i++) {
			dire[i] = i + 1;
		}
        List<Integer> tem = new ArrayList<>();
        getsub(result, tem, dire, k, 0);
        return result;
	}
	
	
	 public boolean stoneGame(int[] piles) {
	      int n = piles.length;
			
			//dp[i][j]表示从piles数组的i到j选择时先手比后手多的石子的数量
			//那么dp[i][j] = Max()
	        int dp[][] = new int[n][n];
	        for (int i = 0; i < dp.length; i++) {
				dp[i][i] = piles[i];
			}
	      for (int l = 2; l <= n; l++) {
	            for (int i = 0; i <= n - l; i++) {
	                int j = i + l - 1;
	                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
	            }
	        }
	        
	        return dp[0][n - 1] > 0? true :false;
	    }
	
	
	public void getsub(List<List<Integer>> result, List<Integer> tem,int []n,int k,int dangqian){
        
		if(tem.size() == k){
            System.out.println(tem.toString());
			List<Integer> news = new ArrayList<>(tem);
			
			result.add(news);
			return ;
		}
		for (int i = dangqian; i < n.length; i++) {
			tem.add(n[i]);
			getsub(result, tem, n, k, i + 1);
			tem.remove(tem.size() - 1);
		}
		
		
	}
	//22点31分
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
		List<int[]> result = new ArrayList<>();
		
		if(nums1.length == 0 || nums2.length == 0){
			return result;
		}
		
		int nums1index = 0;
		int nums2index = 0;
		int jishu = 0;
		while (jishu < k) {
			if(nums1index == nums1.length - 1&& nums1index == nums2.length - 1){
				break;
			}
			int tem[] = new int[2];
			tem[0] = nums1[nums1index];
			tem[1] = nums2[nums2index];
			result.add(tem);
			if(nums1index < nums1.length - 1 && nums2index < nums2.length - 1){
				if(nums1[nums1index + 1] + nums2[nums2index] < nums1[nums1index] + nums2[nums2index + 1]){
					nums1index++;
				}else {
					nums2index++;
				}
			}else if (nums1index == nums1.length - 1 && nums2index == nums2.length - 1) {
				return result;
			}else if (nums1index == nums1.length - 1) {
				nums2index++;
			}else {
				nums1index++;
			}
			jishu ++;
		}
		return result;
    }
	//22点14分
	public int totalHammingDistance(int[] nums) {
        //使用另一种算法实现
		int result = 0;
		int len = nums.length;
		for (int i = 0; i < 32; i++) {
			int tem = 0;
			for (int j = 0; j < nums.length; j++) {
				tem += (nums[j] >> 1) & 1;
			}
			result += tem * (len - tem);
		}
		
		
		return result;
    }
	//23点06分
	public String customSortString(String S, String T) {
		
		//从S种遍历，然后从T中进行查看是否有
		char[] temS = S.toCharArray();
		char[] temT = T.toCharArray();
		int Tindex = 0;
		for (int i = 0; i < temS.length; i++) {
			int index = new String(temT).indexOf(temS[i]);
			
			if(index != -1){
				int lastindex = new String(temT).lastIndexOf(temS[i]);
				if(index == lastindex){
					char tem = temT[i];
					temT[i] = temT[index];
					temT[index] = tem;
				}else {
					
				}
				 
			}
		}
		System.out.println(Arrays.toString(temT));
		return new String(temT);
		
    }
	 int get = 0;
	//22点27分
	public int rangeSumBST(TreeNode root, int L, int R) {
        //进行中序遍历
			re(root, L, R);
		return get;
		
    }
	public void re(TreeNode root,int L,int R){
		if(root == null){
			return;
		}
		re(root.left, L, R);
		if(root.val >= L && root.val <= R){
			get+=root.val;
		}
        if(root.val > R)
			return;
		re(root.right, L, R);
	}
	//11点03分
	public int divide(int dividend, int divisor) {
		int result = 0;
		if(dividend == 0){
			return result;
		}
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int shift = 0;
		while (a >= b) {
			while (a >= (b<<shift)) {
				shift ++;
			}
			
			a -= b<<(shift - 1);
			result +=1 <<( shift - 1);
			
			shift = 0;
			
		}
		if(dividend >  0 && divisor > 0 ||(dividend <  0 && divisor < 0)){
			return result;
		}
		
		
		return -result;
		
		
		
    }
	
	
	//22点26分
	public List<String> letterCombinations(String digits) {
		String [] tem = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length() == 0 || digits == null){
        	return result;
        }
        get(result, 0,"", tem,digits);
        return result;
        
    }
	
	public void get(List<String> tem,int start,String get,String [] tems,String digits){
		if(start >= digits.length()){
			tem.add(get);
			return;
		}
		int index = Integer.parseInt(digits.charAt(start) + "");
		
		for (int i = 0; i < tems[index].length(); i++) {
			get(tem,start+1, get + tems[index].charAt(i),tems,digits);
		}
		
	}
	//22点06分
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return get(0, nums.length - 1, nums);
    }
	public TreeNode get(int start, int end, int [] nums){
		if(start > end){
			return null;
		}
		int max = getMax(nums, start, end);
		TreeNode root = new TreeNode(nums[max]);
		root.left = get(start, max, nums);
		root.right = get(max, end, nums);
		return root;
	}
	public int getMax(int [] nums,int start,int end){
		int result = start;
		for (int i = start + 1; i <= end; i++) {
			if(nums[result] < nums[i]){
				result = i;
			}
		}
		return result;
	}
	
	
	//08点53分
	public int findCircleNum(int[][] M) {
		//借用的是那道等式成立的条件的思路
		Map<Integer, Integer> tem = new HashMap<>();
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if(M[i][j] == 1){
					if(!tem.containsKey(i)){
						tem.put(i, i);
					}
					if(!tem.containsKey(j)){
						tem.put(j, j);
					}
					unio(i, j, tem);
				}
			}
		}
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < M.length; i++) {
				res.add(find(i, tem));
		}
		return res.size();
    }
	public int find(int i,Map<Integer, Integer> tem){
		if(tem.get(i) != i){
			return find(tem.get(i), tem);
		}else {
			return i;
		}
		
	
	}
	public void unio(int i,int j,Map<Integer, Integer> tem){
		tem.put(find(i, tem), find(j, tem));
	}
	//16点21分
	public static int openLock(String[] deadends, String target) {
	    //用以表示方向的数组
		int direc[][] = {{1,0,0,0},
						 {-1,0,0,0},
						 {0,1,0,0},
						 {0,-1,0,0},
						 {0,0,1,0},
						 {0,0,-1,0},
						 {0,0,0,1},
						 {0,0,0,-1}};
		List<String> dead = Arrays.asList(deadends);
		String tem = "0000";//从0000开始
		Queue<String> duilie = new LinkedList<>();
		Queue<String> duilie2 = new LinkedList<>();
		duilie2.offer(target);
		if(dead.contains(tem)){
			return -1;
		}
		if("0000".equals(target)){
			return 0;
		}
		duilie.offer(tem);
		int result = 0;
		
		//换成isvisit数组
		boolean isvisit[] = new boolean[10000];
		isvisit[0]  = true;
		while (!duilie.isEmpty() && !duilie2.isEmpty()) {
			//duilie是长度短的那个，duilie2是长度长的那个
			if(duilie.size() > duilie2.size()){
				Queue<String> tems = duilie;
				duilie = duilie2;
				duilie2 = tems;
			}
			int size = duilie.size();
			for (int i = 0; i < size; i++) {
				String s1 = duilie.poll();
				//八个方向都进行遍历
				for (int di[] : direc) {
					int i1 = (Integer.parseInt(s1.charAt(0)+"") + di[0] + 10) % 10;
					int i2 = (Integer.parseInt(s1.charAt(1)+"") + di[1] + 10) % 10;
					int i3 = (Integer.parseInt(s1.charAt(2)+"") + di[2] + 10) % 10;
					int i4 = (Integer.parseInt(s1.charAt(3)+"") + di[3] + 10) % 10;
					//9999
					String getString = i1 + "" + i2 +"" + i3 + "" + i4;
					if(duilie2.contains(getString)){
						return result + 1;
					}
					if(!dead.contains(getString)){
						//这一步是为了防止死循环
						if(!isvisit[i1 * 1000 + i2 * 100 + i3 * 10 + i4]){
							isvisit[i1 * 1000 + i2 * 100 + i3 * 10 + i4] = true;
							duilie.offer(getString);
						}
					}
				}
			}
			result ++;
		}
		return -1;
	 
	}
	
	//15点45分
	public int[] dailyTemperatures(int[] T) {
		for (int i = 0; i < T.length; i++) {
			int tem = 0;
			int j = i+1;
			boolean flag = true;
			for (; j < T.length; j++) {
				if(T[j] > T[i]){
					tem ++;
					flag = false;
					break;
				}else {
					tem++;
				}
			}
			if(!flag){
				T[i] = tem;
			}
			if(i == T.length - 1 ){
				T[i] = 0;
			}
		}
		
		
		return T;
        
    }	
	
	
	//21点49分
	public int[] deckRevealedIncreasing(int[] deck) {
		  Arrays.sort(deck);
	        int index = 0;
	        Deque<Integer> tem = new LinkedList<>();
	        for (int i = deck.length - 1; i >= 0 ; i--) {
	        	int size = tem.size();
	        	if (size > 1) {
					tem.offerFirst(tem.pollLast());
				}
	        	tem.offerFirst(deck[i]);
				
			}
	        int [] result = new int[deck.length];
	        int x = 0;
	        for (int i : tem) {
				result[x] = i;
				x++;
			}
	        return result;
        
    }
	
	//09点42分
	public List<Integer> grayCode(int n) {
       /* List<Integer> result = new ArrayList<>();
        int tem = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= tem; i++) {
			list.add(i);
		}
        if(n == 0 ){
        	result.add(0);
        	return result;
        }
        int max = 0;
        //首先1 的数量要增加到max
        result.add(0);
        while (max < n) {
			max++;
			for (Integer integer : list) {
				if(Integer.bitCount(integer) - Integer.bitCount(result.get(result.size() - 1)) == 1){
					result.add(integer);
					list.remove(list.indexOf(integer));
					break;
				}
			}
		}
        max --;
        while (max >= 1) {
        	for (Integer integer : list) {
				if(Integer.bitCount(result.get(result.size() - 1)) - Integer.bitCount(integer)  == 1){
					result.add(integer);
					list.remove(list.indexOf(integer));
					break;
				}
			}
        	
        	
        	max--;
			
		}
       
        return result;*/
		List<Integer> result = new ArrayList<>();
		int max = (int) (Math.pow(2, n) - 1);
		for (int i = 0; i <= max; i++) {
			result.add(i ^ (i/2));
		}
		
		
		
		return result;
    }
	//18点57分
	public String iantToRoman(int num) {
        String result = null;
        return result;
    }
	//12点41分
	public int singleNumber(int[] nums) {
      /*
       * 通用的解法，但是效率低
       *   HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
        for (Map.Entry<Integer, Integer> s : map.entrySet()) {
			if(s.getValue() == 1){
				return s.getKey();
			}
		}
        return 0;*/
		int tem[] = new int[32];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int tems = nums[i];
			for (int j = 0; j < 32; j++) {
				tem[j] += tems % 2 == 0 ? 0:1;
				tems = tems >> 1;
			if(tems == 0){
				break;
			}
			}
		}
		for (int i = 31; i >= 0; i--) {
			tem[i] %=3;
			result = result * 2 + tem[i];
		}
		
		return result;
		
		
		
		
    }
	//18点49分
	public int[] singleNumberI(int[] nums) {
        Map<Integer, Integer> temMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			temMap.put(nums[i], temMap.getOrDefault(nums[i], 0) + 1);
		}
        int result[] = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer>i : temMap.entrySet()) {
			
        	if(temMap.get(i.getKey()) == 1){
        		result[index] = i.getValue();
        		index ++;
        	}
		}
        return result;
    }
	
	//10点10分
	public int[] constructArray(int n, int k) {
		
		        int[] ret = new int[n];
		        if(n<1)
		            return ret;
		        int cnt = 0;
		        ret[cnt++]=1;
		        for(int i=k; i>0; i--){
		            if(cnt%2==1){
		                ret[cnt] = ret[cnt-1]+i;
		             }
		            else{
		                ret[cnt] = ret[cnt-1]-i;
		            }
		            cnt++;
		        }
		        if(cnt<n){
		           ret[cnt++]=2+k;
		        }
		        while(cnt<n){
		            ret[cnt] = ret[cnt-1]+1;
		            cnt++;
		        }
		        return ret;
		}
        
    
	
	
	//08点58分
	public int countArrangement(int N) {
        //N<=15
		
		//用一个临时数组来存放所有的循环情况，0表示未使用，1表示使用了
		int tem[] = new int [N + 1];
	
		temArrange(1, tem, N);
		return countArrangement;
		
		
		
		
    }
	public void temArrange(int pose,int tem[],int N){
		if(pose > N){
			countArrangement++;
			return ;
		}
		for (int i = 1; i <= N; i++) {
			if(tem[i] == 0){
				if(i % pose == 0 || pose % i == 0){
					tem[i] = 1;
					temArrange(pose + 1, tem, N);
					tem[i] = 0;
				}
			}
		}
		
	}
	
	//21点34分
	public int countBattleships(char[][] board) {
		int count = 0;
		//行
        int row = board.length;
        //列
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(board[i][j] == 'X'){
					//右边和下边都没有
					if(i == row - 1 || board[i + 1][j] == '.'){
						if(j == column - 1 || board[i][j + 1] == '.'){
							count ++;
						}
					}
				}
				
			}
		}
        return count;
    }
	public int[] countBits(int num) {
		int []result = new int[num + 2];
		for (int i = 0; i <= num; i++) {
			result[i] = Integer.bitCount(i);
		}
     
		return result;
    }
	//14点44分
	
	//23点35分
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        gen(0, 0, result, n, "");
        
        
        return result;
    }
	
	public void gen(int left,int right,List<String> result,int count,String tem){
		if(left > count || right > count || right > left){
			return ;
		}
		if(left == count && right == count)
			result.add(tem);
		gen(left + 1, right, result , count, tem+"(");
		gen(left, right + 1, result , count, tem+")");
		
		
	}
	//20点05分
	public static  int sumSubarrayMins(int[] A) {
		int gt = 100000000 + 7;
		int sum = 0;
		//初始化一开始是第一个数组
		for (int i = 1; i <= A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				//范围为 j + i
				int min = A[j];
				int index = 1;
				while (index < i && index + j < A.length ) {
					if(A[index + j] < min){
						min = A[index + j];
					}
						index ++;
				}
				if(index == i){
					min = min % gt;
					sum = (sum % gt + min) % gt;
					//sum += min;
				}
				
			}
		}
		
		System.out.println(sum);
		
		
		return sum;
    }
	
	
	
	public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        //如果第一个和最后一个字母一致那么直接返回一个长度
        if(S.charAt(0) == S.charAt(S.length() - 1)){
        	result.add(S.length());
        	return result;
        }
        int tem[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
        	//首先记录每个字母出现在最后的索引位置，放置在tem数组中
			tem[S.charAt(i) - 97] = i;
		}
        //如果不是进行遍历
        for (int i = 0; i < S.length();) {
        	//如果出现的下标位置大于
			//获取到该字母出现的最后一个下标的位置，然后对该字段字母进行验收查看
        	int index = tem[S.charAt(i) - 97];
        	System.out.println(index);
        	for (int j = i + 1;  j <= index; j++) {
				if(tem[S.charAt(j) - 97] > index){
					index = tem[S.charAt(j) - 97];
				}
			}
        	result.add(index - i + 1);
			i = index + 1;
		}
        return result;
    }
	//13点03分
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		//假定每个毒剂都是满时间的那么就是这么长时间
		if(timeSeries.length == 0 || timeSeries == null || duration == 0){
			return 0;
		}
		int result = timeSeries[timeSeries.length - 1] + duration - 1;
        
		//但是实际上肯定中间有没有中毒的时间
		for (int i = 1; i < timeSeries.length; i++) {
			if(timeSeries[i] - timeSeries[i - 1] > duration){
				result = result - (timeSeries[i] - timeSeries[i-1] - duration ); 
			}
		}
		
        return result - timeSeries[0] + 1;
    }
	//11点10分
	public static  int maxProduct(String[] words) {
    //换个思路，这个思路比之前的那个要好一点
		int []num = new int[words.length];
		int result = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				num[i]|= (1 << words[i].charAt(j) - 97);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if((num[i] & num[j]) == 0){
					result = Math.max(words[i].length() * words[j].length(), result);
				}
			}
		}
		
		return result;
		
		
		/*//不用排序，直接用一个二维数组来存放对应的值
		int [][] tem = new int[words.length][26];
		//初始化tem数组
		for (int i = 0; i < words.length; i++) {
			//对每一个words都按照
			for (int j = 0; j < words[i].length(); j++) {
				tem[i][words[i].charAt(j) - 97] ++;
			}
		}
		int result = 0;
		
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < tem.length; j++) {
				boolean flag = false;
				for (int k = 0; k < 26; k++) {
					if(tem[i][k] * tem[j][k] != 0){
						//到这里表示的是有重复元素
						flag = true;
						break;
					}
				}
				if(!flag){
					result = Math.max(words[i].length() * words[j].length(), result);
				}
			}
		}
		return result;*/
    }
	
	
	//时间16点57分
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tem = new ArrayList<>();
		result.add(tem);
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			while (size > 0) {
				size --;
				List<Integer> tem1  = new ArrayList<>(result.get(size));
				tem1.add(nums[i]);
				result.add(tem1);
			//	System.out.println(result.toString());
			}
			
		}
		return result;
        
    }
	//11点42分
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //desiredTotal表示的是期望的总和
		//maxChoosableInteger为最大的数字
		
		//如果可选的数字大于目标数字，那么一定返回的是true
		if(desiredTotal <= maxChoosableInteger){
			return true;
		}
		//由于不能使用重复的数字，那么判断总和是否大于目标数，如果小于那么谁都赢不了
		int sum = 0;
		for (int i = 1; i <= maxChoosableInteger; i++) {
			sum+=i;
		}
		//等于的话也是不行的，因为如果等于那么
		if(sum < desiredTotal){
			return false;
		}
		//是奇数
		if(sum == desiredTotal && (maxChoosableInteger & 1) == 1)
			return true;
		//是偶数
		if(sum == desiredTotal && (maxChoosableInteger & 1) == 0)
			return false;
		Map<Integer, Boolean> map = new HashMap<>();//表示的是选择当前的数字对应的结果
		int visit = 0;//初始化为零，表示的是一个都没访问过

		return getisWin(maxChoosableInteger, desiredTotal, map, visit);
		
    }
	boolean getisWin(int max,int dest,Map<Integer, Boolean> map,int visit){
		if(map.containsKey(visit)){
			return map.get(visit);
		}
		for (int i = 1; i <= max; i++) {
			int mast = (1 << i);
			//没有访问过，并且没有
			if((visit & mast) == 0 && (i >= dest || !getisWin(max, dest - i, map, visit | mast)) ){
				map.put(visit, true);
				return true;
			}
		}
		map.put(visit, false);
		return false;
		
		
		
	}
	 public boolean isOnDif(String s,String  t){
			int dif = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != t.charAt(i)){
					dif++;
				}
				if(dif > 1 ){
					return false;
				}
			}
			return dif == 1;
		}
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			if(!wordList.contains(endWord)){
				return 0;
			}
			
			Set<String> beginSet = new HashSet<>(Arrays.asList(beginWord));
			Set<String> endSet = new HashSet<>(Arrays.asList(endWord));
			Set<String> dic = new HashSet<>(wordList);
			int step = 1;
			while (!beginSet.isEmpty()) {
				step++;
				Set<String> temSet = new HashSet<>();
				for (String string : beginSet) {
					//在字典中删除beginset中包含的
					dic.remove(string);
				}
				for (String string : beginSet) {
					//相差一个，并且在dic中
					for (String strings : dic) {
						if(isOnDif(string, strings)){
							temSet.add(strings);
							if(endSet.contains(strings)){
								return step;
							}
						}
					}
				}
				if(temSet.size() < endSet.size()){
					beginSet = temSet;
				}else {
					beginSet = endSet;
					endSet = temSet;
				}
			}
			
			return 0;
			
			
		/*
		 * 效率不是很高的BFS
		 * 
		 * //如果不包含那么就返回0
	        if(!wordList.contains(endWord)){
	        	return 0;
	        }
	        int deep = 1;
	        Queue<String> temQueue = new LinkedList<>();
	        Set<String> temSet = new HashSet<>();
	        temSet.add(beginWord);
	        temQueue.offer(beginWord);
	        while (!temQueue.isEmpty()) {
				int size = temQueue.size();
				deep ++;
				while (size > 0) {
					size--;
					String temString = temQueue.poll();
					//取出第一层，然后我们开始寻找与之只有一个字母的玩意
					for (String string : wordList) {
						if(isOnDif(temString, string) && !temSet.contains(string)){
							if(string.equals(endWord)){
								return deep;
							}
							temSet.add(string);
							temQueue.offer(string);
						}
						
					}
				}
			}
	        
	        return 0;*/
	    }
	public boolean exist(char[][] board, String word) {
       	
		int tem [][] =  new int[board.length][board[0].length];
		//首先找到第一个符合的然后进行回溯
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(isget(i, j,board, 0, word,tem))
					return true;
			}
		}
		return false;
    }
	public boolean isget(int x,int y,char[][] word,int index,String words,int [][]tem){
		if(index == words.length()){
			return true;
		}
		if(x < 0 || x >= word.length || y < 0 || y >= word[x].length || word[x][y] != words.charAt(index)){
			return false;
		}
		if(tem[x][y] == 0){
			tem[x][y] = 1;
			if(isget(x+1, y, word, index+1, words,tem)||
					isget(x-1, y, word, index+1, words,tem)||
					isget(x, y+1, word, index+1, words,tem)||
					isget(x, y-1, word, index+1, words,tem))
				return true;
			tem[x][y] = 0;
		}
	
		return false;

	
	
	}
	//18点01分
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> result = new ArrayList<>();
		int [][] temA = new int[A.length][26];
		int [][] temB = new int[B.length][26];
		int table[] = new int[26];
		//将B中的单词全部放入temB中
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length(); j++) {
				temB[i][B[i].charAt(j) - 'a'] ++;
			}
			for (int j = 0; j < table.length; j++) {
				if(table[j]<temB[i][j]){
					table[j] = temB[i][j];
				}
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length(); j++) {
				temB[i][A[i].charAt(j) - 'a']++;
			}
		}
		for (int i = 0; i < A.length; i++) {
			boolean flag = true;
			for (int j = 0; j < 26; j++) {
				if(table[j] != 0 && table[j] > temA[i][j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result.add(A[i]);
			}
			
		}
		
		
		return result;
        
    }
	
	//17点16分
	public int smallestRangeII(int[] A, int K) {
        if(A.length == 1){
        	return 0;
        }
        Arrays.sort(A);
        int len = A.length;
        int result = A[len - 1] - A[0];
        for (int i = 1; i < A.length - 1; i++) {
			int min = Math.min(A[0] + K, A[i] + K);
			int max = Math.max(A[len - 1] - K, A[i + 1] + K);
			result = Math.min(max - min , result);
		}

        return result;
        
        
    }
	
	
	public int combinationSum4(int[] nums, int target) {
		int []dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j : nums) {
				if(i >= j)
					dp[i]+=dp[i - j];
			}
			
		}
		
		
		return dp[target];
	 }
	
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		 List<List<Integer>> result = new ArrayList<>();
		 Set<List<Integer>> result = new HashSet<>();
		 List<Integer> tem = new ArrayList<>();
		 Arrays.sort(candidates);
		 getcombinationSum2(candidates, 0, target, result, tem);
		 List list = new ArrayList(result);
		// Set set = new HashSet(list);
		 return list;
	 }
	public static void getcombinationSum2(int []nums, int index, int target,Set<List<Integer>> result,List<Integer> tem){
		if(target == 0){
			result.add(new ArrayList<>(tem));
		}
		if(target < 0){
			return;
		}
		for (int i = index; i < nums.length; i++) {
			tem.add(nums[i]);
			getcombinationSum2(nums, index + 1, target - nums[i], result, tem);
			tem.remove(tem.size() - 1);
		}
	}
	 
	 
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		
		//k个数字，和为n
		List<List<Integer>> result = new ArrayList<>();
		int[] nums = {1,2,3,4,5,6,7,8,9};
		List<Integer> tem = new ArrayList<>();
		
		getcombinatisonSum3(nums, 0, k, result, tem, n);
		return result;
		
        
    }
	public void getcombinatisonSum3(int nums[],int start,int k ,List<List<Integer>> result, List<Integer> tem,int target){
		if(k == tem.size() && target == 0){
			result.add(tem);
			return ;
		}
		
		
		
		for (int i = start; i < 9; i++) {
			tem.add(nums[i]);
			getcombinatisonSum3(nums, i + 1, k, result, tem, target - nums[i]);
			tem.remove(tem.size() - 1);
		}
		
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		  Arrays.sort(candidates);
		        List<Integer> list = new ArrayList<>();//新建堆栈用来判断
		        List<List<Integer>> res = new ArrayList<>();//结果集
		        if (candidates == null || candidates.length == 0)
		            return res;
		        combin(candidates, 0, target, list, res);
		        return res;
		    }
		    //对数组元素（已排序）进行逐个判断以及加入结果集
     private void combin(int[] candidates, int start, int target,List<Integer> list, List<List<Integer>> res) {
		        //刚好满足则将结果存入结果集
		        if (target == 0) {
		            res.add(new ArrayList<>(list));
		            return;
		        }
		        for (int i = start; i < candidates.length; i ++) {
		            if (candidates[i] <= target) { //判断是否已经大于target
		                list.add(candidates[i]);//将第一个元素存入         
		                combin(candidates, i, target -candidates[i] , list, res);//继续判断进栈元素
		                list.remove(list.size() - 1);//不满足则将最后一个元素移除，进栈新元素判断
		            }
		        }      
		    }
	
	
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
	 	//将行的天际线放入row中
        List<Integer> row = new ArrayList<>();
        //将列的天际线放入column中
        List<Integer> column =  new ArrayList<>();
        int result = 0;
        //一行遍历
        for (int i = 0; i < grid.length; i++) {
        	//一列一列遍历
        	int max = grid[i][0];
			for (int j = 1; j < grid[i].length; j++) {
				max = Math.max(max, grid[i][j]);
			}
			//得到行的天际线
			row.add(max);
		}
        System.out.println(row.toString());
        //得到列天际线
        for (int i = 0; i < grid[0].length; i++) {
              int max = grid[0][i];
			for ( int j = 1; j < grid.length; j++) {
				max = Math.max(max, grid[j][i]);
			}
			column.add(max);
		}
        //至此行的天际线和列的天际线都得到了
        System.out.println(column.toString()); 
        //接下来我们计算每个数字所能加的最大数字
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//处于的是第i行和第j列
				//得到最小值
				int min = Math.min(row.get(i), column.get(j));
				result =  result + min - grid[i][j];
			}
		}
        return result;
    }
	
	
	
	 public static int maxArea(int[] height) {
	        int length = height.length;
	        int max = 0;
	        if(height[0] == height[length - 1]){
	        	max =  (length-1) * height[0];
	        }
	        int start = 0;
	        int end = length - 1;
	        
	       while(end > start) {
	        	int tem = height[start] < height[end]? height[start]: height[end];
				max = Math.max( tem * (end - start ), max);
				
				if(height[start] < height[end]){
					start ++;
				}else if (height[start] > height[end]) {
					end--;
				}else {
					start ++;
					end --;
				}
			}
	        
	        return max;
	    
	 }
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
			return 0;
		}
		int max = 1;
		//一开始我的思路是这样的，遍历字符串s，步长可能是这样的，abbc，以这个为例子,在第二个b进入时，字符串为abb,此时我需要判断b在ab的什么位置，
		//从而确定子字符串从上面位置开始
		StringBuilder sbtem = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			//得到是否有重复的
			int index = sbtem.indexOf(s.charAt(i) + "");
			
			if(index == -1){
				sbtem.append(s.charAt(i));
			}else {
				//有重复，那么需要将之前的全部都给移除，并且加上当前的
				max = Math.max(max, sbtem.length());
				sbtem.delete(0, index + 1);
				sbtem.append(s.charAt(i));
			}
			
		}
		
		
		
		
        return Math.max(max, sbtem.length());
    }
	public static  List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> tem1 = new HashSet<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//换一个思路，遍历数组并且设置前后指针
		
		
		//先进行排序一下
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			int goal = -j;
			int start = i+1;
			int end = nums.length -1;
			while (start < end) {
				if(nums[start] + nums[end] > goal){
					end --;
				}else if (nums[start] + nums[end] < goal) {
					start ++;
				}else {
					List<Integer> tem = new ArrayList<>();
					
					//由于已经排序过了，因此可以直接进行判断，而不需要一个一个判断，已知j< start < end
					tem.add(j);
					tem.add(nums[start]);
					tem.add(nums[end]);
					tem1.add(tem);
					int t = nums[start];
					while(nums[start] == t){
						start ++;
						if(start >= end){
							break;
						}
					}
					t = nums[end];
					while(nums[end] == t){
						end --;
						if(start >= end){
							break;
						}
					}
					
					
				}
				
			}
			
		}
		
		
		for (List<Integer> list : tem1) {
			result.add(list);
		}
		return result;
		
	/*	
	 * 
	 * 超时的代码，除了超时没有其他问题
	 * List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int x1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int x2 = nums[j];
				for (int k = j + 1; k < nums.length; k++) {
					int x3 = nums[k];
					List<Integer> tem = new ArrayList<>();
					if(x1 + x3 + x2 == 0){
						System.out.println("三者之和" + " "+x1 + " "+x2 + " "+x3);
						tem.add(x1);
						tem.add(x2);
						tem.add(x3);
						//下面查看三个数是否已经存在了，默认是不存在的
						boolean flag = false;
						for (List<Integer> integers : result) {
							List<Integer> integer = new ArrayList<>();
							integer.add(integers.get(0));
							integer.add(integers.get(1));
							integer.add(integers.get(2));
							if(integer.contains(x1)){
								integer.remove(integer.indexOf(x1));
								 if(integer.contains(x2)){
									 integer.remove(integer.indexOf(x2));
									 if(integer.contains(x3)){
										 flag = true;
											break;
									 }
								}
								
							}else {
								continue;
							}
						}
						//如果都不包含那么加入
						if(!flag){
							result.add(tem);
						}
						
						
					}
				}
				
			}
			
		}
		
		
		
		return result;
		*/
        
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
	/*输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
        
        将l1作为返回值，即将所有的加法放入到
		*/
		int jinwei = 0;
		int size1 = 0;
		int size2 = 0;
		ListNode tem1 = l1;
		ListNode tem2 = l2;
		
		//分别计算两个的长度，我们最后以最长的链表最为返回的结果
		while (tem1!=null) {
			tem1 = tem1.next;
			size1++;
		}
		while (tem2!=null) {
			tem2 = tem2.next;
			size2++;
		}
		//tem 是最长的那个链表的头
		ListNode tem = size1 >= size2? l1 : l2;
		
		if(size1 >= size2){
			
			//l1长度大于l2，那么就要以l1作为计算的值
			while (l2!=null) {
				int t = l1.val + l2.val + jinwei;
				l1.val = t % 10;
				jinwei = t / 10;
				//如果两个长度一致，并且有进位
				if(l1.next == null && l2.next == null && jinwei ==1){
					ListNode teListNode = new ListNode(1);
					teListNode.next = null;
					l1.next = teListNode;					
					return tem;
					
				}
				l1 = l1.next;
				l2 = l2.next;
				
				
				
			}
			
			while (l1!=null) {
				int t = l1.val + jinwei;
				l1.val = t % 10;
				jinwei = t / 10;
				//如果最后一位有进位
				if(l1.next == null && jinwei ==1){
					ListNode teListNode = new ListNode(1);
					teListNode.next = null;
					l1.next = teListNode;					
					return tem;
					
				}
				l1 = l1.next;
				
			}
			
			
		}else {
			//l2长度大于l1，那么就要以l2作为计算的值
			while (l1 != null) {
				int t = l1.val + l2.val + jinwei;
				l2.val = t % 10;
				jinwei = t / 10;
				l1 = l1.next;
				l2 = l2.next;
			}
			while (l2!=null) {
				int t = l2.val + jinwei;
				l2.val = t % 10;
				jinwei = t / 10;
				if(l2.next == null  && jinwei ==1){
					ListNode teListNode = new ListNode(1);
					teListNode.next = null;
					
					l2.next = teListNode;					
					return tem;
					
				}
				l2 = l2.next;
			}
			
			
		}
		
		
		
		return tem;
		
		
    }

	
	
	
	public static int myAtoi(String str) {

		if(str.trim().length() == 0){
			return 0;
		}
       char [] tem = str.toCharArray();
		int i = 0 ;
		while (tem[i] == ' ') {
			i++;
		}
       if(!((tem[i] >= '0'  &&  tem[i] <= '9')|| tem[i] == '-'|| tem[i] == '+')){
           return 0;
        }
        int result = 0;
        int st = result;
        boolean isminus = false;
        if(tem[i] == '-'||tem[i] == '+'  ){
        	if(tem[i] == '-'){
                isminus = true;
                i++;
            }else
                i++;
        }
        while (i < str.length() && tem[i] >= '0' && tem[i]<='9') {
        	result = result * 10 + (tem[i] - 48);
			if(result > Integer.MAX_VALUE / 10 ||(result == Integer.MAX_VALUE / 10 && tem[i] - '0' > 7)){
				if(isminus){
					return Integer.MIN_VALUE;
				}else {
					return Integer.MAX_VALUE;
				}
			}
			i++;
		}
        if(isminus){
        	return 0 - result;
        }else {
			return result;
		} 
    }
	
	
	public int threeSumClosest(int[] nums, int target) {
		//首先暴力破解
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int tem1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int tem2 = nums[j];
				for (int k = j + 1; k < nums.length; k++) {
					int tem3 = nums[k];
					if(Math.abs(tem1 + tem2 + tem3 - target) < Math.abs(result - target)){
						result = tem1 + tem2 + tem3;
					
					}
					if(result == target){
						return target;
					}
					
				}
				
			}
			
		}
        return result;
    }
}
