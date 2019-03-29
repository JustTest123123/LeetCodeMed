package hhh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hhh.Node;

public class Test {
	public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        gets(root, result);
        return result;
    }
	public void gets(Node root,List<Integer> result){
		if(root == null){
			return ;
		}
		List<Node> get = root.children;
		for (Node node : get) {
			gets(node, result);
		}
		result.add(root.val);
	}
	public void get(int n){
		Scanner sc = new Scanner(System.in);
		int tem [][] = new int[n][2];
		for (int i = 0; i < tem.length; i++) {
			for (int j = 0; j < 2; j++) {
				tem[i][0] = sc.nextInt();
				tem[i][1] = sc.nextInt();
			}
		}	
		//遍历所有数组
		List<int[]> tems = new ArrayList<int[]>();
		for (int i = 0; i < tem.length; i++) {
			boolean flag = true;
			for (int j = i + 1; j < tem.length; j++) {
				if(tem[i][0] <= tem[j][0] && tem[i][1] <= tem[j][1] ){
					flag = false;
					break;
				}
			}
			if(flag){
				int [] tes = new int[2];
				tes[0] = tem[i][0];
				tes[1] = tem[i][1];
				tems.add(tes);
			}
		}
		System.out.println(tems);
		
	}
	
}
