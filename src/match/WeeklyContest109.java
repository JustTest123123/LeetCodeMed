package match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WeeklyContest109 {

	
	public int knightDialer(int N) {
		if(N == 1){
			return 10;
		}
		//首先初始化跳的棋子，用一个二维数组来表示，横坐标表示的是起跳的位置，其对应的是跳的位置，比如：
		//1跳的位置是6和8，5没有落子位置，2对应的是7和9
		int [][]nums = {
				{4,6},
				{6,8},
				{7,9},
				{4,8},
				{3,9,0},
				{},
				{1,7,0},
				{2,6},
				{1,3},
				{2,4}
		};
		//dp数组定义的意义是初始化一下，初始值表示的是N=1 表示跳0步，从0-9都是1，即初始为1
		int x = 1000000000 + 7;
		int dp[] = {1,1,1,1,1,1,1,1,1,1};
		//循环次数为N-1
		while (N-- > 0) {
			int []tem = new int[10];
			for (int i = 0; i < 10; i++) {
				//从起跳点是0开始进行，比如：0跳一次可以跳到4和6，那么tem数组的4和6下标就加上1
				for (int j = 0; j < nums[i].length; j++) {
					//注意的是tem数组的下标表示循环到当前次数时跳到当前位置的总的个数
					tem[nums[i][j]] = (tem[nums[i][j]] % x + dp[i] % x);
				}
			}
			//更新dp数组
			dp = tem.clone();
			System.out.println(Arrays.toString(dp));
		}
		int sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum = (sum + dp[i] % x) % x;
		}
		return sum;
        
    }
	
	//最短的桥
	public int shortestBridge(int[][] A) {
        int result = 0;
        Queue<int[]> tem = new LinkedList<int[]>();
        
        //首先要找到第一个岛屿，为了之后区别第一个和第二个，这里找到后直接将其变成2，用于区分
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if(!found && A[i][j] == 1){
					dfs(A, i, j);
					found = true;
				}
				if(found && A[i][j] == 1){
					//将其对应的下标放入队列中进行遍历
					int temq[] = new int[2];
					temq[0] = i;
					temq[1] = j;
					tem.offer(temq);
				}
			}
		}
        
        
        //为了方便起见。这里定义一个方向数组，便于操作
        //依次为上下左右
        int direc[][] = {
        		{0,1},
        		{0,-1},
        		{-1,0},
        		{1,0}
        	
        };
        //接下来对于第二个岛屿进行广度遍历bfs，即从队列中取出坐标，进行上下左右进行填充，直到遇到一个是2（这里就体现出一开始把第一座岛屿设置成2
        //的好处了）
        while (!tem.isEmpty()) {
			int size = tem.size();
			for (int i = 0; i < size; i++) {
				int temshu[] = tem.poll();
				//从四个方向进行填充（建设桥）
				for (int[] is : direc) {
					//x坐标
					int x = temshu[0] + is[0];
					//y坐标
					int y = temshu[1] + is[1];
					if(x < 0 || x >= A[0].length || y >= A.length || y < 0 || A[x][y] == 1 )
						continue;
					if(A[x][y] == 2){
						return result;
					}
					if(A[x][y] == 0){
						A[x][y] = 1;
						
						//将其对应的下标放入队列中进行遍历
						int temq[] = new int[2];
						temq[0] = x;
						temq[1] = y;
						tem.offer(temq);
					
					}
				}
			}
			result ++;
		}
        
        return 1;
    }
	public void dfs(int [][]A ,int x ,int y){
		if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 0 || A[x][y] == 2 )
			return;
		A[x][y] = 2;
		dfs(A, x - 1, y);	
		dfs(A, x + 1, y);	
		dfs(A, x, y - 1);	
		dfs(A, x, y + 1);
	}

}
