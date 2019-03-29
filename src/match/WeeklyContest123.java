package match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeeklyContest123 {
	public static void main(String[] args) {
		System.out.println("fdd");
	}
	public List<Integer> addToArrayForm(int[] A, int K) {
	    int jinwei = 0;
        List<Integer> result = new ArrayList<>();
        int index = A.length - 1;
   
        while (index >=0 || K != 0) {
        	if(index >= 0){
        		int tem = K % 10;
                K = K/10;
            	result.add(((tem+A[index] + jinwei)% 10));
            	jinwei  =(tem+A[index] + jinwei) / 10;
                index --;
        	}else {
        		int tem = K % 10;
                K = K/10;
            	result.add(((tem + jinwei)% 10));
            	jinwei  =(tem + jinwei) / 10;
                
			}
			
		}
        if(jinwei == 1){
        	result.add(jinwei);
        }
        Collections.reverse(result);
        return result;
        
    }
	
	Map<Character, Character> tem = new HashMap<>();
	public boolean equationsPossible(String[] equations) {
		/*//错误的算法思路
		 * Map<String, String> eq = new HashMap<>();
		Map<String, String> neq = new HashMap<>();
		for (String string : equations) {
			//如果是相等的话
			if(string.contains("==")){
				String start = string.substring(0, string.indexOf("="));
				String last = string.substring(string.lastIndexOf("=") + 1);
				if(neq.containsKey(start)){
					if(neq.get(start).contains(last)){
						return false;
					}else {
						eq.put(start, eq.getOrDefault(start,new String()) + last);
						eq.put(last, eq.getOrDefault(last,new String())+ start);
					}
				}else {
					eq.put(start, eq.getOrDefault(start,new String()) + last);
					eq.put(last, eq.getOrDefault(last,new String())+ start);
				}
			}else {
				//不等于的情况
				
				String start = string.substring(0, string.indexOf("!"));
				String last = string.substring(string.lastIndexOf("=") + 1);
				if(start.equals(last)){
					return false;
				}
				if(eq.containsKey(start)){
					if(eq.get(start).contains(last)){
						return false;
					}else {
						neq.put(start, neq.getOrDefault(start, new String()) + last + eq.getOrDefault(last, ""));
						neq.put(last, neq.getOrDefault(last, new String())+ start  + eq.getOrDefault(start, ""));
					}
				}else {
					neq.put(start, neq.getOrDefault(start, new String()) + last + eq.getOrDefault(last, ""));
					neq.put(last, neq.getOrDefault(last, new String())+ start + eq.getOrDefault(start, ""));
				}
				
			}
			
		}
        System.out.println(neq.toString());
        System.out.println(eq.toString());
		return true;*/
		
		
		for (String string : equations) {
			char s1 = string.charAt(0);
			char s2 = string.charAt(3);
			if(!tem.containsKey(s1)){
				tem.put(s1, s1);
			}
			if(!tem.containsKey(s2)){
				tem.put(s2, s2);
			}
			//先处理所有的等于的情况
			if(string.contains("==")){
				//合并两个字母至根节点
				union(s1, s2);
			}
		}
		for (String string : equations) {
			char s1 = string.charAt(0);
			char s2 = string.charAt(3);
			if(string.contains("!=")){
				if(find(s1) == find(s2)){
					return false;
				}
			}
		}
		
		return true;
    }
	public void union(char s1,char s2){
		tem.put(find(s1),find(s2));
	}
	public char find(char u){
		if(tem.get(u) != u){
			return find(tem.get(u));
		}else {
			return u;
		}
		
	}
	int zui = Integer.MAX_VALUE;
	public int brokenCalc(int X, int Y) {
		//逆向思维
		//y到x就是除以2和加1
		int result = 0;
		if(X == Y){
			return 0;
		}
		while (X != Y) {
			if(X < Y){
				if(Y % 2 == 0){
					Y = Y/2;
					result ++;
				}else {
					Y++;
					result ++;
				}
			}else {
				result += (X - Y);
				X = Y;
			}
			
		}
		
		return result;
	/*	get(0, X, Y);
		return zui;*/
	}
	public void get(int result,int X,int Y){
		if(X == Y){
			zui = Math.min(result,zui);
			return ;
		}else {
			if(X > Y){
				get(result + 1, X - 1,Y);
			}else {
				if(X != 0){
					get(result + 1, X - 1, Y);
					get(result + 1, X * 2, Y);
				}else {
					get(result + 1, X * 2, Y);
					get(result + 1, X - 1, Y);
				}
				
			}
		}
	}
}