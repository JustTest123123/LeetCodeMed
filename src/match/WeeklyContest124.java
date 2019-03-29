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

public class WeeklyContest124 {
	public static void main(String[] args) {

		System.out.println("fdd");
	}
	
	
	
	public int minKBitFlips(int[] A, int K) {
		int re = 0;
        for (int i = 0; i < A.length; i++) {
			if(A[i] == 0){
				re ++;
				if(i + K <= A.length){
					for (int j = i; j <= i + K; j++) {
						A[j] = A[j] == 0 ? 1:0;
					}
				}else {
					break;
				}
			}
		}
        System.out.println(Arrays.toString(A));
		for (int i : A) {
			if(i == 0){
				return -1;
			}
		}
		return re;
    }
	public boolean isCousins(TreeNode root, int x, int y) {
        int depx =  dep(root, x);
        int depy = dep(root, y);
        System.out.println(depx);
        System.out.println(depy);
        if(depx != depy){
        	return false;
        }
        if(getparent(0, root, x) == getparent(0, root, y)){
        	return false;
        }
        
        return true;
    }
	
	public int  dep(TreeNode root,int result){
		Queue<TreeNode> tem = new LinkedList<>();
		tem.offer(root);
		int reus = 0;
		while (!tem.isEmpty()) {
			int size = tem.size();
			reus ++;
			for (int i = 0; i < size; i++) {
				TreeNode temNode = tem.poll();
				if(temNode.val == result){
					return reus;
				}
				if(temNode.left != null){
					tem.offer(temNode.left);
				}
				if(temNode.right != null){
					tem.offer(temNode.right);
				}
			}
		}
		return reus;
		
	}
	public int getparent(int parent,TreeNode root,int value){
		if(root == null){
			return -999;
		}
		if(root.left != null){
			if(root.left.val == value){
				parent =  root.val;
				return root.val;
			}
		}
		if(root.right != null){
			if(root.right.val == value){
				parent = root.val;
				return root.val;
			}
		}
		parent = getparent(parent, root.left, value);
		if(parent == -999){
			parent = getparent(parent, root.right, value);
		}
		
		return parent;
		
	}
}