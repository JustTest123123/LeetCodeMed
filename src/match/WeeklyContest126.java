
package match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import easy.TreeNode;

public class WeeklyContest126 {
	public static void main(String[] args) {

		System.out.println("fdd");
	}
	public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
		int [][] tem = new int [A.length][26];
		if(A.length == 0){
			return result;
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length(); j++) {
				tem[i][A[i].charAt(j) - 97] ++;
			}
		}
		for (int i = 0; i < 26; i++) {
			int min = tem[0][i];
			for (int j = 0; j < A.length; j++) {
				if(min > tem[j][i]){
					min = tem[j][i];
				}
			}
			if(min != 0){
				for (int j = 0; j < min; j++) {
					result.add((char)(97 + i) + "");
				}
			}
		}
		
		return result;
    }
	
	
	
	 public boolean isValid(String S) {
	       if(S.length() % 3 != 0){
				return false;
			}else {
				for (int i = 0; i < S.length() - 2; i++) {
					if(S.charAt(i) == 'a' && S.charAt(i + 1) == 'b' && S.charAt(i + 2) == 'c'){
						String tem1 = S.substring(0, i);
						String tem2 = S.substring(i + 3);
						S = tem1 + tem2;
						i = -1;
					}
				}
				if(S.length() == 0){
					return true;
				}else {
					return false;
				}
			}
			
			
	    }
	 
	 
		
	
}