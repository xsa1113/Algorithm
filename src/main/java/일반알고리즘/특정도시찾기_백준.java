package 일반알고리즘;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 특정도시찾기_백준 {
	static int n, m, k, x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		x = sc.nextInt();
		
		int[] dis = new int[300001];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<Integer>());
			dis[i] = -1;
		}
		
		// x출발 도시 는 0으로 초기
		dis[x] = 0;
		
		// 1->2 , 1->3, 2->3 , 2->4
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b); 
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x); // 출발도시 
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			// ex) 1번을 출발지점으로 했으면 1번에서 갈수있는걸 다확인하
			for(int i=0; i<arr.get(tmp).size(); i++) {
				int next = arr.get(tmp).get(i);
				
				// 방문한적이 없으면
				if(dis[next] == -1) {
					dis[next] = dis[tmp] + 1; // 출발도시에서 next도시까지의 거리
					queue.add(next);
				}
			}
		}
		
		boolean chk = false;
		for(int i=0; i<=n; i++) {
			if(dis[i] == k) {
				System.out.println(i);
				chk = true;
			}
		}
		
		if(!chk) System.out.println(-1);
		
		
		
	}

}
