package easy;

import java.awt.geom.AffineTransform;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
/*
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println(pathSum(t1, 2));*/
	/*	int nums[] = {1,2,3,4};
		int [][]  is = {{1,0},{2,1},{0,1},{2,0}};
		System.out.println(is.length);
		System.out.println(isinpoints(2, 11, is));
	//	minAreaFreeRect(is);
		System.out.println((double)1/2);
		System.out.println(findMaxAverage(nums, 3));*/
	/*	System.out.println(judgeSquareSum(6));
		
		String string = "dfsd";
		System.out.println(string.charAt(0) == string.charAt(3));*/
		
	//	System.out.println(rotatedDigits(12));
@SuppressWarnings("all")
public class Reserve {
	public static void main(String[] args) {

		



		List<Integer> s1 = new ArrayList<>();
		s1.add(1);
		s1.add(2);
		List<Integer> s2 = new ArrayList<>();
		s2.add(2);
		s1.add(1);
		System.out.println(s1.equals(s2));
	}
	
	public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        
        
        pre(root, result);
        return result;
    }
	public static void pre(Node root,List<Integer> tem){
		if(root == null){
			return ;
		}
		tem.add(root.val);
		List<Node> nodes = root.children;
		for (Node node : nodes) {
			pre(node, tem);
		}
	}
	
	
	public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        
        return result;
    }
	public void gets(Node root,List<Integer> result){
		
	}
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	    Map<Integer, Integer> temMap = new HashMap<>();
	    Stack<Integer> stack = new Stack<>();
	    for (int integer : nums2) {
			while(!stack.isEmpty() && integer > stack.peek()){
				temMap.put(stack.pop(), integer);
			}
			stack.push(integer);
		}
	    int result[] = new int[nums1.length];
	    for (int i = 0; i < nums1.length; i++) {
			result[i] = temMap.getOrDefault(nums1[i], -1);
		}
	    
	    
	    
	    return result;
		
		
		
	 }
	
	
	
	
	public String tree2str(TreeNode t) {
		StringBuilder sBuilder = new StringBuilder();
		if(t == null){
			return new String(sBuilder);
		}
		if(t.left == null && t.right == null){
			sBuilder.append(t.val);
			return new String(sBuilder);
		}
		get(t, sBuilder);
		return new String(sBuilder);
        
    }
	public static void get(TreeNode tem,StringBuilder sb){
		
		if(tem.left == null && tem.right == null){
			sb.append(tem.val);
			return ;
		}
		if(tem.left != null){
			sb.append(tem.val);
			sb.append("(");
			get(tem.left, sb);
			sb.append(")");
			
		}
		if(tem.left == null){
			sb.append(tem.val);
			sb.append("()");
		}
		if(tem.right != null){
			sb.append(tem.val);
			sb.append("(");
			get(tem.right, sb);
			sb.append(")");
			
		}
		
	}
	public int findPairs(int[] nums, int k) {
		//前面的表示的是值，后面表示的是该值对应的数目
		Map<Integer,Integer> map = new HashMap<>();
		if(k < 0){
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		int result = 0;
		//由于不包括重复的，因此这里就是1
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
	
		//对map进行遍历
		for (Map.Entry<Integer, Integer> tem:map.entrySet()) {
			if(map.get(tem.getKey() - k) != null){
				if(k==0 && map.get(tem.getKey() - k) < 1){
					continue;
				}else {
					result++;
				}
			}
		}
		return result;
        
    }
	
	
	
	
	public boolean isUnivalTree(TreeNode root) {
		if(root == null){
			return true;
		}
		return isget(root, root.val);
        
    }
	public boolean isget(TreeNode root,int val){
		if(root == null){
			return true;
		}
		if(root.val != val){
			return false;
		}else {
			return isget(root.left, val) && isget(root.right, val);
		}
	}
	//22点29分
	public boolean isSubtree(TreeNode s, TreeNode t) {
        /*if(s == null && t == null){
        	return true;
        }
        Queue<TreeNode> tem =  new LinkedList<>();
        tem.add(s);
        while (!tem.isEmpty()) {
			int size = tem.size();
			for (int i = 0; i < size; i++) {
				TreeNode temnode = tem.poll();
				if(is(temnode, t)){
					return true;
				}else {
					if(temnode.left != null){
						tem.offer(temnode.left);
					}
					if(temnode.right != null){
						tem.offer(temnode.right);
					}
				}
			}
		}
        return false;*/
		
		//使用递归来完成
		if( s == null && t == null){
			return true;
		}
		if(s == null || t == null){
			return false;
		}
		boolean stem = false;
		if(s.val == t.val){
			stem = is(s, t);
		}
	
		return stem || isSubtree(s.left, t) || isSubtree(s.right, t); 
		
	}
		
	
	public boolean is(TreeNode s,TreeNode t){
		if(s == null && t == null){
			return true;
		}
		if(s == null || t == null){
			return false;
		}
		
		
		return  is(s.left, t.left) && is(s.right, t.right);
		
	}
	
	
	public int numRookCaptures(char[][] board) {
		int x = 0;
		int y = 0;
		//有一个白色车（rook）。也可能有空方块，
		//白色的象（bishop）和黑色的卒（pawn）。
		//它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
		//首先获取到车所在的位置
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 'R'){
					x = i;
					y = j;
					break;
				
				}
			}
		}
		//四个方向遍历
		int result = 0;
		
		//向上
		for (int i = y - 1; i >= 0; i--) {
			if(board[x][i] == '.'){
				continue;
			}else if (board[x][i]=='B') {
				break;
			}else {
				result ++;
				break;
			}
		}
		//向下
				for (int i = y + 1; i < board.length; i++) {
					if(board[x][i] == '.'){
						continue;
					}else if (board[x][i]=='B') {
						break;
					}else {
						result ++;
						break;
					}
				}
			//向左
			for (int i = x - 1; i >= 0; i--) {
				if(board[i][y] == '.'){
					continue;
				}else if (board[i][y]=='B') {
					break;
				}else {
					result ++;
					break;
				}
			}
			//向右
			for (int i = x + 1; i < board[0].length; i++) {
				if(board[i][y] == '.'){
					continue;
				}else if (board[i][y]=='B') {
					break;
				}else {
					result ++;
					break;
				}
			}
		return result;
        
    }
	
	
	public int findJudge(int N, int[][] trust) {
		Map<Integer, Integer> temMap = new HashMap<>();
		int tems [] = new int[N+1];
        for (int[] is : trust) {
			tems[is[1]] ++;
		}
       
        System.out.println(Arrays.toString(tems));
        for (int i = 0; i < tems.length ;i++) {
			if(tems[i] == N-1){
				if(temMap.get(i) == null){
					return i;
				}else {
					return -1;
				}
			}
		}
      return -1;
        
    }
	
	
	
	//09点48分
	int max = 0 ;
	public int diameterOfBinaryTree(TreeNode root) {
		
       getdep(root);
        return max;
    }
	public int getdep(TreeNode root){
		if(root == null){
			return 0;
		}else {
			int left = 1 + getdep(root.left);
			int right = 1 + getdep(root.right);
			max = Math.max(left + right,max);
			return left > right ? left :right;
		}
	}
	
	//23点14分
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> r1 = new ArrayList<>();
		List<Integer> r2 = new ArrayList<>();
		getlef(root1, r1);
		getlef(root2, r2);
		
        return r1.equals(r2)? true : false;
		
    }
	public void getlef(TreeNode root1,List<Integer> tem){
		if(root1 == null){
			return ;
		}
		if(root1.left == null && root1.right == null){
			tem.add(root1.val);
		}
		getlef(root1.left, tem);
		getlef(root1.right, tem);
	}
	//21点30分
	public int orangesRotting(int[][] grid) {
		//用来表示四个方向
		int dire[][] = {{1,0},
				{-1,0},
				{0,1},
				{0,-1}};
		//用于使用判断是否访问过的
		//用于循环的duilie
		Queue<int[]> duilie = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//将腐烂的位置放入到队列中
				if(grid[i][j] == 2){
					/*int[] tems = new int[2];
					tems[0] = i;
					tems[1] = j;*/
					duilie.offer(new int[]{i,j});
				}
			}
		}
		int result = 0;
		while (!duilie.isEmpty()) {
			int size = duilie.size();
			//进行感染
			for (int i = 0; i < size; i++) {
				//得到一个坐标
				int []point = duilie.poll();
				for (int p[] : dire) {
					int x = point[0] + p[0];
					int y = point[1] + p[1];
					//在有效的范围内
					if(!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)){
						if(grid[x][y] == 1){
							grid[x][y] = 2;
							duilie.offer(new int[]{x,y});
						}
						
					}
				}
			}
			result ++;
		}
		for (int[] is : grid) {
			for (int i : is) {
				if(i == 1){
					return -1;
				}
			}
		}
		
		return result == 0? 0: result - 1;
		
    }
	public void dfs(Queue<int []> tem,int [][]grid,int []point){
		
		
	}
	//09点15分
	public static  String[] reorderLogFiles(String[] logs) {
		String [] tem = new String[logs.length];
		//设置一个tem数组
        for (int i = 0; i < logs.length; i++) {
			tem[i] = logs[i].substring(logs[i].indexOf(" ") +  1);
		}
        Arrays.sort(logs);
        
        System.out.println(Arrays.toString(logs));
        return logs;
    }
	
	
	
	//19点07分
	public static  int numMagicSquaresInside(int[][] grid) {
        
		
		int result = 0;
		
		//以行作为外循环，列作为内循环
		for (int i = 0; i < grid.length; i++) {
			if(i + 2 < grid.length){
				for (int j = 0; j < grid[i].length; j++) {
					
					if(j + 2 < grid[i].length){
						//送入判断函数进行判断
						if(is3(i, j, grid)){
							result++;
						}
					}else {
						break;
					}
				}
			}else {
				break;
			}
		}
		return result;
    }
	
	
	
	
	public static  boolean is3(int x, int y, int [][]A){
		//注意还要是不同的数字
		int tems[] = new int[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(A[x + i][y + j] <=9){
					tems[A[x + i][y + j]] ++;
				}else {
					return false;
				}
			}
			
		}
		for (int i = 1; i <= 9; i++) {
			int j = tems[i];
			if(j != 1){
				return false;
			}
		}
		
		
		
		int tem = A[x][y] + A[x+1][y] + A[x+2][y];
		for (int i = 0; i < 3; i++) {
			if(A[x][y + i] + A[x + 1][y + i] + A[x + 2][y + i] != tem){
				return false;
			}
			if(A[x+i][y] + A[x+i][y + 1] + A[x+i][y + 2] !=tem){
				return false;
			}
		}
		//判断两个对角
		if(A[x][y] + A[x+1][y+1] + A[x+2][y+2] != tem || A[x][y+2] + A[x+1][y+1]+ A[x+2][y] != tem)
			return false;
		return true;
	}

	int maxt;

	//时间
	public int countPrimeSetBits(int L, int R) {
    
		//24
		int [] tems = {2,3,5,7,11,13,17,19,23};
		List<Integer> tes = Arrays.asList(2,3,5,7,11,13,17,19,23);
		System.out.println(tes.toString());
		int result = 0;
		for (int i = L; i <= R; i++) {
			int tem = Integer.bitCount(i);
			//tem保存的是i中的数量，接下来判断是不是质数
			if(tes.contains(tem)){
				result ++;
			}
		}
		
		return result;
    }
	
	public int surfaceArea(int[][] grid) {
		
		return 0;
    }
	
	
	public int longestUnivaluePath(TreeNode root) {
      
		if(root == null){
        	return 0;
        }
        getmaxL(root, root.val);
        
        return maxt;
        
        
    }
	public int getmaxL(TreeNode t, int val){
		if(t == null){
			return 0;
		}
		int Left = getmaxL(t.left, t.val);
		int Right = getmaxL(t.right,t.val);
		
		if(t.val == val){
			return Math.max(Left, Right) + 1;
		}
		return 0;
		
	}
	
	//12点31分
	public boolean lemonadeChange(int[] bills) {
       int count5 = 0;
       int count10 = 0;
       
        for (int i = 0; i < bills.length; i++) {
			if(bills[i] == 5){
				count5 ++;
			}else if (bills[i] == 10) {
				if(count5 == 0){
					return false;
				}else{
					count5 --;
					count10 ++;
				}
				//如果是20元
			}else {
				//先将10元弄开
				if(count5 >= 1 && count10 >=1){
					count5 --;
					count10 --;
				}else if (count5 >= 3) {
					count5 -= 3;
					
				}else {
					return false;
				}
			}
		}
        return true;
        
    }
	//11点07分
	
	public int uniqueMorseRepresentations(String[] words) {
        
		String [] strings = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
				"-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		Set<String> tem = new HashSet<>();
		String sb = new String();
		for (int i = 0; i < words.length; i++) {
		//	sb.delete(0, sb.length());
			sb = "";
			for (int j = 0; j < words[i].length(); j++) {
				sb += strings[words[i].charAt(j) - 97];
			}			
			tem.add(sb);
			System.out.println(sb.toString());
		}
		System.out.println(tem.toString());
		return tem.size();
    }
	//50
	public int peakIndexInMountainArray(int[] A) {
		
		int index = 0;
		while (true) {
			if(index == A.length - 1){
				break;
			}
			if(A[index] > A[index + 1]){
				break;
				
			}else {
				index++;
			}
		}
		
		return index;
        
    }
	
	
	
	
	public ListNode middleNode(ListNode head) {
	
		if(head == null){
			return head;
		}
		if(head.next == null){
			return head;
		}
		if(head.next.next == null){
			return head.next;
		}
		
		
		ListNode pre = head;
		ListNode last = head;
		
		while (pre.next != null && last.next != null) {
			pre = pre.next;
			last = last.next;
		}
		
		return pre;
        
    }
	
	
	
	public static  boolean backspaceCompare(String S, String T) {
		
		
       
		StringBuilder Ssb = new StringBuilder();
		StringBuilder Tsb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '#'){
				if(Ssb.length() != 0){
					Ssb.delete(Ssb.length() - 1, Ssb.length());
				}
			}else {
				Ssb.append(S.charAt(i));
			}
		}
        
		for (int i = 0; i < T.length(); i++) {
			if(T.charAt(i) == '#'){
				if(Tsb.length() != 0){
					Tsb.delete(Tsb.length() - 1, Tsb.length());
				}
			}else {
				Tsb.append(T.charAt(i));
			}
		}
        System.out.println(Tsb.toString());
        System.out.println(Ssb.toString());
        if(new String(Tsb).equals(new String(Ssb))){
        	return true;
        }else {
			return false;
		}
        
        
    }
	
	public int[][] kClosest(int[][] points, int K) {
		int result [][] = new int[K][2];
		
		TreeMap<Double, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < points.length; i++) {
			int x=points[i][0];
            int y=points[i][1];
            //某个点到原点的欧几里德距离为坐标值的平方之和开根号即可
            double distance=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            List<Integer> tem = new ArrayList<>();
            if(map.get(distance) == null){
            	tem.add(i);
            }else {
				tem = map.get(distance);
				tem.add(i);
				map.put(distance, tem);
			}
			
			
		}
		Iterator<Entry<Double, List<Integer>>> it=map.entrySet().iterator();
        //当前遍历到第几个元素，用于控制点的个数
        int index=0;
        while (it.hasNext()){
            List<Integer> point=it.next().getValue();
            int size = 0;
            if(index + 1 == K){
                break;
            }else{
                ++index;
            }
        }
		
		
		
		return result;
		
		
    }
	//写一个函数，从index开始进行，并且之前被覆盖的数字是dig
	public int get(int x,int y){
		return x * x + y * y;
	}
	public int minCostClimbingStairs(int[] cost) {
		if(cost.length == 0){
			return 0;
		}
		if(cost.length == 1){
			return cost[0];
		}
		if(cost.length == 2){
			return Math.min(cost[0], cost[1]);
		}
		int dp[] = new int[cost.length + 1];
		
		//dp为爬n个楼梯的最小值
		
		//初始化一些
		dp[0] = 0;
		dp[1] = cost[0];
		dp[2] = cost[1];
		for (int i = 2; i < cost.length; i++) {
			dp[i + 1] = Math.min(dp[i] + cost[i], dp[i - 1] + cost[i]);
		}
		
		return Math.min(dp[cost.length - 1], dp[cost.length]);
		
		
        
    }
	public int search(int[] nums, int target) {
		
		//0 1 2 3 4 5 6 7 8 9 10 11
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) /2;
			if(nums[start] == target){
				return start;
			}
			
			if(nums[end] == target){
				return end;
			}
			if(nums[mid] > target){
				end = mid - 1;
			}else if (nums[mid] < target ) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
    }
	public  int largestPerimeter(int[] A) {
		Arrays.sort(A);
		if(A.length == 3){
			if(A[0] + A[1] > A[3]){
				return A[0] + A[1] + A[2];
			}else {
				return 0;
			}
		}
		int len = A.length - 1;
		for (int i = len; i >= 2; i--) {
			System.out.println(A[i]);
			if(A[i - 1] + A[i - 2] > A[i]){
				return A[i - 1] + A[i - 2] + A[i];
			}
			
		}
		
		return 0;
		
        
    }
	
	
	
	public static int numUniqueEmails(String[] emails) {
		Set<String> result = new HashSet<>();
		for (int i = 0; i < emails.length; i++) {
			String tem[] = emails[i].split("@");
		//	System.out.println(Arrays.toString(tem));
			int index = tem[0].replaceAll(".", "").indexOf("+");
			//表明没有+
			if(index == -1){
				result.add(tem[0].replaceAll(".", "") + tem[1]);
			}else {
				//表明有+
				result.add(tem[0].replaceAll(".", "").substring(0,index) + tem[1]);
			}
		//	System.out.println(result.toString());
		}
		
		
		
		
		
        return result.size();
    }
	
	
	
	
	public boolean buddyStrings(String A, String B) {
		if(A.length() != B.length()){
			return false;
		}
		//如果A和B是相等的，那么只有A中有重复的字符串那么才可能符合题目意思
		if(A.equals(B)){
			int tem[] = new int[26];
			for (int i = 0; i < A.length(); i++) {
					tem[A.charAt(i) - 97] ++;
					if(tem[A.charAt(i) - 97] > 1){
						return true;
					}
			}
			return false;
		}
		int index = 0;
		
		//time记录的是改变了多少次数
		int time = 0;
		int startA = 0;
		char [] Atem = A.toCharArray();
		char [] Btem = B.toCharArray();
		while (index < A.length()) {
			if(A.charAt(index) != B.charAt(index)){
				
				if(time == 2){
					return false;
				}
				if(time == 0){
					
					//记录下首个不相等的下标
					startA = index;
				}
				time ++;
				if(time == 2){
					if(!(Atem[startA] == Btem[index] && Atem[index] == Btem[startA]))
					return false;
				}
			}
			index++;
		}
		return true;
		
		
		
        
    }
	
	
	
	public static List<String> subdomainVisits(String[] cpdomains) {
		//用map存储的是所有的域名和对应的次数
        Map<String, Integer> temMap = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
        	String temString = cpdomains[i];
        	String getString = temString.split(" ")[1];
     //   	System.out.println(getString);
        	inser(temMap, gettimes(temString), getString);
        	
		}
        
        
        
     //   System.out.println(temMap.toString());
        List<String> temList = new ArrayList<>();
        for (String string : temMap.keySet()) {
			temList.add(temMap.get(string) + " " + string);
		}
        return temList;
        
        
        
    }
	public static void inser(Map<String, Integer> temMap,int time,String string){
		//System.out.println(string);
		String [] temStrings = string.split("\\.");
		System.out.println(Arrays.toString(temStrings));
		StringBuilder sBuilder = new StringBuilder();
		//将最后一个域名加入，比如：com 先将其键入
		sBuilder.append(temStrings[temStrings.length - 1]);
		
		temMap.put(new String(sBuilder), temMap.getOrDefault(new String(sBuilder), 0) + time);
		for (int i = temStrings.length - 2; i >= 0 ; i--) {
			StringBuilder tems = new StringBuilder();
			tems.append(temStrings[i]+".").append(sBuilder);
			sBuilder = tems;
			String getString = new String(sBuilder);
			System.out.println("放入"+ getString);
			temMap.put(getString, temMap.getOrDefault(getString, 0) + time);
		}
	}
	public static int gettimes(String s){
		//得到次数
		String temString = s.split(" ")[0];
		System.out.println(temString);
		return Integer.parseInt(temString);
	}
	
	public boolean isOneBitCharacter(int[] bits) {
		
		int len = bits.length;
		int start = 0;
		
		if(len == 1){
			return true;
		}
		
		for (; start < bits.length - 1; ) {
			int j = bits[start];
			if(j == 0 ){
				start ++;
			}else {
				start += 2;
			}
			if(start == bits.length - 1){
				return true;
			}
			if(start == bits.length){
				return false;
			}
		}
		return false;
		
        
    }
	
	
	
	public  static String shortestCompletingWord(String licensePlate, String[] words) {
		
		
		//首先转成小写，然后放入set中，之后进行判断
		licensePlate = licensePlate.toLowerCase();
		System.out.println(licensePlate);
		List<String> temList = new ArrayList<>();
		
		int start = 0;
		for (int i = 0; i < licensePlate.length() ; i++) {
			if(licensePlate.charAt(i)<='z' && licensePlate.charAt(i) >= 'a'){
				temList.add(licensePlate.substring(i,i+1));
			}
				
		}
		
        System.out.println(temList.toString());
        //将符合条件的都放入temmap中
        List<String> temMap = new ArrayList();
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
			String string = words[i];
	        //遍历set集合
			boolean flag = false;
	        for(String value: temList){
	            if(string.indexOf(value) != -1){
	            	string = string.replaceFirst(value, " ");
	            	continue;
	            }else {
	            	flag = true;
					break;
				}
	        }
	        
	        if(!flag){
	        	len = Math.min(len, words[i].length());
	        	temMap.add(words[i]);
	        }

			
		}
        System.out.println(temMap.toString());
        //遍历hashmap，返回最先的那个
        for (String string : temMap) {
			if(string.length() == len){
				return string;
			}
		}
        
        
        
        return "";
    }
	public boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		int indexstart = 0;
		int indexend = 0;
		boolean flag = true;
		while (start < end) {
			if(s.charAt(start) == s.charAt(end)){
				start ++;
				end --;
			}else if(flag){
				indexend = end;
				indexstart = start;
				start++;
				flag = false;
			}else {
				break;
			}
			
		}
		if(flag)
			return true;
		indexend --;
		while (indexend > indexstart) {
			if(s.charAt(indexend) == s.charAt(indexstart)){
				indexend --;
				indexstart ++;
			}else {
				return false;
			}
		}
		
		return true;
		
		
        
    }
	
	
	
	
	
	
	 public int maxDistToClosest(int[] seats) {
	 
		 
		 int max  = 0 ;
		 int i = 0;
		 int tem = 0;
		 ArrayList<Integer> telist = new ArrayList<>();
		 for (; i < seats.length; i++) {
			if(seats[i] == 0){
				tem ++;
			}else {
				//下标记录下来
				telist.add(i);
				max = Math.max(max, tem);
				tem = 0;
			}
		}
		 
		 //取出首部第一个出现的下标
		 if((max & 1) == 1){
			 max ++;
		 }
		 max = Math.max(telist.get(0), max/2);
		 max = Math.max(max, seats.length - telist.get(telist.size() - 1) - 1);
	
	 
		 return max;
	 
	 }
	
	
	public String reverseWords(String s) {
		String [] temStrings = s.split(" ");
		StringBuilder sBuilder = new StringBuilder();
		
		for (int i = 0; i < temStrings.length; i++) {
			String string = temStrings[i];
			if(i == temStrings.length - 1){
				sBuilder.append(rever(0, string.length(), string.toCharArray()));
			}else {
				sBuilder.append(rever(0, string.length(), string.toCharArray())).append(" ");
			}
		}
		
		return new String(sBuilder);
		
		/*int start = 0;
		int end = 0;
		char [] t = s.toCharArray();
		StringBuilder sBuilder = new StringBuilder();
		while (end < t.length) {
			if(t[end] == ' '){
				sBuilder.append(new String(rever(start, end, t)).subSequence(start, end + 1));
				start = end + 1;
				end ++;
			}else {
				end ++;
			}
			if(end == t.length - 1 && t[end] != ' '){
				sBuilder.append(new String(rever(start, end, t)).subSequence(start, end + 1));
				end ++;
			}
		}
     return new String(sBuilder);   */
    }
	
	public static char[] rever(int start ,int end,char [] tem){
		//反转从下标为start到end的字符（不包括end）
		end = end - 1;
		while (start < end) {
			char tem1 = tem[start];
			tem[start] = tem[end];
			tem[end] = tem1;
			start ++;
			end --;
		}
		return tem;
	}
	
	
	public String reverseStr(String s, int k) {
		//每2k个字符，其中前k个反转，后面k个不反转
		char[] tem = s.toCharArray();
		//默认是反转的，步长为k
		boolean flag = true;
		for (int i = 0; i < tem.length; i+=k) {
			if(flag){
				int start = i;
				int end = i + k -1;
				if(i + k > tem.length){
					end = tem.length - 1;
				}else {
					end = i + k - 1;
				}
				while (start < end) {
					char te = tem[start];
					tem[start] = tem[end];
					tem[end] = te;
					start ++;
					end -- ;
				}
				
			flag = !flag;	
			}else {
				flag = !flag;
			}
		}
		
		
		
		
		return new String(tem);
		
		
		
		
		
		
		
    }
	
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= bound; i++) {
			int tem1 = (int) Math.pow(x, i);
			if(tem1 > bound){
				break;
			}
			for (int j = 0; j < bound; j++) {
				int tem2 = (int) Math.pow(y, j);
				int tem = tem1 + tem2;
				if(tem > bound){
					break;
				}else {
					if(!result.contains(tem)){
						result.add(tem);
					}
				}
				
			}
			
			
		}
		return result;
        
    }
	
	
	public  static boolean rotateString(String A, String B) {
        if(A.length() != B.length()){
        	return false;
        }
       
        int len = B.length();
        while (len >= 0) {
        	if(A.equals(B)){
        		return true;
        	}else {
        		char s[] = A.toCharArray();
        		char first = s[0];
				for (int i = 0; i < A.length() - 1; i++) {
					s[i] = s[i + 1];
				}
				s[A.length() - 1] = first;
				A = new String(s);
			}
        	
		    len--;
		}
        return false;
        
    }
	
	
	public int countBinarySubstrings(String s) {
		
		int last,cur,res;
		last = 0;
		res = 0;
		cur = 1;
		int result = 0;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(i - 1)){
				last = cur;
				cur = 1;
			}else {
				cur ++;
			}
			
			if(last > cur){
				result ++;
			}
			
		}
		
		return result;
        
    }
	public  static int fib(int N) {
		 int start = 0;
		 int end = 1;
		 int result = 1;
		 if(N == 1 || N ==0){
			 return 0;
		 }
		 if(N == 2){
			 return 1;
		 }
		 
		 for (int i = 0; i < N - 1; i++) {
			 
			 result = start + end;
			 start = end;
			 end = result;
		}
		 System.out.println(result);
		 
		 return result;
		 
	        
	   }
	
	

	
	public static int[] sortArrayByParityII(int[] A) {
        //思路：首先将偶数给搞定，那么奇数肯定是自动的
		int startoushu = 0;
		int startjishu = 1;
		while (startoushu < A.length) {
			if(A[startoushu] % 2 != 0 ){
				break;
			}else {
				startoushu +=2;
			}
			
		}
		//找到第一个下标是奇数，但是不是奇数的数字
		while (startjishu < A.length) {
			if(A[startjishu] % 2 == 0 ){
				break;
			}else {
				startjishu +=2;
			}
			
		}
		
		while (startjishu < A.length && startoushu < A.length) {
			int tem = A[startjishu];
			A[startjishu] = A[startoushu];
			A[startoushu] = tem;
			startjishu +=2;
			startoushu +=2;
			if(startjishu >= A.length || startoushu >= A.length){
				return A;
			}
			//寻找下一个不是
			while (startoushu < A.length) {
				if(A[startoushu] % 2 != 0 ){
					break;
				}else {
					startoushu +=2;
				}
				
			}
			//找到第一个下标是奇数，但是不是奇数的数字
			while (startjishu < A.length) {
				if(A[startjishu] % 2 == 0 ){
					break;
				}else {
					startjishu +=2;
				}
				
			}
		}
		
		
		return A;
		
		
    }
	public int[] sortArrayByParity(int[] A) {
		int start = 0;
		int end = A.length -1;
		while (end > start) {
			//从前面找到第一个不是偶数的下标
			while (A[start] % 2 == 0) {
				start ++;
				if(start > end){
					return A;
				}
			}
			
			//从后面找到第一个不是奇数的下标
			while (A[end] % 2 != 0) {
				end--;
				if(start > end){
					return A;
				}
				
			}
			int tem = A[start];
			A[start] = A[end];
			A[end] = tem;
			start ++;
			end -- ;
			
		}
		return A;
		
		
        
    }
	
	
	
	public String longestWord(String[] words) {
		//先对words进行字典序排列
		
		Arrays.sort(words);
		//然后使用set集合
		Set<String> temSet = new HashSet<>();
		String resutString = new String();
		for (int i = 0; i < words.length; i++) {
			
			//长度为1，或者前者已经在set中
			if(words[i].length() == 1 || temSet.contains(words[i].substring(0, words[i].length() - 1))){
				temSet.add(words[i]);
				resutString = words[i].length() > resutString.length() ? words[i]:resutString;
			}
		}
		
        return resutString;
    }
	
	
	public  static boolean isToeplitzMatrix(int[][] matrix) {
		if(matrix.length == 1){
			return true;
		}
		
		if(!isget(matrix, 0, 0)){
			return false;
		}
		//循环行，然后循环列
		for (int i = 1; i < matrix.length; i++) {
			if(!isget(matrix, i, 0))
				return false;
		}
		//循环行，然后循环列
				for (int i = 1; i < matrix[0].length; i++) {
					if(!isget(matrix, 0, i))
						return false;
				}
		return true;
    }
	public static boolean isget(int[][] matrix,int row,int column ){
		
		while (row < matrix.length -1 && column < matrix[row].length - 1) {
			if(matrix[row][column] != matrix[row + 1][column + 1]){
				return false;
			}else {
				row ++;
				column ++;
			}
		}
		return true;
	}
	
	
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int j = i;
			while (j!=0) {
				int tem = j % 10;
				j = j/10;
				if(tem==0)
					continue;
				if(i % tem != 0 ){
					break;
				}
				if( j == 0 ){
					result.add(i);
				}
				
			}
			
		}
		
		return result;
    }
	
	
	
	
	
	public double largestTriangleArea(int[][] points) {
		double max = 0;
		for (int i = 0; i < points.length; i++) {
			//points有n行，两列
			//int[] js = points[i];
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					max = Math.max(max,getarea_Triangle(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]) );
					
				}
				
			}
			
		}
		
		return max;
		
        
    }
	//给三个点，求出面积
	public static double getarea_Triangle(int x1,int y1 ,int x2,int y2,int x3,int y3){
		//求模
		int tem = Math.abs(x2*y3 + x1*y2 + x3*y1 - x3*y2 - x2*y1 - x1*y3);
		System.out.println(tem);
		return tem/2.0; 
		
	}
	public int arrayPairSum(int[] nums) {
		//我的思路：首先将该数组进行排序，并且按照偶数进行取数即可
		
		int max = 0;
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i+=2) {
			int j = nums[i];
			
			max += j;
		}
		return max;
		
		
        
    }
	
	
	public int findLHS(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		
		
		Map<Integer, Integer> temMap = new HashMap<>();
		int max = 0;
		
		for (int i : nums) {
			temMap.put(i, temMap.getOrDefault(i, 0) + 1);
		}


		for (int i : temMap.keySet()) {
			if(temMap.containsKey(i+1)){
				max = Math.max(max, temMap.get(i) + temMap.get(i+1));
			}
		}
		
		
		
		
		
		
		return max;

		
		
		
		
		
    }
	public int getImportance(List<Employee> employees, int id) {
		
		//换个思路：
		
		int result = 0;
		int max = 0;
		for (Employee employee : employees) {
			if(employee.id > max){
				max = employee.id;
			}
		}
		int []subordinate = new int[max + 1];
		//首先放入到hashmap，这样方便取
		Map<Integer, Employee> hash = new HashMap<>();
		for (Employee employee : employees) {
			hash.put(employee.id, employee);
			
		}
		Queue<Employee> ids = new LinkedList<>();
		ids.offer(hash.get(id));
		
		while (!ids.isEmpty()) {
			Employee tEmployee = ids.poll();
			subordinate[tEmployee.id] = tEmployee.importance;
			List<Integer> list = tEmployee.subordinates;
			for (Integer integer : list) {
				ids.offer(hash.get(integer));
			}
		}

		for (int i = 0; i < subordinate.length; i++) {
			result += subordinate[i];
		}
		return result;
		
		
		/*int max = 0;
		for (Employee employee : employees) {
			if(employee.id > max){
				max = employee.id;
			}
		}
		int []subordinate = new int[max + 1];
		int result = 0;
		//思路：首先将所有的下属放在subordinate数组中
		//找到id
		Queue<Employee> ids = new LinkedList<>();
		for (Employee employee : employees) {
			if(employee.id == id){
				ids.offer(employee);
				subordinate[id] = employee.importance;
				break;
			}
		}
		
		while (!ids.isEmpty()) {
			Employee tem = ids.poll();
			List<Integer> zhixi = tem.subordinates;
			for (Integer integer : zhixi) {
				for (Employee employee : employees) {
					if(employee.id == integer){
						ids.offer(employee);
						subordinate[integer] = employee.importance;
						break;
					}
				}
			}
			
		}
		
		for (int i = 0; i < subordinate.length; i++) {
			result += subordinate[i];
			
		}
		
		return result;*/
		
        
    }
	public int networkDelayTime(int[][] times, int N, int K) {
			//我理解的Dijkstra 最短路算法，首先定义一个list存放所有没有遍历的点，然后定义一个数组，存放K到各个节点的距离，N个点，长度为N+1，那么下标为
			//K的长度就是0，因为本身到本身就是0，接着我们用一个队列存放所有点的出点，在进行存放时要注意的是：已经遍历的点不能放进去
			//每次从队列中取出一个点时，我们计算该点到另一个点的距离，并且更新距离数组，之后判断是否要将目的点放入到队列，如果已经放入过那么无需放入队列，否则
			//放入队列
			//具体实现：
			//距离数组
			int distance [] = new int[N+1];
			//遍历过的list
			List<Integer> already = new ArrayList<>();
			for (int i = 1; i < distance.length; i++) {
				//首先初始化时最远距离，这里使用的是Integer的最大值代替
				distance[i] = Integer.MAX_VALUE;
			}
			
			distance[K] = 0;
			
			distance[K] = 0;
			already.add(K);
			//设置当前遍历的队列
			Queue<Integer> Traversing = new LinkedList<>();
			Traversing.offer(K);
			while (!Traversing.isEmpty()) {
				//从节点中遍历所有的点，并且更新距离数组
				//int[][] times数组是n行三列，其中第一列是起点，第二列是终点
				//从队列中取出一个点
				int tem = Traversing.poll();
			//	System.out.println("点的顺序为"+ tem);
				for (int i = 0; i < times.length; i++) {
					//times[i][0]表示的是起点
					if(times[i][0] == tem){
					//	System.out.println("当前起点为"+tem + "距离为"+ distance[tem]);
						//等于当前的起点
						//取出终点
						int end = times[i][1];
						int distem = times[i][2];
						if(distance[end] > distem + distance[tem]){
							distance[end] =  distem + distance[tem];
					//		System.out.println("当前到"+end+"点的最小距离为"+ distance[end]);
							if(!Traversing.contains(end)){
								Traversing.offer(end);
								
							}
						}
					
					}
				}
			}
			int max = distance[0];
			for (int i = 0; i < distance.length; i++) {
				int j = distance[i];
				//存在不可到达的点
				if(j==Integer.MAX_VALUE){
					return -1;
				}
				if(max < j){
					max = j;
				}
			}
			System.out.println(Arrays.toString(distance));
	        return max;
			
			
		/*	
		 * 
		 * 
		 * int lop = 1;
			while (lop != 0) {
				lop--;
				for (int i = 0; i < times.length; i++) {
					if(distance[times[i][0]] != Integer.MAX_VALUE){
						//int t = distance[times[i][1]];
						if(times[i][2] + distance[times[i][0]] < distance[times[i][1]]){
							distance[times[i][1]] = times[i][2] + distance[times[i][0]];
							lop = 1;
						}
						
						
						
					}
				}
			}
			
			System.out.println(Arrays.toString(distance));
			int max = distance[1];
			for (int i = 1; i < distance.length; i++) {
				int j = distance[i];
				//存在不可到达的点
				if(j==Integer.MAX_VALUE){
					return -1;
				}
				if(max < j){
					max = j;
				}
			}
	        return max;*/
			
			
		/*	//初始化起点为0，因为起点到起点就是0
			distance[K] = 0;
			already.add(K);
			//设置当前遍历的队列
			Queue<Integer> Traversing = new LinkedList<>();
			Traversing.offer(K);
			while (!Traversing.isEmpty()) {
				//从节点中遍历所有的点，并且更新距离数组
				//int[][] times数组是n行三列，其中第一列是起点，第二列是终点
				//从队列中取出一个点
				int tem = Traversing.poll();
			//	System.out.println("点的顺序为"+ tem);
				for (int i = 0; i < times.length; i++) {
					//times[i][0]表示的是起点
					if(times[i][0] == tem){
					//	System.out.println("当前起点为"+tem + "距离为"+ distance[tem]);
						//等于当前的起点
						//取出终点
						int end = times[i][1];
						int distem = times[i][2];
						if(distance[end] > distem + distance[tem]){
							distance[end] =  distem + distance[tem];
					//		System.out.println("当前到"+end+"点的最小距离为"+ distance[end]);
						}
						//判断是否要进入队列，进行下一次的遍历
						if(already.contains(end)){
							
						}else {
							//没有遍历过则继续
							already.add(end);
							Traversing.offer(end);
						}
					}
				}
			}
			int max = distance[0];
			for (int i = 0; i < distance.length; i++) {
				int j = distance[i];
				//存在不可到达的点
				if(j==Integer.MAX_VALUE){
					return -1;
				}
				if(max < j){
					max = j;
				}
			}
			System.out.println(Arrays.toString(distance));
	        return max;*/
	    }
	
	public char nextGreatestLetter(char[] letters, char target) {
		int tem = 26;
		char result = letters[0];
		char min = letters[0];
		for (int i = 0; i < letters.length; i++) {
			char c = letters[i];
			if(c > target){
				if(tem > (c-target)){
					tem = c - target;
					result = c;
				}
			}
			
			if(min > c){
				min = c;
			}
		}
		if(tem == 26){
			return min;
		}
		return result;
        
    }
	 public String toLowerCase(String str) {
		 char tem[] = str.toCharArray();
		 
		 for (int i = 0; i < tem.length; i++) {
			char c = tem[i];
			if( c<='Z' && c>='A'){
				tem[i] = (char) (tem[i] + 32);
			}
			
		}
		 
		 
		 
		 return new String(tem);
	        
	  }
	public static int findLengthOfLCIS(int[] nums) {
		int max = 0;
		int start = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] >= nums[i + 1]){
				
				max = Math.max(i - start + 1, max);
				start = i + 1;
				if(max >= nums.length - start + 1){
					return max;
				}
			}else {
				
			}
			
		}
        return Math.max(max, nums.length - start);
    }
	
	  public List<String> letterCasePermutation(String s) {
		  List<String> result = new ArrayList<>();
		  get(result, 0, "", s);
		  return result;
		  
		  
		  
	  }
	  public static void get(List<String> tem, int i,String temstring,String s){
		  if(i ==  s.length()){
			  tem.add(temstring);
			  return ;
		  }
		  if(Character.isLetter(s.charAt(i))){
			  get(tem  , i + 1, temstring + Character.toLowerCase(s.charAt(i)), s);
			
			  get(tem  , i + 1, temstring + Character.toUpperCase(s.charAt(i)), s);
			
			  
		  }else {
			get(tem, i + 1, temstring + s.charAt(i), s);
		}
		  
		  
		  
	  }

