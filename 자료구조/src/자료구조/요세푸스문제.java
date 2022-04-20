package 자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제 {
	public static void main(String[] args) {
		// 7 3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result[] = new int[n];
		
		StringBuilder sb = new StringBuilder();
		sb.append("< ");
		
		//k번째제거
		//큐로도 가능하다
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			queue.add(i+1);
		}
		
		while(queue.size() > 1) {
			int flag = 0;
			
			for(int i=0; i<k-1; i++) {
				int tmp = queue.poll();
				queue.offer(tmp);
			}
			sb.append(queue.poll()).append(", ");				
		}
		sb.append(queue.poll()).append(" >");
		System.out.print(sb);
	}
	

}
