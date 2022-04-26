package 일반알고리즘;

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리_SW {
	//1 집 2 피자
	static int n, m, pilen,answer; 
	static ArrayList<Node> ho;
	static ArrayList<Node> pi;
	static int[] combi;
	//
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void DFS(int L, int S) {
		if(L == m) {
			int sum = 0;
			// 이제 집거리 계산 
			for(Node node : ho) {
				//최소 
				int dis = Integer.MAX_VALUE;
				for(int i : combi) {
					dis = Math.min(dis,  Math.abs(node.x - pi.get(i).x) + Math.abs(node.y - pi.get(i).y));
					
				}
				sum += dis;
			}
			answer = Math.min(answer, sum);
		}else {
			// 피자 배열 에서 m 개 뽑기 
			for(int i=S; i<pilen; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
			
		}
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		// 집을 담고
		ho = new ArrayList<>();
		pi = new ArrayList<>();
		combi = new int[m];
		answer = Integer.MAX_VALUE;
		
		// 맵 만들
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) {
					ho.add(new Node(i,j));
				}else if(tmp == 2) {
					pi.add(new Node(i,j));
				}
			}
		}
		// 피자집 개수중 m 개 뽑겠
		
		pilen = pi.size();
		DFS(0,0);
		System.out.println(answer);
		
		
	}

}