/*	
	给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。

	操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。

	在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
	示例 1:
		
		输入: 
		m = 3, n = 3
		operations = [[2,2],[3,3]]
		输出: 4
		解释: 
		初始状态, M = 
		[[0, 0, 0],
		 [0, 0, 0],
		 [0, 0, 0]]
		
		执行完操作 [2,2] 后, M = 
		[[1, 1, 0],
		 [1, 1, 0],
		 [0, 0, 0]]
		
		执行完操作 [3,3] 后, M = 
		[[2, 2, 1],
		 [2, 2, 1],
		 [1, 1, 1]]

	*m行
	*n列
	*/
	
	public static int maxCount(int m, int n, int[][] ops) {
		if(ops.length == 0){
			return n * m;
		}
		if(ops.length == 1){
			return Math.min(ops[0][0] * ops[0][1], m*n);
		}
		
		int minrow = ops[0][0];
		int minclunm = ops[0][1];
		for (int i = 1; i < ops.length; i++) {
			if(minclunm > ops[i][1]){
				minclunm = ops[i][1];
			}
			
			if(minrow > ops[i][0]){
				minrow = ops[i][0];
			}
			
		}
		System.out.println(minrow);
		System.out.println(minclunm);
        return minrow * minclunm;
    }

		public int[] diStringMatch(String S) {
			
			
			int N = S.length();
			int []result = new int[N +1];
			int start = 0;
			int end = N;
			for (int i = 0; i < S.length(); i++) {
				//最小值start开始赋值
				if(S.charAt(i) == 'I'){
					result[i] = start ++;
					
					//最大值end开始赋值
				}else {
					result[i] = end--;
				}
			}
			result[N] = start;
			return result;
		}
	
