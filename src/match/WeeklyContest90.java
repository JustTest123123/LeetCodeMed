package match;

import java.util.Stack;

public class WeeklyContest90 {

	public static void main(String[] args) {
		System.out.println(mirrorReflection(5, 1));
	}
	
	public static int mirrorReflection(int p, int q) {
		//根据画图我们知道每次走的距离是固定的，只不过第一次走的是q，第二次走的是 2 * q，画图可以很明显看出来
		if(2 * q == p){
			return 2;
		}
		if(p == q)
			return 1;
		int time1 = 1;
		int time2 = 1;
		int time0 = 1;
		//判断落在2上最小距离
		while ( (time2 * 2 * q + p ) % (2 * p) != 0) {
			time2 ++;
			if(time2 >= 10000){
				break;
			}
		}
		int tem2 = time2 * 2 * q;
		System.out.println("2的距离为：   "+  tem2);
		while ((time1 * 2 * q + q + p) % (  2 * p) != 0 ){
			time1++;
			if(time1 >= 10000){
				break;
			}
			if(time1 > time2){
				break;
			}
		}
		int tem1 = time1 * 2 * q + q;
		System.out.println("1的距离为：   "+  tem1);

		//只有这种情况是最好弄的，其余都需要转
		while ((time0 * 2 * q + q) % ( 2 * p ) != 0) {
			time0 ++;
			if(time0 > time1 || time0 > time2){
				break;
			}
			if(time0 >= 10000){
				break;
			}
		}
		int tem0 = time0 * 2 * q + q;
		System.out.println("0的距离为：   "+  tem0);

		if(tem0 < tem1 && tem0 < tem2){
			return 0;
		}else if (tem1 < tem0 && tem1 < tem2) {
			return 1;
		}else {
			return 2;
		}
        
    }
	
	public static int scoreOfParentheses(String S) {
		if(S.length() == 0)
			return 0;
		//为了方便起见，左括号用0表示，右括号表示成-1
		Stack<Integer> tem = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			//如果是左括号直接入栈
			if(S.charAt(i) == '('){
				tem.push(0);
			}else {
				//是右括号，需要注意,判断栈顶是不是数字
				
				//如果栈顶是左括号
				if(tem.peek() == 0){
					tem.pop();
					int tems = 1;
					//如果栈顶是数字，要继续累加,但是我每次
					if ( !tem.isEmpty() && tem.peek() != 0) {
						
						tems += tem.pop();
						
					}
					tem.push(tems);
					
				}else {
					//如果栈顶是数字，那么需要弹出
					int tems = tem.pop();
					tems *= 2;
					tem.pop();
					//如果栈顶是数字，要继续累加
					if ( !tem.isEmpty() && tem.peek() != 0) {
						tems += tem.pop();
						
					}
					tem.push(tems);
				}
			}
		}
		
        return tem.peek();
    }
	
	public static  boolean buddyStrings(String A, String B) {
		if(A.length() != B.length()){
			return false;
		}
		int tems[] = new int[26];
		int math = 0;
		int s = 0;
        for (int i = 0; i < A.length(); i++) {
        	tems[A.charAt(i) - 97]++;
			if(A.charAt(i) != B.charAt(i)){
				if(math == 1){
					char tem[] = A.toCharArray();
					tem[s] = B.charAt(s);
					tem[i] = B.charAt(i);
					if(new String(tem).equals(B)){
						return true;
					}else {
						return false;
					}
				}else {
					//记录下位置
					s = i;
					math ++;
				}
			}
		}
        for (int i = 0; i < tems.length; i++) {
			if(tems[i] >= 2){
				return true;
			}
		}
        return false;
    }
}
