package match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

import easy.TreeNode;

public class WeeklyContest122 {
	
	public static void main(String[] args) {
		

		System.out.println((char)97);
	}
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		
		
        Map<Integer, List<mysorted>> tem = new TreeMap<>();
        get(root,0,0,tem);
        for (List<mysorted> list : tem.values()) {
			Collections.sort(list);
			List<Integer> x = new ArrayList<>();
			for (mysorted mysorted : list) {
				x.add(mysorted.val);
			}
			result.add(x);
			
		}
        
        System.out.println(tem.toString());
        return result;
        
        
    }
	public void get(TreeNode tree,int x,int y,Map<Integer,List<mysorted>> result){
		List<mysorted> tem = new ArrayList<>();
		if(result.get(x)!= null){
			tem = result.get(x);
		}
		tem.add(new mysorted(x, y, tree.val));
		result.put(x,tem);
		
	
		if(tree.left != null){
			get(tree.left, x - 1,y - 1,result);
		}
		if(tree.right != null){
			get(tree.right, x + 1,y - 1,result);
		}
	}
	
	public String smallestFromLeaf(TreeNode root) {
		List<String> result = new ArrayList<>();
		temget(root, result, "");
		System.out.println(result.toString());
		String [] arr = result.toArray(new String[result.size()]);
		Arrays.sort(arr);
		return arr[0];
    }
	public void temget(TreeNode root,List<String> tem,String sb){
		if(root.left == null && root.right == null){
			StringBuilder temsb = new StringBuilder(sb + ((char)(97 + root.val)));
			tem.add(new String(temsb.reverse()));
		}
		
		if(root.left != null){
			temget(root.left, tem,sb + ((char)(97 + root.val)));
		}
		if(root.right != null){
			temget(root.right, tem,sb + ((char)(97 + root.val)));
		}
		
	}
	
	
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
			A[queries[i][1]] += queries[i][0];
			int tem = 0;
			for (int j = 0; j < A.length; j++) {
				if((A[j] & 1) == 0){
					tem += A[j];
				}
				
			}
			result[i] = tem;
		}
        return result;
    }
	/*	输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
	输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
	注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。*/

/*//考虑这么来
List<Integer> Aint = new ArrayList<>();
List<Integer> Bint = new ArrayList<>();
for (int i = 0; i < A.length; i++) {
for (int j = A[i].start; j <= A[i].end; j++) {
	Aint.add(j);
}
}
for (int i = 0; i < B.length; i++) {
for (int j = B[i].start; j <= B[i].end; j++) {
	Bint.add(j);
}
}
int max = Aint.get(Aint.size() - 1) > Bint.get(Bint.size() - 1) ?  Aint.get(Aint.size() - 1) : Bint.get(Bint.size() - 1);
int[] tem = new int[max + 1];
System.out.println(Aint.toString());
System.out.println(Bint.toString());
for (int i = 0; i < Aint.size(); i++) {
tem[Aint.get(i)]++;
}
for (int i = 0; i < Bint.size(); i++) {
tem[Bint.get(i)]++;
}
Interval tems[] = null ;
Map<Integer, Integer> temMap = new HashMap<Integer, Integer>();
int start = 0;
System.out.println(Arrays.toString(tem));
for (int i = 0; i < tem.length; i++) {
if(tem[i] == 2){
	temMap.put(start, i);
	continue;
}else {
	start = i + 1;
	
}
}
System.out.println(temMap.toString());


return tems;*/
	public static  Interval[] intervalIntersection(Interval[] A, Interval[] B) {
		 Map<Integer, Integer> temMap = new TreeMap<Integer, Integer>();
		int aindex = 0;
		int bindex = 0;
		for ( ;bindex < B.length && aindex < A.length; ) {
			int start = A[aindex].start > B[bindex].start ?A[aindex].start : B[bindex].start;	
			int end = A[aindex].end < B[bindex].end ? A[aindex].end : B[bindex].end;
			if(start <= end){
				temMap.put(start, end);
				if(A[aindex].end > B[bindex].end){
					bindex ++;
				}else {
					aindex ++;
				}
			}else {
				if(A[aindex].start >= B[bindex].end){
					bindex++;
				}else {
					aindex ++;
				}
			}
		}
		System.out.println(temMap.toString());
		Interval [] result = new Interval[temMap.size()];
		int x = 0;
		for (Map.Entry<Integer, Integer> tem : temMap.entrySet()) {
			System.out.println(tem.getKey());
			System.out.println(tem.getValue());
			Interval temint = new Interval(tem.getKey(), tem.getValue());
			
			result[x++] = temint;
		}
		return result;
		
    }
	/**
	 * @author xwb
	 *
	 */
	
}

class test implements Comparable<test>{
	int y;
	int val;
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public test(int y, int val) {
		super();
		this.y = y;
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "test [y=" + y + ", val=" + val + "]";
	}
	
	@Override
	public int compareTo(test o) {
		// TODO 自动生成的方法存根
		if(y == o.y){
			return o.val - val;
		}
		return y - o.y ;
	}
}

class mysorted implements Comparable<mysorted>{
	int x;
	int y;
	int val;
	
	public mysorted(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}


	@Override
	public int compareTo(mysorted o) {
		if(o.x == x){
			if(o.y == y){
				//val进行排序，从小到达进行排序
				return val - o.val;
			}else {
				//y是按照从大到小排列
				return  o.y - y;
			}
		}else {
			//x按照从小到达进行排序
			return x -  o.x;
		}
	}
}