/*	给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。

	我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。

	山羊拉丁文的规则如下：

	如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
	例如，单词"apple"变为"applema"。

	如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
	例如，单词"goat"变为"oatgma"。

	根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
	例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
	返回将 S 转换为山羊拉丁文后的句子。*/
	
	public static String toGoatLatin(String S) {
	//	char [] tem = S.toCharArray();
		String [] get = S.split(" ");
		System.out.println(Arrays.toString(get));
		StringBuilder a = new StringBuilder("a");
		for (int i = 0; i < get.length; i++) {
			if((get[i].charAt(0)+"").equalsIgnoreCase("a") ||
				(get[i].charAt(0)+"").equalsIgnoreCase("e")||
				(get[i].charAt(0)+"").equalsIgnoreCase("o")||
				(get[i].charAt(0)+"").equalsIgnoreCase("i")||
				(get[i].charAt(0)+"").equalsIgnoreCase("u")){
				
				get[i] = get[i] + "ma" + a;
			//	System.out.println(get[i]);
			}else {
				char[] te = get[i].toCharArray();
				//先把第一个单词保存
				char s = te[0];
				for (int j = 0; j < te.length - 1; j++) {
					te[j] = te[j + 1];
					
					
				}
				te[te.length - 1 ] = s;
				get[i] = new String(te);
				get[i] = get[i] + "ma" + a;
			}
			
			a.append("a");
			
		}
		
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < get.length; i++) {
			if(i == get.length -1){
				sb.append(get[i]);
				
			}else {
				sb.append(get[i]);
				sb.append(" ");
			}
		}
		return new String(sb);
    }
	
	public static int binaryGap(int N) {
	        
		 /*        
		  * 输入：5
			输出：2
			解释：
			5 的二进制是 0b101
	    */
		 //首先判断是否只有一个1，如果只有一个1那么返回0，或者N本身就是0，那么也返回0，这个条件包含了N等于0这种情况
		 if((N & (N - 1) ) == 0 )
			 return 0;
		 
		 int start = 0;
		 int end = 0;
		 
		 int max = 0;
		 while (true) {
			 if((N & 1) == 1){
				 break;
			 }else {
				 start ++;
				
				 N = N >> 1;
			}
			
		}
		 end = start;
		 N = N >> 1;
		 while (N != 0) {
			 
			 if(N % 2 == 1){
				 end ++;
				
				 max = Math.max(max, end - start);
				 start = end;
			 }else {
				end ++;
			}
			 N = N >> 1;
			
		}
		 
		 return max;
	    
	 
	 
	 }
	public int calPoints(String[] ops) {
		
		//一个计数器计算总的得分，用于最后的返回
		int count = 0;
		//一个计数器用于计算每一轮的,push,pop,peek
	//	Stack<Integer> tem = new Stack();
		int size = 0;
		int tem [] = new int[1024];
		for (int i = 0; i < ops.length; i++) {
			String string = ops[i];
			/*1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
			2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
			3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
			4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。*/
			if(string.equals("C")){
				//int fenshu = tem.pop();
				int fenshu = tem[size];
				size --;
				count -= fenshu;
			}else if (string.equals("D")) {
				count += tem[size]*2;
				size++;
				tem[size] = tem[size-1] * 2;
			}else if (string.equals("+")) {
				//取出前两轮的得分
				int yilun = tem[size];
				int erlun = tem[size-1];
				size ++;
				int score = yilun + erlun;
				tem[size] = score;
				count +=score;
			}else {
				//数字的化就直接转成数字放入
				int score = Integer.parseInt(string);
				count += score;
				size ++;
				
				tem[size] = score;
			}
			
			
		}
		
		
		return count;
        
    }
	
	
	/*
	如果一个数的每位数字被旋转以后仍然还是一个数字， 
	则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
	2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。*/
	public static int rotatedDigits(int N) {
	
		
		int count = 0;
		
		
		for (int i = 1; i <= N; i++) {
			int tem = i;
			String string = Integer.toString(i);
			String temstring = "";
			while (tem != 0) {
				int te = tem % 10;
				if(te == 3 || tem == 4 || tem == 7){
					temstring = string;
					break;
				}else if (te == 5 ) {
					temstring = 2 + temstring;
				}else if (te == 2) {
					temstring =  5 + temstring;
				}else if (te == 6) {
					temstring = 9 + temstring;
				}else if (te == 9) {
					temstring = 6 + temstring;
				}else {
					temstring = te + temstring ;
				}
				tem = tem/10;
			}
			if(!temstring.equals(string)){
				System.out.println(temstring);
				count++;
			}
			
		}
		return count;
		
        
    }
	
	
	public static int minDeletionSize(String[] A) {
		int count = 0;
		for (int i = 0; i < A[0].length(); i++) {
			for (int j = 0; j < A.length-1; j++) {
				if(A[j].charAt(i) > A[j+1].charAt(i) ){
					count++;
					break;
				}
				
				
			}
		}
		
		
        return count;
    }
	public static boolean judgeSquareSum(int c) {
        if(c == 1 || c == 2 || c == 4){
        	return true;
        }
        int start = 0;
        int end = (int) Math.sqrt(c);
        while (start <= end) {
        	if(start* start + end * end > c){
        		end--;
        	}else if (start* start + end* end < c) {
        		start++;
				
			}else {
				return true;
			}
			
		}
        return false;


	
	
	
	}
	public boolean judgeCircle(String moves) {
		
		int countUpandDown = 0;
		int countLeftandRigth = 0;
		char[] s = moves.toCharArray();
		//
		
		for (int i = 0; i < s.length; i++) {
			char c = s[i];
			if(c == 'L'){
				countLeftandRigth++;
			}else if (c == 'R') {
				countLeftandRigth--;
			}else if (c == 'U') {
				countUpandDown++;
			}else {
				countUpandDown--;
			}
		}
		if(countLeftandRigth == 0&& countUpandDown == 0){
			return true;
		}
		
		
		return false;
        
    }
	public static double findMaxAverage(int[] nums, int k) {
		if(nums.length == 1){
			return (double)nums[0] / k;
		}
		int tem = 0;
		for (int i = 0; i < k; i++) {
			tem+=nums[i];
			
		}
		int result = tem;
		//0,1,2,3
		for (int i = 1; i <= nums.length - k; i++) {
			
			result = result - nums[i - 1] + nums[i+k-1];
			tem  = Math.max(result, tem);
			
		}
		
		return (double)tem/ k;
		
        
    }
	public static int distributeCandies(int[] candies) {
		int tem [] = new int[200001];
		for (int i = 0; i < candies.length; i++) {
			int j = candies[i];
			tem[j+100000] ++;
			
		}
		int count = 0;
		for (int i = 0; i < tem.length; i++) {
			if(tem[i] != 0){
				count ++;
				if(count == candies.length /2){
					break;
				}
			}
			
		}
		return count;
		
		
		
		/*int len = candies.length;
		Arrays.sort(candies);
		if(len == 2){
			return 1;
		}
		
		int count = 0;
		for (int i = 0; i < candies.length-1; i++) {
			if(candies[i] != candies[i+1]){
				count++;
				
			}
			
		}
		count ++;
		if(count >= candies.length /2){
			return candies.length /2;
		}
		return count;
		*/
        
    }
	public static boolean checkRecord(String s) {
		 boolean result = true;
			char []chas = s.toCharArray();
			int j = 0;
			for (int i = 0; i < chas.length; i++) {
				if(chas[i] == 'A'){
					j++;
				}
				if(j >= 2){
					return false;
				}
			}
			System.out.println("fd");
			for (int i = 0; i < chas.length-2; i++) {
				if((chas[i] == 'L' && chas[i+1] == 'L' && chas[i+2] == 'L')){
	                return false;
				}
			}
			
			
			
			return result;
        
    }
	/*给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。

	如果没有任何矩形，就返回 0。
	
	
	
	注意的是只有一列，有n行
	*/
	public static double minAreaFreeRect(int[][] points) {
		
		int x = 1;
		double area = Double.MAX_VALUE;
		
		for (int i = 0; i < points.length; i++) {
			int point1[] = {points[i][0],points[i][1]};
			for (int j = i; j < points.length; j++) {
				if(i!=j){
					int point2[] = {points[j][0],points[j][1]};
						for (int k = j; k < points.length; k++) {
							if(j!=k && k!= i){
								int point3[] = {points[k][0],points[k][1]};
								
								//到这里我们从中任取了三个点，之后判断这三个点能否组成直角，那么有三种情况
								//以其中一个点为终点，其余点减去，用向量来计算						
								
								System.out.println("第"+x++);
								System.out.println(point1[0] +"  y   " + point1[1]);
								System.out.println(point2[0] +"  y   " + point2[1]);
								System.out.println(point3[0] +"  y   " + point3[1]);
								if(is(point1[0], point1[1], point2[0], point2[1], point3[0], point3[1])){
									System.out.println("1可以");
									int x1 = 0;
									int y1 = 0;
									if(isinpoints(x1, y1, points)){
										area = Math.min(area, x1);
									}
									
								}
								if (is(point2[0], point2[1], point1[0], point1[1], point3[0], point3[1])) {
									System.out.println("2可以");

								}
								if (is(point3[0], point3[1], point2[0], point2[1], point1[0], point1[1])) {
									System.out.println("3可以");
								}
								
								
								
						  }
					}
				}
				
			}
			
		}
		
		if(area == Double.MAX_VALUE){
			return 0;
		}
		
		return area;
        
    }
	public static boolean is(int i0,int j0,int i1,int j1,int i2,int j2){
		if((i1-i0)*(i2-i0) + (j1-j0)*(j2-j0)  == 0){
			return true;
		}else {
			return false;
		}
		
	}
	//判断第四个点是否在points数组中
	public static boolean isinpoints(int x,int y,int[][] points){
		for (int i = 0; i < points.length; i++) {
			if(x == points[i][0] && y == points[i][1]){
				return true;
			}
			
		}
		return false;
		
	}
	//给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。

	//找出 A 中的坡的最大宽度，如果不存在，返回 0 。
	public int maxWidthRamp(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			int tem = A[i];
			for (int j = A.length -1; j > i; j--) {
				if(tem <= A[j]){
					count = Math.max(count, j-i);
					break;
				}
			}
			if(count == A.length - 1)
				break;
		}
		
		return count;
        
    }
	//题目描述在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

	//返回重复了 N 次的那个元素。
	public int repeatedNTimes(int[] A) {
		int size = A.length / 2;
		int max = A[0];
		for (int i : A) {
			if(i> max){
				max = i;
			}
		}
		int tem [] = new int[max+1];
		for (int i = 0; i < A.length; i++) {
			tem[A[i]] ++;
		}
		for (int i = 0; i < tem.length; i++) {
			if(tem[A[i]] == size){
				return A[i];
			}
		}
		return 0;
        
    }
	
	public static boolean hasAlternatingBits(int n) {
		 int temp=n^(n>>1);
		 
		 
		 return (temp&(temp+1))==0;
		/*//是1或0那么一定是的
		if(n == 1 || n == 0){
			return true;
		}
		int i = n % 2;
		n = n>>1;
		while ( n!=0 ) {
			int j = n % 2;
			if((i ^ j) == 0 ){
				return false;
				
			}else {
				i = j;
				n = n >> 1;
			}
		}
		return true;*/
        
    }
	public static int[] findErrorNums(int[] nums) {
		int result[] = new int[2];
		int max = nums.length;
		
		int []tem = new int[max+1];
		for (int i = 0; i < nums.length; i++) {
			tem[nums[i]] ++;			
		}
		for (int i = 1; i < tem.length; i++) {
			if(tem[i] == 2){
				result[0] = i;
			}
			if(tem[i] == 0){
				result[1] = i;
			}
		}
		return result;
		
		
    }
	public static int pathSum(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			if(root.val != sum){
				return 0;
			}else {
				return 1;
			}
		}
		Stack<TreeNode> tem = new Stack<>();
		tem.push(root);
		
		int count = 0;
		while (!tem.isEmpty()) {
		
			
			TreeNode s = tem.pop();
			find(s, sum, 0,count);
			if(s.left != null){
				tem.push(s.left);
			}
			if(s.right != null){
				tem.push(s.right);
			}
		}
	
		
		
		return count;
        
    }
	public  static void find(TreeNode treeNode,int exceptsum,int currentnum,int count){
		
		if(treeNode.val + currentnum ==  exceptsum){
			count++;
		}
		
		if(treeNode.left != null){
			find(treeNode.left,exceptsum, currentnum + treeNode.val,count);
		}
		if(treeNode.right != null){
			find(treeNode.right,exceptsum, currentnum + treeNode.val,count);
		}
		
		
		
	}
	public static int[] constructRectangle(int area) {
		int [] result = new int[2];
		if(area  == 1){
			result[0] = 1;
			result[1] = 1;
			return result;
		}
		int mid = (int) Math.sqrt(area);
		while (mid >= 1) {
			if(area % mid == 0){
				result[1] = mid;
				result[0] = area % mid;
				break;
			}else {
				mid--;
			}
		}
		
		return result;
        
    }
	public int getMinimumDifference(TreeNode root) {


		return 0;
		
		
		
        
    }
	
	public static int reachNumber(int target) {
		
		int count = 0;
		target = Math.abs(target);
		
		while ((count*(count + 1)) /2 < target) {
			count ++;
		}
		int tem = (count*(count + 1)) /2 ;
		if((count*(count + 1)) /2 == target || ((tem - target) & 1) == 0){
			return count;
		}
		if((count & 1) == 0){
			return count+1;
		}else {
			return count+2;
		}
        
    }
	
	public static boolean validMountainArray(int[] A) {
		if(A.length < 3){
			return false;
		}
		
		int max = A[0];
		int maxindex = 0;
		
		for (int i  = 1; i < A.length; i++) {
			int j = A[i];
			if(j == max){
				return false;
			}
			if(j > max){
				max = j;
				maxindex = i;
			}
		}
		if(maxindex == A.length-1){
			return false;
		}
		for (int i = maxindex-1; i >= 0; i--) {
			if(!(A[i]<A[i+1])){
				return false;
			}
			
		}
		for (int i = maxindex; i < A.length -1 ; i++) {
		
			if((A[i]== A[i+1])||(A[i] < A[i+1])){
				
				return false;
			}
			
		}
		
		
		return true;
        
    }
	public static int numJewelsInStones(String J, String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < J.length(); i++) {
			map.put(J.charAt(i), i);
			
		}
		
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if(map.containsKey(S.charAt(i)))
				count++;
			
		}
		
		return count;
        
    }
	public  static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		
		
	//	sb.append(temString[0].toUpperCase());
		String newstirngString = S.replaceAll("-", "").toUpperCase();
		String result = "";
		for (int i = newstirngString.length(); i  >= 0 ; i-=K) {
		//	System.out.println(newstirngString.substring(0,i));
			if(i - K >= 0){
				if(result.length() == 0){
					result = newstirngString.substring(i-K, i) ;
				}
				else {
					result = newstirngString.substring(i-K, i) + "-" + result;
				}
			}else {
				if(result.length() == 0){
					result = newstirngString.substring(0,i) ;
							
				}else {
					if(newstirngString.substring(0, i).length() == 0){
						
					}else {
						result = newstirngString.substring(0,i) +"-" +  result;
					}
					
				}
			}
			
		}
		
		
	
		
		return result;
        
    }
	public static  int findMaxConsecutiveOnes(int[] nums) {
		
		
		int count = 0;
		int tem = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1)
				tem++;
			else {
				count = Math.max(tem, count);
				tem = 0;
			}
			
		}
		return count;
		
		/*int mak = 0;
		int w = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i == nums.length-1 || (nums[i+1]) != nums[i]){
				if(nums[w] == 1){
					mak = Math.max(i - w + 1, mak);
				}
				
				w = i + 1;
			}
			
			
			
		}
		
		
		return mak;
		
		*/
        
    }
	public static int compress(char[] chars) {
        if(chars.length == 1 || chars.length == 0){
        	return chars.length;
        }
        int write = 0;
        int mark = 0;
        for (int i = 0; i < chars.length; i++) {
			if(i == chars.length -1 || chars[i] != chars[i+1]){
				chars[write++] = chars[mark];
				if(mark < i){
					for (char c : (""+(i-mark+1)).toCharArray()) {
						chars[write++] = c;
					}
					
				}
				mark = i + 1;
			}
			
		}
        
        return write;
        
        
        
        
    }
	
	
	public static int largestPalindrome(int n) {
		
	   if (n == 1) {
			return 1;
			
		}else {
			int upper = (int) Math.pow(10, n) - 1;
			
			int lower = upper / 10;
			for(int i = upper; i > lower; i--){
				long is = re(i);
				System.out.println(is);
				for ( long x = upper; x * x >= is; x--) {
					if(is % x == 0)
						return (int) (is%1337);
					
				}
				
			}
			
			return 0;
			
		}
        
    }
	public static long re(long i){
		
		
		
		StringBuilder isBuilder = new StringBuilder();
		isBuilder.append(i+"");
		String reverse = isBuilder.reverse().toString();
		
		return Long.parseLong(i+""+reverse);
		
	}
	public static int findComplement(int num) {
		if(num == 1){
			return 0;
		}
		if(num == 0)
			return 1;
		
		int tem = num;
		int result = 0;
		int result2 = 0;
		//首先计算有多少位
		while (num != 0) {
			
			 result = result * 2 + (num & 1 ^ 1);
			
		     num = num >> 1;
		     result2 ++;
		}
		int result1 = 0;
		while (result2 > 0) {
			result1 = result1 * 2 +( result&1);
			result = result >> 1;
			result2 --;
			
		}
        return result1;
    }
	
	public static int findRadius(int[] houses, int[] heaters) {
		int min = 0;
		
		Arrays.sort(heaters);
		Arrays.sort(houses);

	//	int houselength = houses.length;
		int heaterslength = heaters.length;
		int j  = 0;
		for (int i = 0; i < houses.length; i++) {
			while (j < heaterslength - 1 &&( Math.abs(houses[i] - heaters[j]) >=  Math.abs(houses[i] - heaters[j+1]))) {
				j++;
			}
			min = Math.max(min,  Math.abs(houses[i] - heaters[j]));
		}
		
		
		
		return min;
    }
	
	
	public static  int minMoves(int[] nums) {
		int count = 0;
		if(nums.length == 0 || nums.length == 1){
			return 0;
		}
		if(nums.length == 2){
			return nums[1] - nums[0] > 0? nums[1] - nums[0]:nums[0] - nums[1];
		}
		//Arrays.sort(nums);
		while (!isEqual(nums)) {
			Arrays.sort(nums);
			
			int tem = nums[nums.length - 1] - nums[nums.length - 2];
			int j = nums.length - 1;
			while (tem == 0) {
				tem = nums[j-1] - nums[j-2];
				j--;
				
			}
			//System.out.println(tem);
			count+= tem;
		
			for (int i = 0; i < nums.length-1; i++) {
				
				//	System.out.println(nums[i]+"自增啦");
					nums[i] +=tem;
					
			}
		}
		
		
		return count;
        
    }
	public static boolean  isEqual(int []nums){
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			
		}
		if(map.size() == 1){
			return true;
		}else {
			return false;
		}
		
		
		
	}
	public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int is = grid[i][j];
				if(is == 1){
					if(i == 0 || grid[i-1][j] == 1){
						count++;
					}
					if(j == 0 || grid[i][j-1] == 1){
						count++;
					}
					if(i == grid.length -1 || grid[i+1][j] == 1){
						count++;
					}
					if(j == grid[i].length - 1 || grid[i][j+1] == 1){
						count++;
					}
				}
				
			}
			
		}
        
        
        return count;
    }
	public static int maximumProduct(int[] nums) {
		int max[] = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		int min[] = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		for (int i = 0; i < nums.length; i++) {
		
			int j = nums[i];
			if(j > max[0]){
				if(j > max[1]){
					if(j > max[2]){
						max[0] = max[1];
						max[1] = max[2];
						max[2] = j;
						
					}else {
						max[0] = max[1];
						max[1] = j;
						
					}
				}else {
					
					max[0] = j;
				}
			}
		if(j < min[0]){
			if(j < min[1]){
				if(j < min[2]){
					min[0] = min[1];
					min[1] = min[2];
					min[2] = j;
				}else {
					min[0] = min[1];
					min[1] = j;
				}
			}else {
				min[0] = j;
			}
		}
			
			
		}
		
		int max1 = max[0] * max[1] * max[2];
		int max2 = min[1] * min[2] * max[2];
		
		return max2 > max1? max2:max1;
		
        
    }
	public static String convertToBase7(int num) {
		
		if(num == 0){
			return "0";
		}
		String result = new String();
		
		boolean isMinus = false;
		if(num < 0){
			isMinus = true;
			num = -num;
		}
		
		
		while (num != 0) {
			result = num % 7 +result;
			num = num/7;
		}
		return isMinus? "-" + result : result;
        
    }
	
	public int numberOfBoomerangs(int[][] points) {
        
		int result = 0;
		
		
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
		
			for (int j = 0; j < points.length; j++) {
				if(i!=j){
					int x1 = points[i][0] - points[j][0];
					int y1 = points[i][1] - points[j][1];
					int distance = x1 * x1 + y1 * y1;
					map.put(distance, map.getOrDefault(distance,0) + 1);
				}
			
			}	
			for (Integer j1 : map.values()) {
				if(j1 > 1){
					result += j1*(j1-1); 
				}
				
			}
			
		}
		
		
		return result;
		
		
    }
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums.length == 0){
			return result;
		}
		int max = nums.length;
		int sum[] = new int[max+1];
		for (int i = 0; i < nums.length; i++) {
			sum[nums[i]]++;
			
		}
		for (int i = 1; i <= max; i++) {
			if(sum[i] == 0){
				result.add(i);
			}
		}
		
		
		return result;
        
    }
	
	public static int arrangeCoins(int n) {
		
		int count = 0;
		while (true) {
			count ++;
			
			if((1+count)%2==0){
				if((((1+count)/2)*count) <= n  && (((1+count)/2)*count) > 0){
					//	System.out.println(((1+count)*count) / 2);
						//count++;
					}else {
						return count-1;
					}
			}else {
				if(((count/2)*(1+count)) <= n && ((count/2)*(1+count)) > 0 ){
					//	System.out.println(((1+count)*count) / 2);
						//count++;
					}else {
						return count-1;
					}
			}
			
			
		}
		
		
		
		/*if(n == 1 || n== 2){
			return 1;
		}else {
			int count = 0;
			int s = 1;
			while (n >= 0 ) {
				
				n =n-s;
				count++;
				s++;
				
			}
		
			return count-1;
		}
        */
    }
	public static String[] findRelativeRanks(int[] nums) {
		
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int j = nums[i];
			if(max < j){
				max = j;
			}
			
		}
		int tem[] = new int[max+1];
		
		for (int i = 0; i < nums.length; i++) {
			tem[nums[i]] = i+1;
		}
		String [] result = new String[nums.length];
		int rank = 1;
		for (int i = max; i >= 0; i--) {
			if(tem[i]!=0){
				result[tem[i] -1] = rank+"";				
				rank++;
			}
		}
		
		
		
		
		
		return result;
		
		
		
		
		
		
		
		
		
		
		
		
		/*String[] result = new String[nums.length];
		
		int max = -1000;
		for (int string : nums) {
			if(max < string){
				max = string;
			}
		}
		
		
		int []temp = new int[max+1];
		
		
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]] = i+1;
		}
		int rank = 1;
		for (int i = max; i >= 1; i--) {
			if(temp[i]!=0){
				if(rank == 1){
					result[temp[i]-1] = "Gold Medal";
				}else if(rank == 2) {
					result[temp[i]-1] = "Silver Medal";
	
				}else if (rank == 3) {
					result[temp[i]-1] = "Bronze Medal";

				}else {
					result[temp[i]-1] = rank+"";
				}
			}
			rank ++;
			
		}
		
		return result;*/
        
    }
