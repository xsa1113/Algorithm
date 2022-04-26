package 자료구조;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트리의부모찾기 {
	// 인접리스트를 만들어서 돌리
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int N =sc.nextInt();
		int parent [] = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<Integer>()); 
		}
		
		for(int i=0; i<N; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			list.get(to).add(from);
			list.get(from).add(to);
		}
		int start = 1;
		bfs(start,list, parent, N);
		
	}

	static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parent, int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		parent[start] = 1;
		
		while(!queue.isEmpty()) {
			int parents = queue.poll();
			
			
			
		}
		
	}
	
}

