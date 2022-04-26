package 일반알고리즘;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최단거리_백준{
	static int n;
	static int map[][];
	static int answer[][];
	static boolean[] visited;
	static int count[];
	
	public static void BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>(); // start 부분을 넣기 
		queue.add(start);
		count = new int[n];
		
		loop : while(!queue.isEmpty()) {
			int q = queue.poll();// start
			// 만약 끝 부분이면 answer에 체
			if(q == end) {
				if(count[q] > 0) {
					answer[start][end] = 1;
					break loop;
					
				}
			}
			for(int i=0; i<n; i++) {
				if(map[q][i] == 1  && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					count[i] = count[q] + 1;
					
				}
			}
			
		}
		
	}
	
	public static void solution(int n, int map[][]) {
		visited = new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i]) {
					BFS(i,j);
					Arrays.fill(visited,  false);
				}
			}
		}
	}
	public static void main(String[] args) {
		최단거리_백준 T = new 최단거리_백준();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		answer = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int k = sc.nextInt();
				map[i][j] = k;
				answer[i][j] = k;
			}
		}
		T.solution(n, map);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}