/*	public Node construct(int[][] grid) {
		return build(grid, 0, 0, grid.length);
        
    }*/
	
	/*public static Node build(int[][]gird,int x,int y,int len){
		if(len <=0 )
			return null;
		for (int i = x; i < x+len; i++) {
			for (int j = y; j < y+len; j++) {
				if(gird[i][j]!=gird[x][y]){
					return new Node(true,false,build(gird, x, y, len / 2),
	                           build(gird, x, y + len / 2, len / 2),
	                           build(gird, x + len/ 2, y, len / 2),
	                           build(gird, x + len / 2, y + len / 2, len / 2));
				}
				
			}
		}
		
		return new Node(gird[x][y] == 1, true, null, null, null, null);
	}*/
/*	public List<List<Integer>> levelOrder(Node root) {
	     List<List<Integer>> result = new ArrayList<>();
	     List<Integer> tem = new ArrayList<>();
	     Deque<Node> nodes = new LinkedList<>();
	     if(root == null){
	    	 return result;
	     }else {
	    	
			 nodes.offer(root);
			while (!nodes.isEmpty()) {
				tem = new ArrayList<>();
				List<Node> tem2 = new ArrayList<>();
				
				int size = nodes.size();
				
				for (int i = 0; i < size; i++) {
					Node node1 = nodes.poll();
					
					tem.add(node1.val);
					tem2 = node1.children;
					for (Node node : tem2) {
						nodes.offer(node);
					}
					
					
				}
				result.add(tem);
				
				
			}
			
			
			
		}
	     
	     return result;
		 
		 
	  }*/
	public int countSegments(String s) {
      
	
		int result = 0;
		
		char []tem = s.toCharArray();
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			char c = tem[i];

			if(c == ' '){
				flag = true;
			}
			if(c != ' ' && flag ){
				result++;
				flag = false;
			}
			
		}
		
		
		
		
		return result;
    }
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        
        char [] s1 = s.toCharArray();
        char [] s2 = p.toCharArray();
       
        for (int i = 0; i <= len1 - len2; i++) {
        	 int [] tem = new int[52];
			for (int j = 0; j < len2; j++) {
				if(Character.isUpperCase(s1[i+j])){
					tem[s1[i+j] - 65]++;
				}else {
					tem[s1[i+j] - 71]++;
				}
				
			}
			for (int j1 = 0; j1 < len2; j1++) {
				if(Character.isUpperCase(s2[j1])){
					tem[s2[j1] - 65]--;
				}else {
					tem[s2[j1] - 71]--;
				}
				
			}
			boolean flag = false;
			for (int j3 = 0; j3 < 52; j3++) {
				if(tem[j3] != 0 ){
					flag = true;
					if(tem[j3] == -1){
						i++;
					}
					
					break;
				}
				
			}
		   if(!flag)
			   result.add(i);
			
		}
        
        
        return result;
    }
	
	public static String addStrings(String num1, String num2) {
		int length1 = num1.length();
		int length2 = num2.length();
		int length = Math.min(num1.length(), num2.length());
		int maxlength = Math.max(length1, length2);
		int jinwei = 0;
		
		String string = "";
		int i = 0;
		for ( i = 0; i < length; i++) {
			int i1 = Integer.parseInt(Character.toString(num1.charAt(length1 - 1 -i)));
			int i2 = Integer.parseInt(Character.toString(num2.charAt(length2 - 1 -i)));
			
			int result =( i1 + i2 +jinwei) %10 ;
			string = string + result;
			if(i1 + i2 + jinwei >= 10 ){
				jinwei = 1;
			}else {
				jinwei = 0;
			}			
		}
		boolean flag = false;
		if(jinwei == 1 && length1 == length2){
			string = string+"1";
			
			flag = true;
			StringBuilder sb = new StringBuilder(string);
			
			return sb.reverse().toString();
		}else {
			if(jinwei == 0){
				for (int j = maxlength - i - 1 ; j >= 0; j--) {
					if(length1>length2){
						string = string + Character.toString(num1.charAt(j));
					}else {
						string = string + Character.toString(num2.charAt(j));
					}
					
				}
			}else {
				for (int j = maxlength - i - 1 ; j >= 0; j--) {
					//System.out.println(Character.toString(num2.charAt(j)));
					if(length1>length2){
						if(jinwei == 1){
							int s1 = Integer.parseInt(Character.toString(num1.charAt(j)))+ jinwei;
							if(s1 >= 10){
								jinwei = 1;
							}else {
								jinwei = 0;
							}
							string = string + s1%10;
						}else {
							string = string + Character.toString(num1.charAt(j));
						}
					}else {
						if(jinwei == 1){
						int s1 = Integer.parseInt(Character.toString(num2.charAt(j))) + jinwei;
						if(s1 >= 10){
							jinwei = 1;
						}else {
							jinwei = 0;
						}
					
						string = string + s1%10;
						
						}else {
							string = string + Character.toString(num2.charAt(j));
						}
					}
					
				}
			}
		}
		
		
		
		if(jinwei == 1 && !flag){
			string = string+"1";
		}
		StringBuilder sb = new StringBuilder(string);
		
		return sb.reverse().toString();
    }
	public static List<String> fizzBuzz(int n) {
		String [] tem = {"Fizz","Buzz","FizzBuzz"};
		List<String> reustlt = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 == 0){
				reustlt.add(tem[2]);
			}else if (i % 3 == 0) {
				reustlt.add(tem[0]);
			}else if (i % 5 == 0) {
				reustlt.add(tem[1]);
			}else {
				reustlt.add(i+"");
			}
		}
		return reustlt;
        
    }
	public static int longestPalindrome(String s) {
		//如果s为空或者字符串长度为0，那么返回零
		if(s == null || s.length() == 0)
			return 0;
		//用于存放结果长度
		int result = 0;
		//构造一个数组用于存放所有出现的字符个数
		int [] count = new int[52];
		for (int i = 0; i < s.length(); i++) {
			char tem = s.charAt(i);
			//如果是大写的话，那么数组下标从零开始到25
			if(Character.isUpperCase(tem)){
				count[tem - 65] ++;
			}
			//如果是小写的话，数组下标从26开始到51，定义的数组大小刚刚好
			else {
				count[tem - 71]++;
			}
		}
		boolean flag = false;
		for (int i = 0; i < count.length; i++) {
			int j = count[i];
			if(j % 2 == 0){
				result +=j;
			}else {
				//如果是奇数的话，取其偶数构成
				result = result +(j/2)*2;
				flag = true;
			}
		
		}
		//如果有奇数比如有aaa，那么我们可以取出一个放入中间
		return flag ? result +1 : result;
    }
	public static String largestTimeFromDigits(int[] A) {
       List<Integer> list = new ArrayList<>();
       list.add(A[0]);
       list.add(A[1]);
       list.add(A[2]);
       list.add(A[3]);
       String resut = "";
       int shuzhi = -1;
       for (int i1 = 0; i1 < 4; i1++) {
		int j1 = A[i1];
			for (int i2 = 0; i2 < 4; i2++) {
				if(i1 != i2){
					int j2 = A[i2];
					for (int i3 = 0; i3 < 4; i3++) {
						if(i1 != i2 && i2 != i3 && i3 != i1){
							int j3 = A[i3];
							for (int i4 = 0; i4 < 4; i4++) {
								if(i4 != i1 && i4 != i2 && i4 != i3){
									int j4 = A[i4];
									if(j1 > 2){
										continue;
									}
									
									if(j1 == 2){
										if(j2 > 3){
										}else {
											int tem = (j1*10+j2)*60;
											if(j3 > 5){
												
											}else {
												if(j4 > 9){
													
												}else {
													tem = tem + j3*10+j4;
													if(tem > shuzhi){
														shuzhi = tem;
														resut = j1+""+j2+":"+j3+""+j4;
													}
													
												}
											}
										}
										
										
									}
									if(j1 <= 1 && j1>=0){
										int tem = (j1*10+j2)*60;
										if(j2>9){
											
										}else {
											
											if(j3 > 5){
												
											}else {
												if(j4>9){
													
												}else {
													 tem = tem + j3*10+j4;
													if(tem > shuzhi){
														shuzhi = tem;
														resut = j1+""+j2+":"+j3+""+j4;
													}
												}
											}
										}
										
									}
									
									
					
								}
								
							}
						}
						
						
					}
				}
				
			}
		
	}
        return resut;
      
        
        
    }
	public List<String> readBinaryWatch(int num) {
		
		int []hour = {0,1,2,4,8};
		int []minute = {0,1,2,4,8,16,32};		
        List<String> result = new ArrayList<>();
        if(num == 1){
        	result.add("1:00");
        	result.add("2:00");
        	result.add("4:00");
        	result.add("8:00");
        	result.add("0:01");
        	result.add("0:02");
        	result.add("0:04");
        	result.add("0:08");
        	result.add("0:16");
        	result.add("0:32");
        	return result;
        }       
        return result;
    }
	public String toHex(int num) {
        
		return Integer.toHexString(num);
		
		
    }
	
	public static int thirdMax(int[] nums) {
		long max1 = Long.MIN_VALUE;
		long max2 = Long.MIN_VALUE;
		long max3 = Long.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if(max1 < j){
				 max3 = max2;
				 max2 = max1;
				 max1 = j;
				 
			}else if (j > max2 && j < max1) {
				
				max3 = max2;
				max2 = j;
				
			}else if (j < max2&& j > max3) {
				max3 = j;
				
			}
		}
		
		if(max3 == Long.MIN_VALUE){
			return (int) max1;
		}else {
			return (int) max3;
		}
		
		
    }
	public  static int sumOfLeftLeaves(TreeNode root) {
		
		
		Queue<TreeNode> tem = new LinkedList<>();
		if(root == null){
			return 0;
		}
		tem.offer(root);
		int sum = 0;
        while (!tem.isEmpty()) {
			int size = tem.size();
			for (int i = 0; i < size; i++) {
				TreeNode tem1 = tem.poll();
				if(tem1.left != null ){
					tem.offer(tem1.left);
					if(tem1.left.left == null && tem1.left.right == null){
						sum+=tem1.left.val;
					}
					
					
				}
				
				if(tem1.right !=null){
					tem.offer(tem1.right);
				}
				
			}
		}
        return sum;
    }
	
	 public int hammingDistance(int x, int y) {
	        
		 x = x^y;
		 int sum = 32;
		 int j = 0;
		 while (sum-- > 0) {
			 int j1 = x & 1 ;
			 
			 if(j1 == 1){
				 j++;
			 }
			 x = x>>1;
			 if(x == 0)
				 break;
			 
			
		}
		 
		 return j;
		 
	   }
	
	
	public static char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        int[] tem = new int[123];
        for (int i = 0; i < t.length(); i++) {
			char j = s2[i];
			if(i == t.length() -1){
				
			}else {
				tem[s1[i]]++;
			}
			tem[s2[i]]--;		
		}
		for (int i = 0; i < s2.length; i++) {
			char j = s2[i];
			if(tem[j] == -1){
				return j;
			}
			
		}
		return 'c';
		
		
		
    }
	public static int firstUniqChar(String s) {
		
		int flag[]= new int[123];
		
		for (int i = 0; i < s.length(); i++) {
			char tem = s.charAt(i);
			flag[tem] ++;
		}
		for (int i = 0; i < s.length(); i++) {
			char tem = s.charAt(i);
			if(flag[tem]==1) 
				return i;
		}		
		return -1;
		
		
        
	}
	
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.length() > magazine.length())
			return false;
		if(ransomNote.equals(magazine))
			return true;
		char[] s1 = ransomNote.toCharArray();
		char[] s2 = magazine.toCharArray();
		int [] flag = new int[256];
		for (int i = 0; i < s2.length; i++) {
			char c = s2[i];
			flag[c]++;
		}
		for (int i = 0; i < s1.length; i++) {
			char c = s1[i];
			if(flag[c] == 0){
				return false;
			}else {
				flag[c] --;
			}
		}
		return true;
    }
	
	public static int[] in1tersection(int[] nums1, int[] nums2) {
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int min = nums1.length>nums2.length?nums1.length:nums2.length;


		List<Integer> lst = new ArrayList<>();
		int i = 0;
		int j = 0;
		int length = 0;
		while (true) {
			if(i >= nums1.length)
				break;
			if(j >= nums2.length)
				break;
			if(nums1[i] > nums2[j]){
				j++;
				continue;
			}
			if(nums1[i] < nums2[j]){
				i++;
				continue;
			}
			if(length == 0){
				lst.add(nums1[i]);
				length ++;
				j++;
				i++;
			}else {
				if(lst.get(lst.size()-1) == nums1[i]){
					i++;
					j++;
				}else {
					lst.add(nums1[i]);
					i++;
					j++;
				}
			}
			
			
		}
		int []s = new int[lst.size()];
		int jx = 0;
		while (!lst.isEmpty()) {
			s[jx++] = lst.get(0);
			lst.remove(0);
			jx++;
		}
		return s;
		
        
    }
	
	
	
	public String reverseVowels(String s) {
        //    aeiouAEIOU
		int start = 0;
		int end = s.length()-1;
		
		char[] chars = s.toCharArray();
		while (start < end) {
			if(s.charAt(start) != 'a'&&s.charAt(start) != 'e'&&
					s.charAt(start) != 'i'&&
					s.charAt(start) != 'o'&&
					s.charAt(start) != 'u'&&
					s.charAt(start) != 'A'&&
					s.charAt(start) != 'E'&&
					s.charAt(start) != 'I'&&
					s.charAt(start) != 'O'&&
					s.charAt(start) != 'U'){
				
				start ++;
				continue;
			}
			
			if(s.charAt(end) != 'a'&&s.charAt(end) != 'e'&&
					s.charAt(end) != 'i'&&
					s.charAt(end) != 'o'&&
					s.charAt(end) != 'u'&&
					s.charAt(end) != 'A'&&
					s.charAt(end) != 'E'&&
					s.charAt(end) != 'I'&&
					s.charAt(end) != 'O'&&
					s.charAt(end) != 'U'){
				end --;
				continue;
				
				
				
			}
			char tem = s.charAt(end);
			chars[end] = chars[start];
			chars[start] = tem;
			start ++;
			end --;
			
			
			
			
		}
		
		
		
		return new String(chars);
        
    }
	
	
	
	
	
	
	
	public static void moveZeroes(int[] nums) {
		
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				
			}else {
				nums[j++] = nums[i];
			}
		}
		for (int i = j; i < nums.length; i++) {
			nums[i] = 0 ;
			
		}
		
		
		
        
    }
	public boolean isPowerOfFour(int num) {
		if(num == 1){
			return true;
		}else {
			while (true) {
				if(num % 4 != 0 )
					return false;
				
				num = num/4;
				if(num == 1){
					return true;
				}
			}
		}
        
    }
	public boolean isPowerOfThree(int n) {
		if(n == 1){
			return true;
		}else {
			return (n &(n-2)) == 0;
		}
		
		
		
		
    }
	
	
	public int sumRange(int i, int j) {
		
		return 0;
        
    }
	
