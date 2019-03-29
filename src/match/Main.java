package match;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;
import javax.xml.ws.RespectBinding;

public class Main {
//	public static void main(String[] args) {
//		Scanner cin = new Scanner (new BufferedInputStream(System.in));
//		String j = cin.nextLine();
//		int i = cin.nextInt();
//		System.out.println(i);
//		System.out.println(j);
//	}
	 public static void main(String[] args) {
	
	
		 int i = 87;
		 int index = 1;
		 while (i >= 2) {
			//System.out.println(index ++);
			System.out.print(i);
            i++;
			System.out.print("-" + i + "、");
			i-=5;
		}
		// 1-2、5-6、9-10、13-14、17-18、21-22、25-26、29-30、33-34、37-38、41-42、45-46、49-50、53-54、57-58、61-62、65-66、69-70、73-74、77-78、81-82、85-86、89-90、93-94、97-98
	 }
	 public static void getss(int sort[],int []res){
		 int result = 0;
		 //一开始的奖品是1
		 int mel = 1;
		 Map<Integer, Integer> temMap = new HashMap<Integer, Integer>();
		 for (int i = 0; i < sort.length; i++) {
				 for (int j = 1; j < res.length - 1; j++) {
					 if(res[j] != sort[i]){
						continue;
					 }
					 
						if(res[j] == sort[i]){
							if(res[j] > res[j-1] && res[j] > res[j+1]){
								mel = Math.max(temMap.get(res[j - 1]), temMap.get(res[j+1]));
								mel ++;
								result += mel;
								temMap.put(res[j], mel);
								continue;
							}
							else if(res[j] > res[j+1]){
								mel = temMap.get(res[j+1]);
								mel ++;
								result += mel ;
								temMap.put(res[j], mel);
								continue;
							}else if(res[j] > res[j-1]){
								mel = temMap.get(res[j-1]);
								mel ++;
								result += mel ;
								temMap.put(res[j], mel);
								continue;
							}else {
								result += 1;
								temMap.put(res[j], 1);
							}
						}
					}
		
				//对于两边另作处理
				 if(res[0] == sort[i]){
					 if(res[0] > res[1] && res[0] > res[res.length - 1]){
							mel = Math.max(temMap.get(res[1]), temMap.get(res[res.length - 1]));
							mel ++;
							result += mel;
							temMap.put(res[0], mel);
							
						}
						else if(res[0] > res[1]){
							mel = temMap.get(res[1]);
							mel ++;
							result += mel ;
							temMap.put(res[0], mel);
							
						}else if(res[0] > res[res.length - 1]){
							mel = temMap.get(res[res.length - 1]);
							mel ++;
							result += mel ;
							temMap.put(res[0], mel);
						}else {
							result += 1;
							temMap.put(res[0], 1);
						}
				 }
				 if(res[res.length - 1] == sort[i]){
					 if(res[res.length - 1] > res[0] && res[res.length - 1] > res[res.length - 2]){
							mel = Math.max(temMap.get(res[0]), temMap.get(res[res.length - 2]));
							mel ++;
							result += mel;
							temMap.put(res[res.length - 1], mel);
							
						}
						else if(res[res.length - 1] > res[0]){
							mel = temMap.get(res[0]);
							mel ++;
							result += mel ;
							temMap.put(res[res.length - 1], mel);
							
						}else if(res[res.length - 1] > res[res.length - 2]){
							mel = temMap.get(res[res.length - 2]);
							mel ++;
							result += mel ;
							temMap.put(res[res.length - 1], mel);
						}else {
							result += 1;
							temMap.put(res[res.length - 1], 1);
						}	
					}
		}
		 System.out.println(temMap.toString());
		 System.out.println(result);
	 }
	 public static void gets(String tem[]){
		 String result[] = new String[tem.length];
		 int index = 0;
		 for (String string : tem) {
			//先把三个在一起的给去
			 List<Character> resulttem = new ArrayList<Character>();
			 char [] tems = string.toCharArray();
			 for (int i = 0; i < tems.length; i++) {
				if(i == 0 || i == 1){
					resulttem.add(tems[i]);
				}else {
					int size = resulttem.size();
					if(tems[i] == resulttem.get(size - 1) && tems[i] == resulttem.get(size - 2)){
						continue;
					}
					if(size >= 3){
						if(tems[i] == resulttem.get(size - 1) && resulttem.get(size - 2) == resulttem.get(size - 3)){
							continue;
						}
					}
					resulttem.add(tems[i]);
				}
			}
			int size = resulttem.size();
		//	System.out.println(resulttem.toString());
			char get[] = new char[size];
			for (int i = size - 1; i >= 0; i--) {
				get[i] = resulttem.get(i);
			}
			result[index ++] = new String(get);
			
		}
		for (int i = result.length - 1; i >= 0 ; i--) {
			System.out.println(result[i]);
		}
	 }
	 public  static int get(int N){
		 if(N == 1024 ){
			 return 0;
		 }
		 int result = 0;
		 int money = 1024 - N;
		 System.out.println(money);
		 //64
		 while (money / 64 != 0) {
			 result += money / 64;
			 money %= 64;
		}
		 //16
		 System.out.println(money);
		 
		 while (money / 16 != 0) {
			 result += money / 16;
			 money %= 16;
		}
		 //4
		 while (money / 4 != 0) {
			 result += money / 4;
			 money %= 4;
		}
		 result += money % 1;
		 //1
		 return result;
	 }
}
