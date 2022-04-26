package 일반알고리즘;

import java.util.*;
public class 바이러스백준 {
	static int computer, iter;
	static boolean check[];
	static int map[][];
	static List<Integer> answer = new LinkedList<>();
	public static int dfs(int start) {
		check[start] = true;
		answer.add(start);
		
		if(start == map.length) {
			return answer.size() - 1; // 1번 컴퓨터 제외하
		}
		
		for(int j=1; j<map.length; j++) {
			if(map[start][j] == 1 && check[j] == false) {
				dfs(j);
			}
			
		}
		return answer.size() -1;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();
		iter = sc.nextInt();
		map = new int[computer + 1][computer + 1];
		check = new boolean[computer + 1];
		//map 어레이 행렬 만들
		for(int i=0; i<iter; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		int res = dfs(1);
		System.out.println(res);
	}

}