/*	public static int firstBadVersion(int n) {
		if(n <=1 ){
			return 1;
		}
		
		if(!isBadVersion(1))
			return 1;
		if(!isBadVersion(n)){
			return n;
		}
        int start = 1;
        int end = n;
        while (start != end) {
        	int mid = (start + end)/2;
        	if(isBadVersion(mid)){
        		start = mid;
        	}else {
        		end = mid;
				
			}
        	
        	
		}
        return start;
		
		
		
    }*/
	public static int missingNumber(int[] nums) {
		
		boolean s[] = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			s[nums[i]] = true;
		}
		for (int i = 0; i < s.length; i++) {
			boolean b = s[i];
			if(!b){
				return i;
			}
		}
		
		return 0;
		
		
		
		
       /* Arrays.sort(nums);
        
        System.out.println(nums.toString());
        int i;
        for ( i = 0; i < nums.length-1; i++) {
		
			if(nums[i] + 1 != nums[i+1]){
				break;
			}
			
		}
        if(nums[0] == 1){
        	return 0;
        }
        
        return nums[i] + 1;     */   
    }
	
	public  static boolean isUgly(int num) {
		
		
		if(num == 1)
			return true;
		if(num <= 0){
			return false;
		}
		else {			
				while(num%2 == 0)
			    {
			        num >>= 1;
			    }
			    
			    while(num%3 == 0)
			    {
			        num /= 3;
			    }
			    
			    while(num%5 == 0)
			    {
			        num /= 5;
			    }
			    return num == 1;
				
		}
		
        
    }
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return null;
		}
		Deque<TreeNode> firs1 = new LinkedList<>();
		firs1.add(root);
		while (!firs1.isEmpty()) {
			System.out.println("输出");
			System.out.println(firs1.size());
			List<Integer> list = new ArrayList<>();
			int count = firs1.size();
			for (int i = 0; i < count; i++) {
				
				TreeNode temNode = firs1.poll();
				if(temNode.left !=null){
					firs1.offer(temNode.left);
				}
				
				if(temNode.right != null){
					firs1.offer(temNode.right);
				}
				
				list.add(temNode.val);
				
			}
			result.add(list);
		}
		return result;
        
    }
	
	
	
	
	public TreeNode sortedArrayToBST(int[] nums) {
		
		TreeNode root = new TreeNode(nums[nums.length/2]);
		int mid = nums.length /2;
		if(nums.length == 0)
			return null;
		
		root.left = sortedArrayToBST(nums, 0, mid-1);
		root.right = sortedArrayToBST(nums,mid+1,nums.length-1);
		return root;
    }
	public TreeNode sortedArrayToBST(int[] nums,int start, int end){
		
		if(start < end){
			return null;
		}
		int mid = (start + end) /2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid-1);
		root.right = sortedArrayToBST(nums,mid+1,end);
		return root;
		
	}
	public static int addDigits(int num) {

        
		
		if(num == 0){
			return 0;
		}
		
		return (num-1) % 9 +1;
		
		/*int x = 0;
		if(num <= 9){
			return num;
		}
		while (true) {
			x = 0;
			while (num > 0) {
				x += num%10;
				num /=10;
				
			}
			num = x;
			
			if(x <= 9){
				break;
			}			
		}
		return x;*/
    }	
	
	
	public static  List<String> binaryTreePaths(TreeNode root) {
		
		List<String> list = new ArrayList<>();
		if(root != null){
			List<String> left = new ArrayList<>();
			List<String> right = new ArrayList<>();
			
			
			left = binaryTreePaths(root.left);
			right = binaryTreePaths(root.right);
			
			
			if(left.size() == 0 && right.size() == 0){
				
				list.add(String.valueOf(root.val));
				
			}else {
					for (String string : left) {
						list.add(String.valueOf(root.val) + "->" + string);
						
					}
					for (String string : right) {
						list.add(String.valueOf(root.val) + "->"+ string);
						
					}
				}
			}
		return list;
		
		
		
		
		
		
		
		
		
		/* List<String>list=new ArrayList<>();
	        if(root!=null){
	            List<String>left=binaryTreePaths(root.left);
	            List<String>right=binaryTreePaths(root.right);
	            String current=String.valueOf(root.val);
	            if(left.size()==0&&right.size()==0){
	                list.add(current);
	            }
	            else{
	                if(left.size()!=0){
	                    for(String leftStr:left){
	                        list.add(current+"->"+leftStr);
	                    }
	                }
	                if(right.size()!=0){
	                    for(String rightStr:right){
	                        list.add(current+"->"+rightStr);
	                    }
	                }
	            }
	        }
	        return list;*/
    }
	
	public static void reverse(TreeNode root, List<String> list,String string){
		
		
		
		string +=root.val+" ";
		if(root.left == null && root.right == null){
			list.add(string.trim().replace(" ", "->"));
			return ;
		}
		
		if(root.left !=null)
			reverse(root.left,list,string);
		
		if(root.right !=null)
			reverse(root.right,list,string);
		
		
		
	}
	
	
	public  static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		
		if(s.equals(t)){
			return true;
		}
		
		int []s1 = new int[26];
		int []s2 = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	            s1[s.charAt(i) - 97] ++;
	            s2[t.charAt(i) - 97] ++;
	        }
	    for (int i = 0; i < s1.length; i++){
	        	if (s1[i]!=s2[i])
	                return false;
	        }
	    return true;		
        
    }
	
    public void deleteNode(ListNode node) {
    	
    	
    	node.val = node.next.val;
    	node.next = node.next.next;
    	
    	
    }
    
    public static void haimign(int n , int m){
    	
    	
    	int s = n ^ m;
    	int sum = 0;
    	int s1 = 0;
    	while (s1 < 32) {
			if((s & 1) == 1){
				sum++;
			}
    		
			s>>= 1;
    		s1++;
		}
    	System.out.println("位数不一样的"+ sum);
    	
    	
    	
    }
    
    
	  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		  
		  if(p == q){
			  return p;
		  }
		  
		  
		  //将p节点默认作为左边的节点，q节点放在p的右边
		  TreeNode tem =  null;
		  if(p.val > q.val){
			  tem = q;
			  q = p;
			  p = tem;
		  }
		  
		  System.out.println(p.toString());
		  System.out.println(q.toString());
		  if(p.val < root.val && q.val > root.val ){
			  return root;
		  }
		  while (true) {
			if(p.val < root.val && q.val > root.val){
				break;
			}
			
			else if(p.val < root.val && q.val < root.val){
				root = root.left;
			}else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			}
			
			
			 
		}
		  return root;
		  
	       
	   
	  
	  
	  }
	
	
	public static ListNode res(ListNode head){
		
		if(head == null || head.next == null){
			return head;
			
		}else {
			
			ListNode tem = null;
			ListNode tem1 = null;
			while (head != null) {
				tem = head.next;
				head.next = tem1;
				tem1 = head;
				head = tem;
			}
			return tem1;
		}
		
		
		
	}
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (slow != null && fast != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		while (head != null && slow != null) {
			if(head.val != slow.val){
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
		
		
		
		
		
		//使用的是存入值来进行
		
		/*if(head == null || head.next == null){
			return true;
		}
		else {
			
			List<Integer> list = new ArrayList<>();
			while (head !=null) {
				list.add(head.val);
				head = head.next;
			}
			for (int i = 0; i < list.size() / 2; i++) {
				System.out.println(list.get(i));
				System.out.println(list.get(list.size() - i -1));
				if(!list.get(i).equals(list.get(list.size() - i - 1)) ){
					return false;
				}
			}
			return true;
		}*/
		
        
    }
	

	
	
	
	
	
	
	
	public static TreeNode invertTree(TreeNode root) {
		
		if(root == null){
			return null;
		}
		
		if(root.left == null && root.right == null){
			return root;
		}
		
		TreeNode right = invertTree(root.left);
		TreeNode left = invertTree(root.right);
		
		root.right = right;
		root.left = left;
		
		
		
		
		
		return root;
		
		
        
    }
	 public static boolean isPowerOfTwo(int n) {
		 if(n <= 0)
			 return false;
		 if((n & (n-1)) == 0)
			 return true;
		 return false;
		 
		
	        
	 }
	
	
	
	
	
	
	
	
	
	
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		if(nums.length == 0|| nums.length == 1){
			return false;
		}
		
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])){
				//System.out.println("不包括"+nums[i]);
				map.put(nums[i], i);
			}else {
								if((i - map.get(nums[i])) <= k){
					return true;
				}else {
					map.put(nums[i], i);
				}
			}
			
		}
		return false;
        
    }
	
	
	
	
	
	public static ListNode reverseList(ListNode head) {
		
		if(head == null ||head.next == null){
			return head;
		}else {
			
			
			ListNode next = null;
			ListNode first = null;
			while (head != null) {		
				next = head.next;
				
				head.next = first;
				first = head;
				head = next;
				
				
				
			}
			
			
			return first;
			//在这里进行效率的完善
		/*	Stack<Integer> stack = new Stack<>();
			while (head!=null) {
				stack.add(head.val);
				head = head.next;
			}
			ListNode head1 = new ListNode(-1);
			ListNode head3 = head1;
			
			while (!stack.isEmpty()) {
				ListNode head2 = new ListNode(stack.pop());
				head1.next = head2;
				head1 = head2;
			}			
			return head3.next;*/
			
		}
		
		
		
		
        
    }
	
	
	
	
	
	
    public static ListNode removeElements(ListNode head, int val) {
    	if (head == null)
            return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
  /*  	ListNode list = head;
    	ListNode head1 = head;
    	
    	while (list!=null) {
			if(list.val == val ){
				list = list.next;
			}else {
				break;
			}
		}
    	
    	
    	if(list == null){
    		return null;
    	}
    	ListNode re = new ListNode(list.val);
    	list = list.next;
    	ListNode res = re;
    	while (list !=null) {
    		if(list.val == val){ 
    			list = list.next;
    		
    		}else{
    		
    			ListNode list2 = new ListNode(list.val);
    			re.next = list2;
    			re = re.next;
    		    list = list.next;
    		}
		}
		return res;*/
    }
	 public static boolean isHappy(int n) {
		 /*
		  * 排行比较高的代码
		  * 
		  * if (1 == n | 7 == n)
			return true;
		if (0 == n | 2 == n | 3 == n | 4 == n | 5 == n | 6 == n | 8 == n | 9 == n)
			return false;
		int pow = 0;
		while (n > 0) {
			int tmp;
			tmp = n % 10;
			pow += Math.pow(tmp, 2);
			n /= 10;
		}
		return isHappy(pow);
		 */
		 
		 
		 if(n == 1){
			 return true;
		 }else if (n == 0) {
			return false;
		}else {
			int i = 0;
			int sum = 0;
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			while(true){
				sum = 0;
				while (n != 0) {
					sum += Math.pow(n%10, 2);
					n = n/10;
				}
				if(sum == 1){
					return true;
				}
			
			
				if(hashMap.containsValue(sum) ){
					return false;
				}
				hashMap.put(i++, sum);
				n = sum;
				
			}
			
		}
		 
		 
	        
	    }
	
	public int rob(int[] nums) {
        
		
		int len = nums.length;
		
		if(len == 0){
			return 0;
		}else if (len == 1) {
			return nums[0];
			
		}else if (len == 2) {
			
			return Math.max(nums[0], nums[1]);
			
		}else {
			int max[] = new int[len];
			max[0] = nums[0];
			max[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < max.length; i++) {
				max[i] = Math.max(max[i - 2] + nums[i], max[i -1]);
			}
			return max[len - 1];
			
			
		
		}
		
		
		
		
		
		
		
    }
	public static int hammingWeight(int n) {
		int sum = 0;
		 for (int i = 0; i < 32; i++) { 
	            if ((n & 1) == 1)  
	                sum++;  
	            n >>= 1;
		 		if((n & (0-1)) == 0){
		 			break;
		 		}
		 
	        }  
		return sum;
    }
	
	
	public static int reverseBits(int n) {	
		int res = 0;  

        for (int i = 0; i < 32; i++) { 

            res <<= 1;  

            if ((n & 1) == 1)  
                res++;  

            n >>= 1;  
        }  

        return res; 
    }
	
	public static int[] twoSum(int[] numbers, int target) {
		
		int start = 0;
		int end = numbers.length - 1;
		while ( start != end) {
			if(numbers[start] + numbers[end] > target){
				end--;
			}else if (numbers[start] + numbers[end] < target) {
				start++;
			}else {
				int s[] = new int[2];
				s[0] = start + 1;
				s[1] = end + 1;
				return s;
			}
			
		}		
		return null;
    }
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null){
			return null;
		}else {
			ListNode list1 = headA;
			ListNode list2 = headB;
			int count1 = 0;
			int count2 = 0;
			while (list1 != null) {
				count1++;
				list1 = list1.next;	
			}
			while (list2 != null) {
				count2++;
				list2 = list2.next;
				
			}
			
			int size = count1 > count2? count1 - count2: count2-count1;
			
			
			if(count1 > count2){
				ListNode list3 = headA;
				ListNode list4 = headB;
				while (size > 0) {
					list3 = list3.next;
					size--;
				}
				while (list3!=null) {
					if(list3 == list4){
						return list3;
						
					}else {
						list3 = list3.next;
						list4 = list4.next;
					}
				}
			}else {
				ListNode list3 = headA;
				ListNode list4 = headB;
				while (size > 0) {
					list4 = list4.next;
					size--;
				}
				while (list4!=null) {
					if(list3 == list4){
						return list3;
						
					}else {
						list3 = list3.next;
						list4 = list4.next;
					}
				}
			}
		}
		
        return null;
    }
	
	
	public int singleNumber(int[] nums) {
		
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			result = result ^ nums[i];
		}
		return result;
		
		
    }
	public  static boolean isPalindrome(String s) {
		
		 if(s == null || s.length() == 0 ){
				return true;
			}
			
			
			int start = 0;
			int end = s.length()-1;
			
			char[] t = s.toCharArray();
			
			while (start < end) {
				
			//	System.out.println("开头     ："+start+t[start]);
				//System.out.println("结尾     ："+end+t[end]);
				if((t[start]<='Z'&&t[start]>='A') || (t[start]<='9')&&t[start] >= '0' ||(t[start]<='z'&&t[start]>='a')){	
				//	System.out.println("be");
					System.out.println(t[end]);
					if((t[end]<='Z'&&t[end]>='A') || (t[end]<='9')&&t[end] >= '0'||(t[end]<='z'&&t[end]>='a')){
				//		System.out.println("bijao");
						String s1 = Character.toString(t[start]);
						String s2 = Character.toString(t[end]);
						if(s1.equalsIgnoreCase(s2)){
							start++;
							end--;						
						}else {
							return false;
						}
					}else {
						end--;
					}				
				}else {
					start++;
				}
				System.out.println();
				
			}
			
			return true;
		
		
        
    }
	
		public static List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> target = new ArrayList<>();
	        for(int i = 1; i <= numRows; i++){
	        	List<Integer> mid = new ArrayList<>();
	        	for(int j = 1; j <= i; j++){
	        		if(j == 1 || j == i){
	        			mid.add(1);
	        		}else {
	        		
						mid.add(target.get(i-2).get(j-2)+target.get(i-2).get(j-1));
					}
	        	}
	        	
	        	target.add(mid);	        
	        }
	     
	        return target;
	    }
	
	
	
	//再一次使用递归,给定一值，看是否有路径满足和为其值
		public static  boolean hasPathSum(TreeNode root, int sum) {
				if(root == null){
					return false;
				}else {
					if(root.val == sum &&root.left == null && root.right == null){
						return true;
					}
					return hasPathSum(root.left, sum - root.val)||hasPathSum(root.right, sum - root.val);
				}
			}
	
	
	
	 	public static int minDepth(TreeNode root) {
	 		if(root == null){
	 			return 0;
	 		}else {
				int left = minDepth(root.left);
				int right = minDepth(root.right);
				if(left == 0){
					return right + 1;
				}else if (right == 0) {
					return left + 1;
				}else {
					return left > right ? right +1 :left + 1;
				}
				
			}
	 		
	 		
	 		
	        
	    }
		public boolean isBanlance(TreeNode root){
			if(root == null){
				return true;
			}else {
				int left = getDepth(root.left);
				int right = getDepth(root.right);
				int j = Math.abs((left - right));
				if(j > 1){
					return false;
				}else {
					return isBalanced(root.left) && isBalanced(root.right);
				}
			}
			
			
		}
		public static int getDepth(TreeNode root){
			if(root == null){
				return 0;
			}else {
				int left = getDepth(root.left);
				int right = getDepth(root.right);
				
				int max = Math.max(left, right);
				return max + 1;
			}
		}

	
	
	  /* public boolean isBalanced1(TreeNode root) {
	        if(root==null){
	            return true;
	        }
	        int leftL=getHeight(root.left);
	        int rightL=getHeight(root.right);
	        if(Math.abs(leftL-rightL)<=1){
	            return isBalanced1(root.left)&&isBalanced1(root.right);
	        }
	        return false;
	    }
	    public int getHeight(TreeNode root){
	        if(root==null){
	            return 0;
	        }
	        int leftL=getHeight(root.left);
	        int rightL=getHeight(root.right);
	        return leftL>rightL?leftL+1:rightL+1;
	    }
	*/
	
		public static boolean isBalanced(TreeNode root) {
			if(root == null){
				return true;
			}else {
				Queue<TreeNode> mid = new LinkedList<>();
				
				mid.offer(root);
				while(!mid.isEmpty()){
					root = mid.poll();
					int left = 0;
					int right = 0;
					if(root.left != null){
						left = maxDepth2(root.left);
						mid.offer(root.left);
					}
					if(root.right != null){
						right = maxDepth2(root.right);
						mid.offer(root.right);
					}
					int i = Math.max(left, right);
					int j = Math.min(left, right);
					System.out.println("i的值    "+i);
					System.out.println("j的值    "+j);

					if(i - j> 1){
						return false;
					}
				}
				return true;
			}
    	}
		public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	       List<List<Integer>> target = new ArrayList<>();
	     
	       if(root == null){
	    	   return target;
	       }else {
	    	 //设置最终要保存在每一层的节点的值
			Map hash = new HashMap<Integer,List<Integer>>();
			//设置外层的一个队列
			Queue<TreeNode> qu1 = new LinkedList<TreeNode>();
			//设置内层的一个队列
			Queue<TreeNode> qu2 = new LinkedList<TreeNode>();
			//先把根节点放入到外层队列中
			qu1.offer(root);
			
			//先把根节点放入外循环
			int i = 1;
			List<Integer> mid1 = new ArrayList<>();
			mid1.add(root.val);
			target.add(mid1);
			int j = 1;
			while(true){
				//将外循环的所有左右节点都放入内存队列
				while (!qu1.isEmpty()) {
					//设置一个临时变量存储中间节点
					root = qu1.poll();
					if(root.left !=null){
						qu2.offer(root.left);
					}
					if(root.right !=null){
						qu2.offer(root.right);
					}
				}
				List<Integer> mid = new ArrayList<>();
				while (!qu2.isEmpty()) {
					root = qu2.poll();
					qu1.offer(root);
					 //保存中间的结果的list
					mid.add(root.val);
				}
				if(mid.size()>0){
					target.add(mid);
				}
				if(qu1.isEmpty()){
					break;
				}
				
			  }
			Collections.reverse(target);

			return target;
			
			}
	       
		
		}
	
	//tiemout这个递归很费时，所以用第二个
	
	public static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else {
        	if(maxDepth(root.left) > maxDepth(root.right))
        		return 1 + maxDepth(root.left);
			else {
				return 1 + maxDepth(root.right);
			}
		}
		
    }
	
	
	
	public static int maxDepth2(TreeNode root) {
        if(root == null)
        	return 0;
        else {
        	int left = maxDepth2(root.left);
        	int right = maxDepth2(root.right);
        	return (left > right) ? left+1:right+1;
		}
		
    }
	
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null||(root.left == null&& root.right==null))
			return true;
		else {
			return isSymmetric(root.left, root.right);
		}
		
		
	        
	 }
	public static boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left == null && right ==null)
			return true;
		if(left == null || right == null)
			return false;
		
		return (left.val == right.val)&&isSymmetric(left.left, right.right) && isSymmetric(left.right,right.left);
 		
		
		
        
	 }
	
	@SuppressWarnings("unused")
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p != null && q == null){
			return false;
		}else if (p == null && q != null) {
			return false;
		}else if(p.val != q.val){
			return false;
		}else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
    }
	
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int length = n + m -1;
		m--;
		n--;
		while (m >= 0 && n >=0) {
			if (nums1[m] > nums2[n]) {
				nums1[length] = nums1[m];
				System.out.println(nums1[length]);
				length--;
				m--;
				
			}else {
				nums1[length] = nums2[n];
				System.out.println(nums1[length]);
				length--;
				n--;
			}
		}
		if(m == -1){
			int j = n;
			System.out.println("j  "+ j);
			for(int i = 0; i < n+1; i++){
				nums1[length] = nums2[j--];
				length--;
				//n--;
			}
		}else {
			int j = m;
			for(int i = 0; i < m +1; i++){
				nums1[length] = nums1[j--];
				length--;
			//	m--;
			}
		}
		
		
		
    }
	
	
	
	public static  ListNode deleteDuplicates(ListNode head) {
		
		
		ListNode s4 = head;
		
		if(head == null){
			return null;
		}else {
			ListNode listNode = head.next;
			while (listNode != null) {
				int value = head.val;
				if(value ==  listNode.val){
					listNode = listNode.next;
					head.next = null;
				}else {
					
					
					head.next = listNode;
					head = listNode;
					listNode = listNode.next;
					 
				}
			
			}	
			return s4;
		}
    }
	
	
	
	public static  int climbStairs(int n) {
		if(n == 1 || n == 0)
			return 1;
		else if(n ==2)
			return 2;
		else {
			int i = 1;
			int j = 2;
			int k = 0;
			while (n >= 3) {
				k = i + j;
				int x = j;
				j = k;
				i = x;
				n--;
			}
			return k;
		}
		
    }
	
	
	public static String addBinary(String a, String b) {
		
		int i = Integer.parseInt(a);
		int j = Integer.parseInt(b);
		
		int k = i + j;
		String string = Integer.toBinaryString(k);
		
		
        return string;
    }
	public  static  int[] plusOne(int[] digits) {
		
		int div = 0;
		
		
		for(int j = digits.length-1; j >=0; j--){
			if(digits[j] !=9){
				if(j == digits.length-1){
					digits[j] = digits[j] + 1;
				}
				
				digits[j] = digits[j] + div;
				return digits;
			}else {
				div = 1;
				digits[j] = 0;
			}
		}
		int [] num = new int[digits.length+1];
		num[0] = 1;
		return num;
		
		
		
    }
	
	//[-2,1,-3,4,-1,2,1,-5,4],
	public static int maxSubArray(int[] nums) {
		 int subSums = nums[0];
	       
	        int max = subSums;
	        for (int i=1; i<nums.length; i++) {
	            subSums = subSums > 0 ? subSums + nums[i] : nums[i];
	            if (subSums > max) {
	                max = subSums;
	            }
	        }
	       
	        return max;
	        
	        
	        
	        
		/* 
		 * 有问题的代码。。。。
		 * int maxSum = Integer.MIN_VALUE, thisSum = 0;;
		    for(int i=0; i<nums.length; i++) {
		        thisSum += nums[i];
		        if(thisSum > maxSum)
		            maxSum = thisSum;
		        else if(thisSum < 0)
		            thisSum = 0;
		    }
		    return maxSum;*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int max = Integer.MIN_VALUE;
		int min = 0;
		for(int i = 0; i < nums.length; i++){
			min = 0;
			for(int j = i; j < nums.length; j++){
				min +=nums[j];
				if(max < min){
					max = min;
				}
			}			
		}
		return max;*/
		
		
		
		/*int max = Integer.MIN_VALUE;
		int min = 0;
		
        for(int i = 0; i < nums.length; i++){
        	for(int j = i; j < nums.length; j++){
        		min = 0;
        		for(int k = i; k < j+1; k++){
        			min += nums[k];
  
        		}
        		if(min > max)
        			max = min;
        		
        	}
        }
		return max;*/
    }
	
	public static String countAndSay(int n) {
		
		if(n == 0){
			return "";
			
		}
		
		if(n == 1){
			return "1";
		}
		
		int count = 1;
		StringBuilder s1 = new StringBuilder();
		String s2 = "1";
		for (int i = 1; i < n; i++) {
				char temp = s2.charAt(0);

				for(int j = 1; j < s2.length() ; j++){
					if (s2.charAt(j) == temp) {
						count++;	
					}
					else {
						s1.append(count).append(temp);
						temp = s2.charAt(j);
						count =1;
					}	
				}
				s1.append(count).append(temp);
				count = 1;
				s2 = s1.toString();
				s1.setLength(0);
		}
		return s2;
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*if (n == 0) {
			return "";
		}
		String last = "1";
		StringBuilder result = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			char temp = last.charAt(0);
			int count = 1;
			for (int j = 1; j < last.length(); j++) {
				if (last.charAt(j) == temp) {
					count++;
				} else {
					result.append(count);
					result.append(temp);
					count = 1;
					temp = last.charAt(j);
				}
			}
			result.append(count);
			result.append(temp);
			last = result.toString();
			result.setLength(0);
		}
		return last;
		*/
		
		/*if (n == 1) {
		      return "1";
		    }
		    String str = countAndSay(n - 1);
		    char[] array = str.toCharArray();
		    StringBuilder sb = new StringBuilder();
		    int i = 0;
		    int j = 0;
		    for (j = 0; j < array.length; j++) {
		      if (array[i] != array[j]) {
		        sb.append(j - i).append(array[i]);
		        i = j;
		      }
		    }
		    sb.append(j - i).append(array[i]);
		   
		    
		    return sb.toString();    */
    }
	
	
	 public static int searchInsert(int[] nums, int target) {
		if(target < nums[0])
			return 0;
		if(target > nums[nums.length-1])
			return nums.length;
		 
		 for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target){
				return i;
			}else if( i > 0 ) {
				if(nums[i-1] < target && nums[i] > target){
					return i;
					
				}
			}
		}
		 return nums.length;
		 
		 
		 
	        
	   }
	public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
        	return 0;
        }else {
			return haystack.indexOf(needle);
		}
		
		
    }
	
	
	public static  int removeElement(int[] nums, int val) {
		if(nums == null || nums.length ==0)
			return 0;
		int j = 0;
		int j1 = 0;
		for(int i = 0; i<nums.length; i++){
			if(nums[i] == val){
				j++;
			}else {
				nums[j1++] = nums[i];
			}
		}
		
		return j1;
		
    }
	 public static int removeDuplicates(int[] nums) {
		 int j = 0;
		 for(int i =0 ;i<nums.length; i++){
			 if(nums[i]!=nums[j]){
				 j++;
				 nums[j]=nums[i];
				 
			 }
		 }
		 
		 return j+1;
	    }
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) throws InterruptedException {
		 ListNode first1 = null;
		if(l1 == null && l2 == null){
			return null;
		}
			else if(l1 == null && l2 !=null){
			 return l2;
		 }else if(l2 == null && l1 !=null) {
			 return l1;
		}else {		
		 ListNode first =null;
		 if(l1.val < l2.val){
			 first = new ListNode(l1.val);
			 l1 = l1.next;
		 }else {
			 first = new ListNode(l2.val);
			 l2 = l2.next;
			 
		}
		 first1 = first;
		 boolean flag = false;
		 while (l1 != null || l2 != null) {
			if(l1 != null && l2 !=null){
				if(l1.val == l2.val){
					first.next = new ListNode(l1.val);
					first = first.next;
					
					first.next = new ListNode(l2.val);
					first = first.next;
					
					l1 = l1.next;
					l2 = l2.next;
				}else if(l1.val < l2.val) {
					first.next = new ListNode(l1.val);
					first = first.next;
					l1 = l1.next;
				}else {
					first.next = new ListNode(l2.val);
					first = first.next;
					l2 = l2.next;	
				}
			}else if (l1 == null && l2 != null) {
				first.next = l2;
				flag = true;
				break;
			}else {
				first.next = l1;
				flag = true;
				break;
			}
			
			if(flag){
				break;
			} 
		}
	//	 first.next = null;
		return first1;	
		}	 
 }
	/*
	
	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	
	有效字符串需满足：
	
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
	
	示例 1:
	
	输入: "()"
	输出: true
	示例 2:
	
	输入: "()[]{}"
	输出: true
	示例 3:
	
	输入: "(]"
	输出: false
	示例 4:
	
	输入: "([)]"
	输出: false
	示例 5:
	
	输入: "{[]}"
	输出: true
	
	
	*/
	 public boolean isValid(String s) {
			/*Given a string containing just the characters '(', ')', '{', '}',
			'[' and ']', determine if the input string is valid.*/
			Stack<String> tem = new Stack<>();
			char stem[] = s.toCharArray();
			for (char c : stem) {
				if(c == '}' || c == ']' || c == ')'){
					if(tem.isEmpty()){
						return false;
					}else {
						if(c == '}'){
							if(!gets(tem, '{')){
								return false;
							}
						}else if (c == ']') {
							if(!gets(tem, '[')){
								return false;
							}
						}else {
							if(!gets(tem, '(')){
								return false;
							}
						}
					}
				}else {
					tem.push(c + "");
				}
			}
			if(tem.isEmpty()){
				return true;
			}
			return false;
			
	    }
		public boolean gets(Stack<String> tem,char s){
			if(tem.peek().equals(s+"")){
				tem.pop();
				return true;
			}else {
				return false;
			}
		}
		
	
	
	
	/*
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
		
		如果不存在公共前缀，返回空字符串 ""。
		
		示例 1:
		
		输入: ["flower","flow","flight"]
		输出: "fl"
		示例 2:
		
		输入: ["dog","racecar","car"]
		输出: ""
		解释: 输入不存在公共前缀。
		说明:
		
		所有输入只包含小写字母 a-z 。
	
	*/ 	
	 public static String longestCommonPrefix(String[] strs) {
		try {
			 int min = strs[0].length();
			 
			 if(strs.length == 1){
				 return strs[0];
			 }
			 for(int i = 1; i<strs.length; i++){
			 		if(min > strs[i].length())
			 				min = strs[i].length();
			 }
			 if(min == 0){
				 return "";
			 }
			 boolean flag = false;
			 int i;
			 for( i = 0; i<min; i++){
				 String string = Character.toString(strs[0].charAt(i));
				 for(int j = 1; j < strs.length; j++){
					 if(string.equals(Character.toString(strs[j].charAt(i)))){
						 continue;
					 }
					 else {
						flag = true;
					}
						 
				 }
				 if(flag){
					 break;
				 }
			 }
			
			 return strs[0].substring(0,i);
		} catch (Exception e) {
				
			return "";
		}
		 
		 
		 
		 
	    }
	public  static int romanToInt(String s) {
	 		int x = 0;
	 		HashMap<String, Integer> hashMap = new HashMap<>();
			hashMap.put("I", 1);
			hashMap.put("V", 5);
			hashMap.put("X", 10);
			hashMap.put("L", 50);
			hashMap.put("C", 100);
			hashMap.put("D", 500);
			hashMap.put("M", 1000);
			//System.out.println(s.charAt(0));
			//System.out.println(s.charAt(0));
			/*I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
			X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
			C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
*/			for(int i = 0; i<s.length();i++){
	
				String string = Character.toString(s.charAt(i));
				if( i== s.length()-1){
					x = x +hashMap.get(string);
					return x;
				}else if ((Character.toString(s.charAt(i)).equals("I")&&Character.toString(s.charAt(i+1)).equals("V"))||
						(Character.toString(s.charAt(i)).equals("I")&&Character.toString(s.charAt(i+1)).equals("X"))) {
					x = x + hashMap.get(Character.toString(s.charAt(i+1)))-1;
					i++;
				}else if((Character.toString(s.charAt(i)).equals("X")&&Character.toString(s.charAt(i+1)).equals("L"))||
						(Character.toString(s.charAt(i)).equals("X")&&Character.toString(s.charAt(i+1)).equals("C"))) {
					x = x + hashMap.get(Character.toString(s.charAt(i+1))) -10;
					i++;
				}else if ((Character.toString(s.charAt(i)).equals("C")&&Character.toString(s.charAt(i+1)).equals("D"))||
						(Character.toString(s.charAt(i)).equals("C")&&Character.toString(s.charAt(i+1)).equals("M"))) {
					x = x + hashMap.get(Character.toString(s.charAt(i+1))) -100;
					i++;
				}
				else {
					x = x +hashMap.get(string);
				}
			}
			return x;
	 		
	        
	    }
	  public static int reverse(int x) {
	    	  if(x==0)
	              return 0;
	          if(x>Integer.MAX_VALUE)
	              return 0;
	          boolean flag = true;
	          if(x<0){
	              x=0-x;
	              flag = false;
	          }
	          char[] cx=String.valueOf(x).toCharArray();
	          String res="";
	          for(int i=cx.length-1; i>=0;i--){
	              if(cx[i]=='0' && res.length()==0){
	                  continue;
	              }
	              res = res+String.valueOf(cx[i]);
	          }
	          if(!flag){
	              res = "-"+res;
	          }
	          int ret = 0;
	          try{
	              ret = Integer.valueOf(res);
	          }catch(Exception e){
	              return 0;
	          }
	          return ret;
	}

}
